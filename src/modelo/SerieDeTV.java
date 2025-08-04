package src.modelo;
import java.util.ArrayList;
import java.util.List;

public class SerieDeTV extends ContenidoAudiovisual {
    private int totalTemporadas;
    private List<Temporada> temporadas;

    public SerieDeTV(String titulo, int duracionMinutos, String genero, int totalTemporadas) {
        super(titulo, duracionMinutos, genero);
        this.totalTemporadas = totalTemporadas;
        this.temporadas = new ArrayList<>();
    }

    public int getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(int totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }

    public List<Temporada> getTemporadas() {
        return new ArrayList<>(temporadas);
    }

    @Override
    public String obtenerDetallesEspecificos() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Total temporadas: ").append(totalTemporadas);
        
        if (!temporadas.isEmpty()) {
            detalles.append(" | Temporadas: ");
            for (int i = 0; i < temporadas.size(); i++) {
                if (i > 0) detalles.append(", ");
                detalles.append(temporadas.get(i).toString());
            }
        }
        return detalles.toString();
    }
}