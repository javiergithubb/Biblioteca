//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private ArrayList<Libro> librosPendientes;

    public Usuario(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.librosPendientes = new ArrayList();
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public ArrayList<Libro> getLibrosPendientes() {
        return this.librosPendientes;
    }

    public void addLibroPendiente(Libro libro) {
        this.librosPendientes.add(libro);
    }

    public void removeLibroPendiente(Libro libro) {
        this.librosPendientes.remove(libro);
    }
}
