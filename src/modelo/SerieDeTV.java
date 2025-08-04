package src.modelo;
import src.modelo.interfaces.ConTemporadas;
import java.util.ArrayList;
import java.util.List;

public class SerieDeTV extends ContenidoAudiovisual implements ConTemporadas {
    private int totalTemporadas;
    private List<Temporada> temporadas;

    public SerieDeTV(String titulo, int duracionMinutos, String genero, int totalTemporadas) {
        super(titulo, duracionMinutos, genero);
        this.totalTemporadas = totalTemporadas;
        this.temporadas = new ArrayList<>();
    }

    // Implementación ConTemporadas (ISP)
    @Override
    public void agregarTemporada(Temporada temporada) {
        if (temporada != null && !temporadas.contains(temporada)) {
            temporadas.add(temporada);
        }
    }

    @Override
    public List<Temporada> getTemporadas() { return new ArrayList<>(temporadas); }

    @Override
    public int getTotalTemporadas() { return totalTemporadas; }

    public void setTotalTemporadas(int totalTemporadas) { this.totalTemporadas = totalTemporadas; }

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
