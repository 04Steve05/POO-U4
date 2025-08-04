package src.modelo.interfaces;
import src.modelo.Temporada;
import java.util.List;

public interface ConTemporadas {
    void agregarTemporada(Temporada temporada);
    List<Temporada> getTemporadas();
    int getTotalTemporadas();
}