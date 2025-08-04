package src.modelo;

public class Temporada {
    private int numeroTemporada;
    private int cantidadEpisodios;

    public Temporada(int numeroTemporada, int cantidadEpisodios) {
        this.numeroTemporada = numeroTemporada;
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public int getNumeroTemporada() { return numeroTemporada; }
    public void setNumeroTemporada(int numeroTemporada) { this.numeroTemporada = numeroTemporada; }
    public int getCantidadEpisodios() { return cantidadEpisodios; }
    public void setCantidadEpisodios(int cantidadEpisodios) { this.cantidadEpisodios = cantidadEpisodios; }

    @Override
    public String toString() {
        return String.format("T%d (%d episodios)", numeroTemporada, cantidadEpisodios);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Temporada temporada = (Temporada) obj;
        return numeroTemporada == temporada.numeroTemporada;
    }

    @Override
    public int hashCode() {
        return numeroTemporada;
    }
}