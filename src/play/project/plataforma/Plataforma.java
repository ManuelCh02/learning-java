package play.project.plataforma;

import play.project.contenido.Pelicula;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido; // Agregación

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public void agregar(Pelicula elemento) {
        this.contenido.add(elemento);
    }

    public List<String> getTitulos() {
        return contenido.stream()
                .map(Pelicula::getTitulo)
                .toList();
    }

    public void eliminar(Pelicula elemento) {
        this.contenido.remove(elemento);
    }

    public Pelicula buscarPorTitulo(String titulo) {
        return contenido.stream()
                .filter(contenido -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Pelicula> buscarPorGenero(String genero) {
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equalsIgnoreCase(genero))
                .toList();
    }

    public List<Pelicula> getPopulares(int cantidad) {
        return contenido.stream()
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Pelicula> getMasPopulares() {
        return contenido.stream()
                .filter(contenido -> contenido.esPopular())
                .toList();
    }

    public int getDuracionTotal() {
        return contenido.stream()
                .mapToInt(Pelicula::getDuracion)
                .sum();
    }

    public Pelicula getMasLarga() {
        return contenido.stream()
                .max(Comparator.comparingInt(Pelicula::getDuracion))
                .orElse(null);
    }

    public Pelicula getMasCorta() {
        return contenido.stream()
                .min(Comparator.comparingInt(Pelicula::getDuracion))
                .orElse(null);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }
}
