package src.modelo;
import java.util.ArrayList;
import java.util.List;

public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private List<Actor> actores;

    public Pelicula(String titulo, int duracionMinutos, String genero, String estudio) {
        super(titulo, duracionMinutos, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public void agregarActor(Actor actor) {
        actores.add(actor);
    }

    public List<Actor> getActores() {
        return new ArrayList<>(actores);
    }

    @Override
    public String obtenerDetallesEspecificos() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Estudio: ").append(estudio);
        
        if (!actores.isEmpty()) {
            detalles.append(" | Actores: ");
            for (int i = 0; i < actores.size(); i++) {
                if (i > 0) detalles.append(", ");
                detalles.append(actores.get(i).getNombre());
            }
        }
        return detalles.toString();
    }
}
