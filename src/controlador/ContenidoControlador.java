package src.controlador;
import src.modelo.*;
import src.vista.ConsolaVista;
import java.util.ArrayList;
import java.util.List;

public class ContenidoControlador {
    private List<ContenidoAudiovisual> contenidos;
    private ConsolaVista vista;

    public ContenidoControlador() {
        this.contenidos = new ArrayList<>();
        this.vista = new ConsolaVista();
    }

    public void inicializarSistema() {
        vista.mostrarTitulo();
        cargarDatosPrueba();
        mostrarTodosLosContenidos();
    }

    private void cargarDatosPrueba() {
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
        vista.mostrarMensaje("Contenido agregado exitosamente: " + contenido.getTitulo());
    }

    public List<ContenidoAudiovisual> obtenerTodosLosContenidos() {
        return new ArrayList<>(contenidos);
    }
}