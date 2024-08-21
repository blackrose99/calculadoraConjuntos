package org.example.conjunto;

import java.util.Scanner;

public class Cadena {
    private static Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nMenú de Operaciones con Cadenas:");
            System.out.println("1: Obtener la longitud de la cadena");
            System.out.println("2: Reflexionar la cadena (invertir)");
            System.out.println("3: Potenciar la cadena");
            System.out.println("4: Concatenar dos cadenas");
            System.out.println("0: Salir al menú principal");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                sc.next(); // Limpiar el buffer
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    obtenerLongitud();
                    break;
                case 2:
                    reflexionarCadena();
                    break;
                case 3:
                    potenciarCadena();
                    break;
                case 4:
                    concatenarCadenas();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    private static void obtenerLongitud() {
        System.out.print("Ingrese la cadena: ");
        String cadena = sc.nextLine();
        System.out.println("La longitud de la cadena es: " + cadena.length());
    }

    private static void reflexionarCadena() {
        System.out.print("Ingrese la cadena: ");
        String cadena = sc.nextLine();
        String cadenaReflexionada = new StringBuilder(cadena).reverse().toString();
        System.out.println("La cadena reflexionada es: " + cadenaReflexionada);
    }

    private static void potenciarCadena() {
        System.out.print("Ingrese la cadena: ");
        String cadena = sc.nextLine();
        System.out.print("Ingrese el número de repeticiones: ");
        int repeticiones = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        String cadenaPotenciada = cadena.repeat(repeticiones);
        System.out.println("La cadena potenciada es: " + cadenaPotenciada);
    }

    private static void concatenarCadenas() {
        System.out.print("Ingrese la primera cadena: ");
        String cadena1 = sc.nextLine();
        System.out.print("Ingrese la segunda cadena: ");
        String cadena2 = sc.nextLine();
        String cadenaConcatenada = cadena1 + cadena2;
        System.out.println("La cadena concatenada es: " + cadenaConcatenada);
    }
}
