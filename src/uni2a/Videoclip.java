/**
 * Class Videoclip
 */
package src.uni2a;

// Subclase Videoclip que extiende de ContenidoAudiovisual
public class Videoclip extends ContenidoAudiovisual {
    private String artista;

    public Videoclip(String titulo, int duracionEnMinutos, String genero, String artista) {
        super(titulo, duracionEnMinutos, genero);
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Videoclip:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Artista: " + this.artista);
        System.out.println();
    }
}