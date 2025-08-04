package src.modelo;
import java.util.ArrayList;
import java.util.List;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private List<Investigador> investigadores;

    public Documental(String titulo, int duracionMinutos, String genero, String tema) {
        super(titulo, duracionMinutos, genero);
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

    public List<Investigador> getInvestigadores() {
        return new ArrayList<>(investigadores);
    }

    @Override
    public String obtenerDetallesEspecificos() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Tema: ").append(tema);
        
        if (!investigadores.isEmpty()) {
            detalles.append(" | Investigadores: ");
            for (int i = 0; i < investigadores.size(); i++) {
                if (i > 0) detalles.append(", ");
                detalles.append(investigadores.get(i).getNombre());
            }
        }
        return detalles.toString();
    }
}
