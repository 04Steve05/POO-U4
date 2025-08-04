package src.modelo.interfaces;
import src.modelo.Investigador;
import java.util.List;

public interface ConInvestigadores {
    void agregarInvestigador(Investigador investigador);
    List<Investigador> getInvestigadores();
    boolean tieneInvestigadores();
}