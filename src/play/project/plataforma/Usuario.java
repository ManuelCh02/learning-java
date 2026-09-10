package play.project.plataforma;

import play.project.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    private String nombre;
    private String email;
    private LocalDateTime fechaDeRegistro;

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

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getFechaDeRegistro() {
        return fechaDeRegistro;
    }
}
