package play.project;

import play.project.contenido.Pelicula;
import play.project.plataforma.Plataforma;
import play.project.util.ScannerUtils;

import java.util.List;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "Learning Java 🚀🔥 ";
    public static final String VERSION = "1.0.0";

    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_POR_TITULO = 3;
    public static final int BUSCAR_POR_GENERO = 4;
    public static final int VER_POPULARES = 5;
    public static final int VER_MAYOR_CALIFICACION = 6;
    public static final int VER_MAS_LARGA = 7;
    public static final int VER_MAS_CORTA = 8;
    public static final int ELIMINAR = 9;
    public static final int SALIR = 10;


    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + "v" + VERSION);

        cargarPeliculas(plataforma);

        System.out.println("Más de " + plataforma.getDuracionTotal() + " minutos de contenido!" + "\n");

        while(true){
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una de las siguientes opciones:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por título
                    4. Buscar por genero
                    5. Ver populares
                    6. Ver las de mayor calificación
                    7. Ver la más larga
                    8. Ver la más corta
                    9. Eliminar
                    10. Salir
                    """);

            switch (opcionElegida) {
                case AGREGAR -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido");
                    String genero = ScannerUtils.capturarTexto("Genero del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duración del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");

                    plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
                }
                case MOSTRAR_TODO -> {
                    List<String> titulos = plataforma.getTitulos();
                    titulos.forEach(System.out::println);
                }
                case BUSCAR_POR_TITULO -> {
                    String nombreBuscado = ScannerUtils.capturarTexto("Nombre del contenido a buscar: ");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreBuscado);

                    if (pelicula != null) {
                        System.out.println(pelicula.obtenerFichaTecnica());
                    } else {
                        System.out.println(nombreBuscado + " no existe dentro dentro de " + plataforma.getNombre());
                    }
                }
                case BUSCAR_POR_GENERO -> {
                    String generoBuscado = ScannerUtils.capturarTexto("Genero del contenido a buscar: ");
                    List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);

                    System.out.println(contenidoPorGenero.size() + " encontrados para el genero " + generoBuscado);
                    contenidoPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case VER_POPULARES -> {
                    int cantidad = ScannerUtils.capturarNumero("Cantidad de resultados a mostrar: ");
                    List<Pelicula> contenidoPopulares = plataforma.getPopulares(cantidad);
                    contenidoPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case VER_MAYOR_CALIFICACION -> {
                    List<Pelicula> masPopulares = plataforma.getMasPopulares();
                    masPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case VER_MAS_LARGA -> {
                    Pelicula masLarga = plataforma.getMasLarga();
                    System.out.println(masLarga.obtenerFichaTecnica() + "\n");
                }
                case VER_MAS_CORTA -> {
                    Pelicula masCorta = plataforma.getMasCorta();
                    System.out.println(masCorta.obtenerFichaTecnica() + "\n");
                }
                case  ELIMINAR -> {
                    String nombreAEliminar = ScannerUtils.capturarTexto("Nombre del contenido a eliminar: ");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreAEliminar);

                    if (pelicula != null) {
                        plataforma.eliminar(pelicula);
                        System.out.println(nombreAEliminar + " eliminado correctamente");
                    } else {
                        System.out.println(nombreAEliminar + " no existe dentro de " + plataforma.getNombre());
                    }
                }
                case SALIR -> System.exit(0);
            }
        }
    }

    private static void cargarPeliculas(Plataforma plataforma) {
        plataforma.agregar(new Pelicula("Shrek", 90, "Animada"));
        plataforma.agregar(new Pelicula("Inception", 148, "Ciencia Ficción"));
        plataforma.agregar(new Pelicula("Titanic", 195, "Drama"));
        plataforma.agregar(new Pelicula("John Wick", 101, "Acción"));
        plataforma.agregar(new Pelicula("Interestelar", 141, "Ciencia Ficción", 4));

    }
}
