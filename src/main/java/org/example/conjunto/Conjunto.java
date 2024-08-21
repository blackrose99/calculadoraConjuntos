package org.example.conjunto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Conjunto {
    private Set<String> elementos;
    private static Scanner sc = new Scanner(System.in);

    public Conjunto() {
        this.elementos = new HashSet<>();
    }

    public Conjunto(String[] elementos) {
        this.elementos = new HashSet<>();
        for (String elemento : elementos) {
            this.elementos.add(elemento);
        }
    }

    public boolean pertenece(String elemento) {
        return elementos.contains(elemento);
    }

    public Conjunto union(Conjunto otro) {
        Conjunto resultado = new Conjunto();
        resultado.elementos.addAll(this.elementos);
        resultado.elementos.addAll(otro.elementos);
        return resultado;
    }

    public Conjunto interseccion(Conjunto otro) {
        Conjunto resultado = new Conjunto();
        for (String elemento : this.elementos) {
            if (otro.elementos.contains(elemento)) {
                resultado.elementos.add(elemento);
            }
        }
        return resultado;
    }

    public Conjunto diferencia(Conjunto otro) {
        Conjunto resultado = new Conjunto();
        for (String elemento : this.elementos) {
            if (!otro.elementos.contains(elemento)) {
                resultado.elementos.add(elemento);
            }
        }
        return resultado;
    }

    public Conjunto diferenciaSimetrica(Conjunto otro) {
        Conjunto union = this.union(otro);
        Conjunto interseccion = this.interseccion(otro);
        return union.diferencia(interseccion);
    }

    public Conjunto complemento(Conjunto universo) {
        return universo.diferencia(this);
    }

    public void imprimir() {
        System.out.println("Elementos del conjunto: " + elementos);
    }

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nMenú de Operaciones con Conjuntos:");
            System.out.println("1: Registrar un conjunto y buscar un elemento");
            System.out.println("2: Unión de dos conjuntos");
            System.out.println("3: Intersección de dos conjuntos");
            System.out.println("4: Diferencia entre dos conjuntos");
            System.out.println("5: Diferencia Simétrica entre dos conjuntos");
            System.out.println("6: Complemento de un conjunto con respecto a un universo");
            System.out.println("0: Volver al Menú Principal");
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

        Conjunto resultado = a.union(b);
        System.out.println("Unión de los conjuntos:");
        resultado.imprimir();
    }

    private static void realizarInterseccion() {
        System.out.println("Registrar conjunto A:");
        Conjunto a = registrarConjunto();
        System.out.println("Registrar conjunto B:");
        Conjunto b = registrarConjunto();

        Conjunto resultado = a.interseccion(b);
        System.out.println("Intersección de los conjuntos:");
        resultado.imprimir();
    }

    private static void realizarDiferencia() {
        System.out.println("Registrar conjunto A:");
        Conjunto a = registrarConjunto();
        System.out.println("Registrar conjunto B:");
        Conjunto b = registrarConjunto();

        Conjunto resultado = a.diferencia(b);
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
