package play.project.plataforma;

import play.project.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    public String nombre;
    public String email;
    public LocalDateTime fechaDeRegistro;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.fechaDeRegistro = LocalDateTime.now();
    }

    public void ver(Pelicula pelicula){
        System.out.println(fechaDeRegistro);
        System.out.println(nombre + " está viendo...");
        pelicula.reproducir();
    }
}
