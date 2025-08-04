/**
 * Class Podcast
 */
package uni2a;

// Subclase Podcast que extiende de ContenidoAudiovisual
public class Podcast extends ContenidoAudiovisual {
    private String host;

    public Podcast(String titulo, int duracionEnMinutos, String genero, String host) {
        super(titulo, duracionEnMinutos, genero);
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Podcast:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Host: " + this.host);
        System.out.println();
    }
}