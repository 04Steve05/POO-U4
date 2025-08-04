package src.controlador;
import src.modelo.*;
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
            cargarDatosPorDefecto();
            guardarDatosEnArchivo();
        }
        
        mostrarTodosLosContenidos();
    }

    public void finalizarSistema() {
        if (guardarDatosEnArchivo()) {
            vista.mostrarMensaje("Sistema finalizado. Datos guardados correctamente.");
        } else {
            vista.mostrarError("Sistema finalizado con errores al guardar datos.");
        }
    }

    private void cargarDatosDesdeArchivo() {
        List<ContenidoAudiovisual> contenidosCargados = archivosServicio.cargarContenidos(ARCHIVO_DATOS);
        contenidos.addAll(contenidosCargados);
    }

    private boolean guardarDatosEnArchivo() {
        return archivosServicio.guardarContenidos(contenidos, ARCHIVO_DATOS);
    }

    private void cargarDatosPorDefecto() {
        crearPeliculaEjemplo();
        crearSerieEjemplo();
        crearDocumentalEjemplo();
        crearPodcastEjemplo();
        crearVideoclipEjemplo();
    }

    private void crearPeliculaEjemplo() {
        Pelicula pelicula = new Pelicula("Avatar", 125, "Acción", "20th Century Studios");
        pelicula.agregarActor(new Actor("Sam Worthington", 45));
        pelicula.agregarActor(new Actor("Zoe Saldana", 43));
        contenidos.add(pelicula);
    }

    private void crearSerieEjemplo() {
        SerieDeTV serie = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8);
        serie.agregarTemporada(new Temporada(1, 10));
        serie.agregarTemporada(new Temporada(2, 10));
        contenidos.add(serie);
    }

    private void crearDocumentalEjemplo() {
        Documental documental = new Documental("Cosmos", 45, "Ciencia", "Astronomía");
        documental.agregarInvestigador(new Investigador("Carl Sagan", "Astronomía"));
        documental.agregarInvestigador(new Investigador("Neil deGrasse", "Astrofísica"));
        contenidos.add(documental);
    }

    private void crearPodcastEjemplo() {
        Podcast podcast = new Podcast("Tech Talk", 30, "Tecnología", "Juan Pérez");
        contenidos.add(podcast);
    }

    private void crearVideoclipEjemplo() {
        Videoclip videoclip = new Videoclip("Bohemian Rhapsody", 6, "Rock", "Queen");
        contenidos.add(videoclip);
    }

    public void mostrarTodosLosContenidos() {
        vista.mostrarListaContenidos(contenidos);
    }

    public void agregarContenido(ContenidoAudiovisual contenido) {
        contenidos.add(contenido);
        if (guardarDatosEnArchivo()) {
            vista.mostrarMensaje("Contenido agregado y guardado: " + contenido.getTitulo());
        } else {
            vista.mostrarError("Contenido agregado pero error al guardar: " + contenido.getTitulo());
        }
    }

    public List<ContenidoAudiovisual> obtenerTodosLosContenidos() {
        return new ArrayList<>(contenidos);
    }

    public boolean eliminarContenido(int id) {
        boolean eliminado = contenidos.removeIf(c -> c.getId() == id);
        if (eliminado) {
            if (guardarDatosEnArchivo()) {
                vista.mostrarMensaje("Contenido eliminado correctamente.");
            } else {
                vista.mostrarError("Contenido eliminado pero error al guardar.");
            }
        }
        return eliminado;
    }
}