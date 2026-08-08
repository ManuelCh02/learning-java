package play.project;

import play.project.contenido.Pelicula;
import play.project.plataforma.Usuario;
import play.project.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "Learning Java 🚀🔥 ";
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        System.out.println(NOMBRE_PLATAFORMA + "v" + VERSION);

        String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
        String genero = ScannerUtils.capturarTexto("Genero del contenido");
        int duracion = ScannerUtils.capturarNumero("Duración del contenido");
        double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");

        Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion);

        System.out.println(pelicula.obtenerFichaTecnica());

        // Usuario
        Usuario usuario = new Usuario("Juan", "juan@gmail.com");
        usuario.ver(pelicula);
    }
}
