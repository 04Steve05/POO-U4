/**
 * Class SerieDeTV
 */
package src.uni2a;
import java.util.ArrayList;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private ArrayList<Temporada> listaTemporadas; // Agregación con Temporada

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaTemporadas = new ArrayList<>();
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void agregarTemporada(Temporada temporada) {
        listaTemporadas.add(temporada);
    }

    public ArrayList<Temporada> getListaTemporadas() {
        return listaTemporadas;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la Serie de TV:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + this.temporadas);
        System.out.print("Detalles temporadas: ");
        for (Temporada temp : listaTemporadas) {
            System.out.print("T" + temp.getNumero() + "(" + temp.getEpisodios() + "ep) ");
        }
        System.out.println("\n");
    }
}