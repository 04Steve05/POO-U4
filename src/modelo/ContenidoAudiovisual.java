package src.modelo;

public abstract class ContenidoAudiovisual {
    private static int contadorId = 0;
    private final int id;
    private String titulo;
    private int duracionMinutos;
    private String genero;

    public ContenidoAudiovisual(String titulo, int duracionMinutos, String genero) {
        this.id = ++contadorId;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    // Método abstracto
    public abstract String obtenerDetallesEspecificos();
    
    public String obtenerInformacionBasica() {
        return String.format("ID: %d | Título: %s | Duración: %d min | Género: %s", 
                           id, titulo, duracionMinutos, genero);
    }
}