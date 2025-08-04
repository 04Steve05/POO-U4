package src.modelo.interfaces;
import src.modelo.Actor;
import java.util.List;

public interface ConActores {
    void agregarActor(Actor actor);
    List<Actor> getActores();
    boolean tieneActores();
}