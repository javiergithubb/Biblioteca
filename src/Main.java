//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario1 = new Usuario("Juan", "Perez", "522431769", "juan@gmail.com");
        Usuario usuario2 = new Usuario("Javier", "Pastor", "687654221", "maria@gmail.com");
        Usuario usuario3 = new Usuario("Pedro", "Rodríguez", "456789123", "pedro@gmail.com");
        Usuario usuario4 = new Usuario("Ana", "Martínez", "654321987", "ana@gmail.com");
        Usuario usuario5 = new Usuario("Luisa", "Sánchez", "789123456", "luisa@gmail.com");
        Usuario usuario6 = new Usuario("Carlos", "López", "321987654", "carlos@gmail.com");
        Usuario usuario7 = new Usuario("Laura", "Fernández", "987654123", "laura@gmail.com");
        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);
        biblioteca.agregarUsuario(usuario3);
        biblioteca.agregarUsuario(usuario4);
        biblioteca.agregarUsuario(usuario5);
        biblioteca.agregarUsuario(usuario6);
        biblioteca.agregarUsuario(usuario7);

        Libro libro1 = new Libro("El principito", "Antoine", "9788431422609");
        Libro libro2 = new Libro("Don Quijote", "Miguel Cervantes", "9456424122609");
        Libro libro3 = new Libro("Crimen y castigo", "Fyodor Dostoevsky", "9780143058147");
        Libro libro4 = new Libro("Matar a un ruiseñor", "Harper Lee", "9780061120084");
        Libro libro5 = new Libro("La Odisea", "Homero", "9788491051647");
        Libro libro6 = new Libro("El retrato de Dorian Gray", "Oscar Wilde", "9788491051265");
        Libro libro7 = new Libro("Anna Karenina", "Lev Tolstói", "9780143035001");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarLibro(libro6);
        biblioteca.agregarLibro(libro7);

        int opcion;
        label54:
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Acceder a un usuario");
            System.out.println("2. Libros disponibles");
            System.out.println("3. Libros pendientes de devolver por un usuario");
            System.out.println("4. Pedir un libro");
            System.out.println("5. Devolver un libro");
            System.out.println("0. Salir");
            System.out.print("Introduzca el número de la opción que desea seleccionar:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            String tituloLibro;
            PrintStream var10000;
            String var10001;
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                case 1:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    Usuario usuario = encontrarUsuario(biblioteca, nombreUsuario);
                    if (usuario != null) {
                        var10000 = System.out;
                        var10001 = usuario.getNombre();
                        var10000.println("Usuario encontrado: " + var10001 + " " + usuario.getApellido());
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("Libros disponibles:");
                    Iterator var18 = biblioteca.getLibros().iterator();

                    while(true) {
                        if (!var18.hasNext()) {
                            continue label54;
                        }

                        Libro libro = (Libro)var18.next();
                        var10000 = System.out;
                        var10001 = libro.getTitulo();
                        var10000.println(var10001 + " - " + libro.getAutor() + " - ISBN: " + libro.getIsbn());
                    }
                case 3:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioPendientes = scanner.nextLine();
                    Usuario usuarioPendientes = encontrarUsuario(biblioteca, nombreUsuarioPendientes);
                    if (usuarioPendientes != null) {
                        System.out.println("Libros pendientes de devolver por " + usuarioPendientes.getNombre() + ":");
                        Iterator var20 = usuarioPendientes.getLibrosPendientes().iterator();

                        while(true) {
                            if (!var20.hasNext()) {
                                continue label54;
                            }

                            Libro libro = (Libro)var20.next();
                            var10000 = System.out;
                            var10001 = libro.getTitulo();
                            var10000.println(var10001 + " - " + libro.getAutor() + " - ISBN: " + libro.getIsbn());
                        }
                    }

                    System.out.println("Usuario no encontrado.");
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioPrestamo = scanner.nextLine();
                    Usuario usuarioPrestamo = encontrarUsuario(biblioteca, nombreUsuarioPrestamo);
                    if (usuarioPrestamo != null) {
                        System.out.print("Ingrese el título del libro que desea pedir: ");
                        tituloLibro = scanner.nextLine();
                        Libro libroPrestamo = encontrarLibro(biblioteca, tituloLibro);
                        if (libroPrestamo != null) {
                            usuarioPrestamo.addLibroPendiente(libroPrestamo);
                            var10000 = System.out;
                            var10001 = libroPrestamo.getTitulo();
                            var10000.println("Libro '" + var10001 + "' prestado correctamente a " + usuarioPrestamo.getNombre());
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del usuario: ");
                    tituloLibro = scanner.nextLine();
                    Usuario usuarioDevolucion = encontrarUsuario(biblioteca, tituloLibro);
                    if (usuarioDevolucion != null) {
                        System.out.print("Ingrese el título del libro que desea devolver: ");
                        String tituloLibroDevolucion = scanner.nextLine();
                        Libro libroDevolucion = encontrarLibro(usuarioDevolucion, tituloLibroDevolucion);
                        if (libroDevolucion != null) {
                            usuarioDevolucion.removeLibroPendiente(libroDevolucion);
                            var10000 = System.out;
                            var10001 = libroDevolucion.getTitulo();
                            var10000.println("Libro '" + var10001 + "' devuelto correctamente por " + usuarioDevolucion.getNombre());
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while(opcion != 0);

        scanner.close();
    }

    public static Usuario encontrarUsuario(Biblioteca biblioteca, String nombreUsuario) {
        Iterator var2 = biblioteca.getUsuarios().iterator();

        Usuario usuario;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            usuario = (Usuario)var2.next();
        } while(!usuario.getNombre().equalsIgnoreCase(nombreUsuario));

        return usuario;
    }

    public static Libro encontrarLibro(Biblioteca biblioteca, String titulo) {
        Iterator var2 = biblioteca.getLibros().iterator();

        Libro libro;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            libro = (Libro)var2.next();
        } while(!libro.getTitulo().equalsIgnoreCase(titulo));

        return libro;
    }

    public static Libro encontrarLibro(Usuario usuario, String titulo) {
        Iterator var2 = usuario.getLibrosPendientes().iterator();

        Libro libro;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            libro = (Libro)var2.next();
        } while(!libro.getTitulo().equalsIgnoreCase(titulo));

        return libro;
    }
}
