package src.modelo;

public class Actor {
    private String nombre;
    private int edad;

    public Actor(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return String.format("%s (%d años)", nombre, edad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Actor actor = (Actor) obj;
        return nombre.equals(actor.nombre) && edad == actor.edad;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() + edad;
    }
}