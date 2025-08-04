package src.modelo;
import src.modelo.interfaces.ConActores;
import java.util.ArrayList;
import java.util.List;

public class Pelicula extends ContenidoAudiovisual implements ConActores {
    private String estudio;
    private List<Actor> actores;

    public Pelicula(String titulo, int duracionMinutos, String genero, String estudio) {
        super(titulo, duracionMinutos, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public String getEstudio() { return estudio; }
    public void setEstudio(String estudio) { this.estudio = estudio; }

    // Implementación ConActores (ISP)
    @Override
    public void agregarActor(Actor actor) {
        if (actor != null && !actores.contains(actor)) {
            actores.add(actor);
        }
    }

    @Override
    public List<Actor> getActores() { return new ArrayList<>(actores); }

    @Override
    public boolean tieneActores() { return !actores.isEmpty(); }

    @Override
    public String obtenerDetallesEspecificos() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Estudio: ").append(estudio);
        
        if (tieneActores()) {
            detalles.append(" | Actores: ");
            for (int i = 0; i < actores.size(); i++) {
                if (i > 0) detalles.append(", ");
                detalles.append(actores.get(i).getNombre());
            }
        }
        return detalles.toString();
    }
}