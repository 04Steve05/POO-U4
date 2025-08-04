package src.modelo;

public class Videoclip extends ContenidoAudiovisual {
    private String artista;

    public Videoclip(String titulo, int duracionMinutos, String genero, String artista) {
        super(titulo, duracionMinutos, genero);
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String obtenerDetallesEspecificos() {
        return "Artista: " + artista;
    }
}