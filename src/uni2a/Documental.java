/**
 * Class Documental
 */
package uni2a;
import java.util.ArrayList;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private String tema;
    private ArrayList<Investigador> investigadores; // Composición con Investigador

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void agregarInvestigador(Investigador investigador) {
        investigadores.add(investigador);
    }

    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        System.out.print("Investigadores: ");
        for (Investigador inv : investigadores) {
            System.out.print(inv.getNombre() + "(" + inv.getEspecialidad() + ") ");
        }
        System.out.println("\n");
    }
}