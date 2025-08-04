package src.modelo;

public class Investigador {
    private String nombre;
    private String especialidad;

    public Investigador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String toString() {
        return String.format("%s (Especialidad: %s)", nombre, especialidad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Investigador investigador = (Investigador) obj;
        return nombre.equals(investigador.nombre) && especialidad.equals(investigador.especialidad);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() + especialidad.hashCode();
    }
}