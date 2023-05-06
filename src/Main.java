import entidades.Libro;
import service.LibreriaService;

import java.util.HashSet;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\t--Biblioteca--!");
        HashSet<Libro> libreria = new HashSet<>();
        LibreriaService ls = new LibreriaService();
        ls.menuLibreria(libreria);


    }

}