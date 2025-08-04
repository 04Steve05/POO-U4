package src;
import src.uni2a.*;

public class PruebaAudioVisual {
    public static void main(String[] args) {
        System.out.println("Sistema de Contenido Audiovisual");
        System.out.println(" ");

        // Crear película con actores
        Pelicula pelicula = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");
        pelicula.agregarActor(new Actor("Sam Worthington", 45));
        pelicula.agregarActor(new Actor("Zoe Saldana", 43));

        // Crear serie con temporadas
        SerieDeTV serie = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8);
        serie.agregarTemporada(new Temporada(1, 10));
        serie.agregarTemporada(new Temporada(2, 10));

        // Crear documental con investigadores
        Documental documental = new Documental("Cosmos", 45, "Science", "Astronomy");
        documental.agregarInvestigador(new Investigador("Carl Sagan", "Astronomía"));
        documental.agregarInvestigador(new Investigador("Neil deGrasse", "Astrofísica"));

        // Crear nuevas subclases
        Podcast podcast = new Podcast("Tech Talk", 30, "Tecnología", "Juan Pérez");
        Videoclip videoclip = new Videoclip("Bohemian Rhapsody", 6, "Rock", "Queen");

        // Array con todos los contenidos
        ContenidoAudiovisual[] contenidos = {pelicula, serie, documental, podcast, videoclip};

        // Mostrar detalles de todos los contenidos
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
    }
}