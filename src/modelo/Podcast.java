package src.modelo;

public class Podcast extends ContenidoAudiovisual {
    private String host;

    public Podcast(String titulo, int duracionMinutos, String genero, String host) {
        super(titulo, duracionMinutos, genero);
        this.host = host;
    }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    @Override
    public String obtenerDetallesEspecificos() {
        return "Host: " + host;
    }
}