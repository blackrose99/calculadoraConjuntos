package org.example.conjunto;

import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);

    public static void index() {
        int opcion;
        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1: Operaciones con Conjuntos");
            System.out.println("2: Operaciones con Cadenas");
            System.out.println("3: Operaciones con Lenguajes");
            System.out.println("0: Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                sc.next(); // Limpiar el buffer
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    Conjunto.mostrarMenu();
                    break;
                case 2:
                    Cadena.mostrarMenu();
                    break;
                case 3:
                    Lenguaje.mostrarMenu();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}
