//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList();
    private ArrayList<Libro> libros = new ArrayList();

    public Biblioteca() {
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }
}
