package src;
import src.controlador.ContenidoControlador;

public class Main {
    public static void main(String[] args) {
        ContenidoControlador controlador = new ContenidoControlador();
        
        // Hook para guardar al cerrar
        Runtime.getRuntime().addShutdownHook(new Thread(controlador::finalizarSistema));
        
        controlador.inicializarSistema();
    }
}