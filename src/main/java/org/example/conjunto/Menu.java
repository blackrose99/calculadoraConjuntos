package org.example.conjunto;

import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);

    public static void index() {
        int opcion;
        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1: Operaciones Alfabeticas");
            System.out.println("2: Operaciones con Cadenas");
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
                    menuConjuntos();
                    break;
                case 2:
                    menuCadenas();
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

    private static void menuConjuntos() {
        Conjunto a = new Conjunto();
        Conjunto b = new Conjunto();

        int opcion;
        do {
            System.out.println("\nMenu de Operaciones con Conjuntos:");
            System.out.println("1: Registrar un conjunto y buscar un elemento");
            System.out.println("2: Unión de dos conjuntos");
            System.out.println("3: Intersección de dos conjuntos");
            System.out.println("4: Diferencia entre dos conjuntos");
            System.out.println("5: Diferencia Simétrica entre dos conjuntos");
            System.out.println("6: Complemento de un conjunto con respecto a un universo");
            System.out.println("0: Volver al Menu Principal");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                sc.next(); // Limpiar el buffer
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarConjuntoYBuscarElemento();
                    break;
                case 2:
                    realizarUnion();
                    break;
                case 3:
                    realizarInterseccion();
                    break;
                case 4:
                    realizarDiferencia();
                    break;
                case 5:
                    realizarDiferenciaSimetrica();
                    break;
                case 6:
                    realizarComplemento();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuCadenas() {
        Cadena cadenaOps = new Cadena();

        int opcion;
        do {
            System.out.println("\nMenu de Operaciones con Cadenas:");
            System.out.println("1: Longitud de una cadena");
            System.out.println("2: Reflexión de una cadena");
            System.out.println("3: Potenciación de una cadena");
            System.out.println("4: Concatenación de dos cadenas");
            System.out.println("0: Volver al Menu Principal");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                sc.next(); // Limpiar el buffer
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cadena: ");
                    String cadena = sc.nextLine();
                    System.out.println("Longitud de la cadena: " + cadenaOps.longitud(cadena));
                    break;
                case 2:
                    System.out.print("Ingrese la cadena: ");
                    cadena = sc.nextLine();
                    System.out.println("Reflexión de la cadena: " + cadenaOps.reflexion(cadena));
                    break;
                case 3:
                    System.out.print("Ingrese la cadena: ");
                    cadena = sc.nextLine();
                    System.out.print("Ingrese el número de veces que se desea potenciar: ");
                    int n = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer
                    System.out.println("Cadena potenciada: " + cadenaOps.potenciacion(cadena, n));
                    break;
                case 4:
                    System.out.print("Ingrese la primera cadena: ");
                    String cadena1 = sc.nextLine();
                    System.out.print("Ingrese la segunda cadena: ");
                    String cadena2 = sc.nextLine();
                    System.out.println("Concatenación de las cadenas: " + cadenaOps.concatenacion(cadena1, cadena2));
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void registrarConjuntoYBuscarElemento() {
        System.out.println("Registrar conjunto:");
        Conjunto conjunto = registrarConjunto();

        System.out.print("Ingrese el elemento a buscar: ");
        String elemento = sc.nextLine();

        boolean pertenece = conjunto.pertenece(elemento);
        System.out.println("El elemento '" + elemento + "' " + (pertenece ? "pertenece" : "no pertenece") + " al conjunto.");
    }

    private static void realizarUnion() {
        System.out.println("Registrar conjunto A:");
        Conjunto a = registrarConjunto();
        System.out.println("Registrar conjunto B:");
        Conjunto b = registrarConjunto();

        Conjunto resultado = a.Union(b);
        System.out.println("Unión de los conjuntos:");
        resultado.imprimir();
    }

    private static void realizarInterseccion() {
        System.out.println("Registrar conjunto A:");
        Conjunto a = registrarConjunto();
        System.out.println("Registrar conjunto B:");
        Conjunto b = registrarConjunto();

        Conjunto resultado = a.Interseccion(b);
        System.out.println("Intersección de los conjuntos:");
        resultado.imprimir();
    }

    private static void realizarDiferencia() {
        System.out.println("Registrar conjunto A:");
        Conjunto a = registrarConjunto();
        System.out.println("Registrar conjunto B:");
        Conjunto b = registrarConjunto();

        Conjunto resultado = a.Diferencia(b);
        System.out.println("Diferencia de los conjuntos:");
        resultado.imprimir();
    }

    private static void realizarDiferenciaSimetrica() {
        System.out.println("Registrar conjunto A:");
        Conjunto a = registrarConjunto();
        System.out.println("Registrar conjunto B:");
        Conjunto b = registrarConjunto();

        Conjunto resultado = a.diferenciaSimetrica(b);
        System.out.println("Diferencia Simétrica de los conjuntos:");
        resultado.imprimir();
    }

    private static void realizarComplemento() {
        System.out.println("Registrar el conjunto:");
        Conjunto conjunto = registrarConjunto();

        System.out.print("Ingrese el universo de elementos separados por espacio: ");
        String universoInput = sc.nextLine();
        Conjunto universo = new Conjunto(universoInput.split("\\s+"));

        Conjunto complemento = conjunto.complemento(universo);
        System.out.println("Complemento del conjunto:");
        complemento.imprimir();
    }

    private static Conjunto registrarConjunto() {
        System.out.print("Ingrese los elementos del conjunto separados por espacio: ");
        String input = sc.nextLine();
        String[] elementos = input.split("\\s+"); // Permitir espacios múltiples
        return new Conjunto(elementos);
    }
}
