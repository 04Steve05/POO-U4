package src.servicio;
import src.modelo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVArchivosServicio implements ArchivosServicio {
    private static final String SEPARADOR_CSV = ",";
    private static final String CABECERA_CSV = "ID,Tipo,Titulo,Duracion,Genero,Detalle1,Detalle2,Detalle3";

    @Override
    public List<ContenidoAudiovisual> cargarContenidos(String rutaArchivo) {
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        
        if (!archivoExiste(rutaArchivo)) {
            System.out.println("⚠ Primera ejecución - creando archivo: " + rutaArchivo);
            return contenidos;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = reader.readLine(); // Saltar cabecera
            
            while ((linea = reader.readLine()) != null) {
                ContenidoAudiovisual contenido = procesarLineaCSV(linea);
                if (contenido != null) {
                    contenidos.add(contenido);
                }
            }
            
            System.out.println("✓ Cargados " + contenidos.size() + " contenidos desde: " + rutaArchivo);
            
        } catch (IOException e) {
            System.err.println("✗ Error leyendo archivo: " + e.getMessage());
        }
        
        return contenidos;
    }

    @Override
    public boolean guardarContenidos(List<ContenidoAudiovisual> contenidos, String rutaArchivo) {
        if (!crearDirectorioSiNoExiste(rutaArchivo)) {
            return false;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            writer.println(CABECERA_CSV);
            
            for (ContenidoAudiovisual contenido : contenidos) {
                String lineaCSV = convertirALineaCSV(contenido);
                writer.println(lineaCSV);
            }
            
            System.out.println("✓ Guardados " + contenidos.size() + " contenidos en: " + rutaArchivo);
            return true;
            
        } catch (IOException e) {
            System.err.println("✗ Error guardando archivo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean archivoExiste(String rutaArchivo) {
        return new File(rutaArchivo).exists();
    }

    private ContenidoAudiovisual procesarLineaCSV(String linea) {
        if (linea == null || linea.trim().isEmpty()) {
            return null;
        }

        String[] campos = linea.split(SEPARADOR_CSV);
        if (campos.length < 6) {
            return null;
        }

        try {
            String tipo = campos[1].trim();
            String titulo = campos[2].trim();
            int duracion = Integer.parseInt(campos[3].trim());
            String genero = campos[4].trim();

            switch (tipo.toUpperCase()) {
                case "PELICULA":
                    return crearPelicula(titulo, duracion, genero, campos);
                case "SERIEDETV":
                    return crearSerie(titulo, duracion, genero, campos);
                case "DOCUMENTAL":
                    return crearDocumental(titulo, duracion, genero, campos);
                case "PODCAST":
                    return crearPodcast(titulo, duracion, genero, campos);
                case "VIDEOCLIP":
                    return crearVideoclip(titulo, duracion, genero, campos);
                default:
                    System.err.println("Tipo desconocido: " + tipo);
                    return null;
            }
        } catch (NumberFormatException e) {
            System.err.println("Error procesando línea: " + linea);
            return null;
        }
    }

    private Pelicula crearPelicula(String titulo, int duracion, String genero, String[] campos) {
        String estudio = campos.length > 5 ? campos[5].trim() : "Desconocido";
        Pelicula pelicula = new Pelicula(titulo, duracion, genero, estudio);
        
        if (campos.length > 6 && !campos[6].trim().isEmpty()) {
            String[] actores = campos[6].split(";");
            for (String actorInfo : actores) {
                String[] datosActor = actorInfo.split(":");
                if (datosActor.length == 2) {
                    try {
                        pelicula.agregarActor(new Actor(datosActor[0].trim(), 
                                                     Integer.parseInt(datosActor[1].trim())));
                    } catch (NumberFormatException e) {
                        pelicula.agregarActor(new Actor(datosActor[0].trim(), 0));
                    }
                }
            }
        }
        
        return pelicula;
    }

    private SerieDeTV crearSerie(String titulo, int duracion, String genero, String[] campos) {
        int totalTemporadas = campos.length > 5 ? 
            Integer.parseInt(campos[5].trim()) : 1;
        SerieDeTV serie = new SerieDeTV(titulo, duracion, genero, totalTemporadas);
        
        if (campos.length > 6 && !campos[6].trim().isEmpty()) {
            String[] temporadas = campos[6].split(";");
            for (String tempInfo : temporadas) {
                String[] datosTemp = tempInfo.split(":");
                if (datosTemp.length == 2) {
                    try {
                        serie.agregarTemporada(new Temporada(
                            Integer.parseInt(datosTemp[0].trim()),
                            Integer.parseInt(datosTemp[1].trim())));
                    } catch (NumberFormatException e) {
                        // Ignorar temporada mal formateada
                    }
                }
            }
        }
        
        return serie;
    }

    private Documental crearDocumental(String titulo, int duracion, String genero, String[] campos) {
        String tema = campos.length > 5 ? campos[5].trim() : "General";
        Documental documental = new Documental(titulo, duracion, genero, tema);
        
        if (campos.length > 6 && !campos[6].trim().isEmpty()) {
            String[] investigadores = campos[6].split(";");
            for (String invInfo : investigadores) {
                String[] datosInv = invInfo.split(":");
                if (datosInv.length == 2) {
                    documental.agregarInvestigador(new Investigador(
                        datosInv[0].trim(), datosInv[1].trim()));
                }
            }
        }
        
        return documental;
    }

    private Podcast crearPodcast(String titulo, int duracion, String genero, String[] campos) {
        String host = campos.length > 5 ? campos[5].trim() : "Desconocido";
        return new Podcast(titulo, duracion, genero, host);
    }

    private Videoclip crearVideoclip(String titulo, int duracion, String genero, String[] campos) {
        String artista = campos.length > 5 ? campos[5].trim() : "Desconocido";
        return new Videoclip(titulo, duracion, genero, artista);
    }

    private String convertirALineaCSV(ContenidoAudiovisual contenido) {
        StringBuilder sb = new StringBuilder();
        sb.append(contenido.getId()).append(SEPARADOR_CSV);
        sb.append(contenido.getClass().getSimpleName()).append(SEPARADOR_CSV);
        sb.append(escaparCSV(contenido.getTitulo())).append(SEPARADOR_CSV);
        sb.append(contenido.getDuracionMinutos()).append(SEPARADOR_CSV);
        sb.append(escaparCSV(contenido.getGenero())).append(SEPARADOR_CSV);

        if (contenido instanceof Pelicula) {
            agregarDatosPelicula(sb, (Pelicula) contenido);
        } else if (contenido instanceof SerieDeTV) {
            agregarDatosSerie(sb, (SerieDeTV) contenido);
        } else if (contenido instanceof Documental) {
            agregarDatosDocumental(sb, (Documental) contenido);
        } else if (contenido instanceof Podcast) {
            sb.append(escaparCSV(((Podcast) contenido).getHost()));
        } else if (contenido instanceof Videoclip) {
            sb.append(escaparCSV(((Videoclip) contenido).getArtista()));
        }

        return sb.toString();
    }

    private void agregarDatosPelicula(StringBuilder sb, Pelicula pelicula) {
        sb.append(escaparCSV(pelicula.getEstudio())).append(SEPARADOR_CSV);
        
        List<Actor> actores = pelicula.getActores();
        if (!actores.isEmpty()) {
            for (int i = 0; i < actores.size(); i++) {
                if (i > 0) sb.append(";");
                sb.append(actores.get(i).getNombre())
                  .append(":")
                  .append(actores.get(i).getEdad());
            }
        }
    }

    private void agregarDatosSerie(StringBuilder sb, SerieDeTV serie) {
        sb.append(serie.getTotalTemporadas()).append(SEPARADOR_CSV);
        
        List<Temporada> temporadas = serie.getTemporadas();
        if (!temporadas.isEmpty()) {
            for (int i = 0; i < temporadas.size(); i++) {
                if (i > 0) sb.append(";");
                sb.append(temporadas.get(i).getNumeroTemporada())
                  .append(":")
                  .append(temporadas.get(i).getCantidadEpisodios());
            }
        }
    }

    private void agregarDatosDocumental(StringBuilder sb, Documental documental) {
        sb.append(escaparCSV(documental.getTema())).append(SEPARADOR_CSV);
        
        List<Investigador> investigadores = documental.getInvestigadores();
        if (!investigadores.isEmpty()) {
            for (int i = 0; i < investigadores.size(); i++) {
                if (i > 0) sb.append(";");
                sb.append(investigadores.get(i).getNombre())
                  .append(":")
                  .append(investigadores.get(i).getEspecialidad());
            }
        }
    }

    private String escaparCSV(String texto) {
        if (texto == null) return "";
        if (texto.contains(",") || texto.contains("\"") || texto.contains("\n")) {
            return "\"" + texto.replace("\"", "\"\"") + "\"";
        }
        return texto;
    }

    private boolean crearDirectorioSiNoExiste(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        File directorio = archivo.getParentFile();
        
        if (directorio != null && !directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("✓ Directorio creado: " + directorio.getPath());
                return true;
            } else {
                System.err.println("✗ No se pudo crear directorio: " + directorio.getPath());
                return false;
            }
        }
        return true;
    }
}