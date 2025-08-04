package src.controlador;
import src.modelo.*;
import src.modelo.factory.ContenidoFactory;
import src.vista.ConsolaVista;
import src.servicio.ArchivosServicio;
import src.servicio.CSVArchivosServicio;
import java.util.ArrayList;
import java.util.List;

public class ContenidoControlador {
    private static final String ARCHIVO_DATOS = "datos/contenidos.csv";
    
    private List<ContenidoAudiovisual> contenidos;
    private ConsolaVista vista;
    private ArchivosServicio archivosServicio;

    public ContenidoControlador() {
        this.contenidos = new ArrayList<>();
        this.vista = new ConsolaVista();
        this.archivosServicio = new CSVArchivosServicio();
    }

    public void inicializarSistema() {
        vista.mostrarTitulo();
        cargarDatosDesdeArchivo();
        
        if (contenidos.isEmpty()) {
            vista.mostrarMensaje("Primera ejecución. Creando contenido de ejemplo...");
            cargarDatosEjemplo();
            guardarDatosEnArchivo();
        }
        
        mostrarTodosLosContenidos();
    }

    private void cargarDatosDesdeArchivo() {
        List<ContenidoAudiovisual> contenidosCargados = archivosServicio.cargarContenidos(ARCHIVO_DATOS);
        contenidos.addAll(contenidosCargados);
    }

    private boolean guardarDatosEnArchivo() {
        return archivosServicio.guardarContenidos(contenidos, ARCHIVO_DATOS);
    }

    private void cargarDatosEjemplo() {
        contenidos.add(ContenidoFactory.crearContenido("PELICULA", "Avatar", 125, 
                      "Acción", "20th Century Studios"));
        contenidos.add(ContenidoFactory.crearContenido("SERIEDETV", "Game of Thrones", 60, 
                      "Fantasy", "8"));
        contenidos.add(ContenidoFactory.crearContenido("DOCUMENTAL", "Cosmos", 45, 
                      "Ciencia", "Astronomía"));
        contenidos.add(ContenidoFactory.crearContenido("PODCAST", "Tech Talk", 30, 
                      "Tecnología", "Juan Pérez"));
        contenidos.add(ContenidoFactory.crearContenido("VIDEOCLIP", "Bohemian Rhapsody", 6, 
                      "Rock", "Queen"));

        agregarDatosEspecificos();
    }

    private void agregarDatosEspecificos() {
        for (ContenidoAudiovisual contenido : contenidos) {
            if (contenido instanceof Pelicula) {
                Pelicula pelicula = (Pelicula) contenido;
                pelicula.agregarActor(new Actor("Sam Worthington", 45));
                pelicula.agregarActor(new Actor("Zoe Saldana", 43));
            } else if (contenido instanceof SerieDeTV) {
                SerieDeTV serie = (SerieDeTV) contenido;
                serie.agregarTemporada(new Temporada(1, 10));
                serie.agregarTemporada(new Temporada(2, 10));
            } else if (contenido instanceof Documental) {
                Documental documental = (Documental) contenido;
                documental.agregarInvestigador(new Investigador("Carl Sagan", "Astronomía"));
                documental.agregarInvestigador(new Investigador("Neil deGrasse", "Astrofísica"));
            }
        }
    }

    public void finalizarSistema() {
        if (guardarDatosEnArchivo()) {
            vista.mostrarMensaje("Sistema finalizado. Datos guardados correctamente.");
        } else {
            vista.mostrarError("Sistema finalizado con errores al guardar datos.");
        }
    }

    public void mostrarTodosLosContenidos() {
        vista.mostrarListaContenidos(contenidos);
    }

    public void agregarContenido(ContenidoAudiovisual contenido) {
        if (contenido != null) {
            contenidos.add(contenido);
            if (guardarDatosEnArchivo()) {
                vista.mostrarMensaje("Contenido agregado y guardado: " + contenido.getTitulo());
            } else {
                vista.mostrarError("Contenido agregado pero error al guardar: " + contenido.getTitulo());
            }
        }
    }

    public List<ContenidoAudiovisual> obtenerTodosLosContenidos() {
        return new ArrayList<>(contenidos);
    }

    public boolean eliminarContenido(int id) {
        boolean eliminado = contenidos.removeIf(c -> c.getId() == id);
        if (eliminado && guardarDatosEnArchivo()) {
            vista.mostrarMensaje("Contenido eliminado correctamente.");
        }
        return eliminado;
    }
}