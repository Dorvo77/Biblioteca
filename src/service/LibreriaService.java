package service;

import entidades.Libro;

import java.util.HashSet;
import java.util.Scanner;

public class LibreriaService {
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public Libro crearLibro(){
        System.out.println("\tAlta de libro.");
        System.out.println("> Ingrese el TITULO: ");
        String tit = sc.next();
        System.out.println("> Ingrese el AUTOR: ");
        String aut = sc.next();
        System.out.println("> Ingrese la cantidad de ejemplares: ");
        Integer cant = sc.nextInt();
        return new Libro(tit,aut,cant);
    }
    public void cargarLibro(HashSet<Libro> lib){
        lib.add(crearLibro());
    }
    public void menuLibreria(HashSet<Libro> lib){

        int op=0;
        char continua;
        while (op!=5){
            System.out.println("\t---MENU LIBRERIA---");
            System.out.println("1) ALTA DE LIBRO ");
            System.out.println("2) PRESTAR LIBRO");
            System.out.println("3) DEVOLVER LIBRO");
            System.out.println("4) MOSTRAR LIBROS");
            System.out.println("5) -- SALIR --");
            System.out.print(">Ingrese opcion: _ ");
            op = sc.nextInt();
            switch (op){
                case 1:
                    do {
                        cargarLibro(lib);
                        System.out.println("Desea ingresar otro libro?? y/n");
                        continua=sc.next().charAt(0);
                    }while (continua!='n' && continua != 'N');
                    break;
                case 2:
                    System.out.println(prestamo(lib));
                    break;
                case 3:
                    System.out.println(devolucion(lib));
                    break;
                case 4:
                    mostrarLibros(lib);
                    break;
                case 5:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }
        }
    }

    public void mostrarLibros(HashSet<Libro> lib) {
        for (Libro libro: lib) {
            System.out.println(libro);
        }
    }
    /*
    * El método se incrementa de a uno, como un carrito de compras, el
    * atributo cantprestada
    */
    public boolean prestamo(HashSet<Libro> lib){

        System.out.println("> Ingrese el libro que desea alquilar:");
        String libroUser = sc.next();
        for (Libro libro: lib) {
            if(libro.getTitulo().equalsIgnoreCase(libroUser) && libro.getNroEjemplares()>0){
                libro.prestaLibro();
                System.out.println("# Libro entregado...");
                return true;
            }
        }
        System.out.println("# Libro no disponible...");
        return false;
    }
    public boolean devolucion(HashSet<Libro> lib) {
        boolean flag=false;
        System.out.println("> Ingrese el libro que desea devolve:");
        String libroUser = sc.next();
        for (Libro libro : lib) {
            if (libro.getTitulo().equalsIgnoreCase(libroUser)) {
                flag=true;
                if(libro.devuelveLibro()) {
                    System.out.println("# Libro devuelto, gracias.");
                    return true;
                }else {
                    System.out.println("# No hay ejemplares prestados...De donde lo sacaste?? mm..");
                    break;
                }
            }
        }
        if(!flag){
            System.out.println("Libro no disponible en la BIBLIOTECA");
        }
        return false;
    }


}
