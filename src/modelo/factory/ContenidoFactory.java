package src.modelo.factory;
import src.modelo.*;

public abstract class ContenidoFactory {
    
    public static ContenidoAudiovisual crearContenido(String tipo, String titulo, 
                                                     int duracion, String genero, 
                                                     String... parametros) {
        switch (tipo.toUpperCase()) {
            case "PELICULA":
                return crearPelicula(titulo, duracion, genero, parametros);
            case "SERIEDETV":
                return crearSerie(titulo, duracion, genero, parametros);
            case "DOCUMENTAL":
                return crearDocumental(titulo, duracion, genero, parametros);
            case "PODCAST":
                return crearPodcast(titulo, duracion, genero, parametros);
            case "VIDEOCLIP":
                return crearVideoclip(titulo, duracion, genero, parametros);
            default:
                throw new IllegalArgumentException("Tipo de contenido no soportado: " + tipo);
        }
    }

    private static Pelicula crearPelicula(String titulo, int duracion, String genero, String[] params) {
        String estudio = params.length > 0 ? params[0] : "Desconocido";
        return new Pelicula(titulo, duracion, genero, estudio);
    }

    private static SerieDeTV crearSerie(String titulo, int duracion, String genero, String[] params) {
        int temporadas = params.length > 0 ? Integer.parseInt(params[0]) : 1;
        return new SerieDeTV(titulo, duracion, genero, temporadas);
    }

    private static Documental crearDocumental(String titulo, int duracion, String genero, String[] params) {
        String tema = params.length > 0 ? params[0] : "General";
        return new Documental(titulo, duracion, genero, tema);
    }

    private static Podcast crearPodcast(String titulo, int duracion, String genero, String[] params) {
        String host = params.length > 0 ? params[0] : "Desconocido";
        return new Podcast(titulo, duracion, genero, host);
    }

    private static Videoclip crearVideoclip(String titulo, int duracion, String genero, String[] params) {
        String artista = params.length > 0 ? params[0] : "Desconocido";
        return new Videoclip(titulo, duracion, genero, artista);
    }
}