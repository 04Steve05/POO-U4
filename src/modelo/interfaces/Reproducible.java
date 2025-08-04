package src.modelo.interfaces;

public interface Reproducible {
    void reproducir();
    void pausar();
    void detener();
    boolean estaReproduciendo();
}