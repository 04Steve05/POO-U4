package src.servicio;
import src.modelo.ContenidoAudiovisual;
import java.util.List;

public interface ArchivosServicio {
    List<ContenidoAudiovisual> cargarContenidos(String rutaArchivo);
    boolean guardarContenidos(List<ContenidoAudiovisual> contenidos, String rutaArchivo);
    boolean archivoExiste(String rutaArchivo);
}