package src;
import src.controlador.ContenidoControlador;

public class Main {
    public static void main(String[] args) {
        ContenidoControlador controlador = new ContenidoControlador();
        
        Runtime.getRuntime().addShutdownHook(new Thread(controlador::finalizarSistema));
        
        controlador.inicializarSistema();
    }
}