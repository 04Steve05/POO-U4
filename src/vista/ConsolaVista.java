package src.vista;
import src.modelo.ContenidoAudiovisual;
import java.util.List;

public class ConsolaVista {
    private static final String SEPARADOR = "═".repeat(60);
    

    public void mostrarTitulo() {
        System.out.println(SEPARADOR);
        System.out.println("    SISTEMA DE GESTIÓN DE CONTENIDO AUDIOVISUAL");
        System.out.println(SEPARADOR);
        System.out.println();
    }

    public void mostrarContenido(ContenidoAudiovisual contenido) {
        String tipoContenido = obtenerTipoContenido(contenido);
        
        System.out.println(tipoContenido + " " );
        System.out.println(contenido.obtenerInformacionBasica());
        System.out.println(contenido.obtenerDetallesEspecificos());
    
        System.out.println();
    }

    public void mostrarListaContenidos(List<ContenidoAudiovisual> contenidos) {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenidos disponibles.");
            return;
        }

        System.out.println("Total de contenidos: " + contenidos.size());
        System.out.println();

        for (ContenidoAudiovisual contenido : contenidos) {
            mostrarContenido(contenido);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("► " + mensaje);
        System.out.println();
    }

    public void mostrarError(String error) {
        System.err.println("✗ ERROR: " + error);
        System.err.println();
    }

    private String obtenerTipoContenido(ContenidoAudiovisual contenido) {
        return contenido.getClass().getSimpleName().toUpperCase();
    }
}
