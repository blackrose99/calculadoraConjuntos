package org.example.conjunto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lenguaje {
    private List<String> items;

    // Constructor que acepta una lista de cadenas
    public Lenguaje(List<String> items) {
        this.items = new ArrayList<>(items);
    }

    // Constructor que acepta un array de cadenas
    public Lenguaje(String[] items) {
        this.items = new ArrayList<>(Arrays.asList(items));
    }

    // Constructor sin parámetros para crear un lenguaje vacío
    public Lenguaje() {
        this.items = new ArrayList<>();
    }

    // Método para mostrar el menú
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        List<Lenguaje> lenguajes = new ArrayList<>();
        int opcion;
        do {
            System.out.println("\n--- Menú de Operaciones ---");
            System.out.println("1. Crear Lenguaje");
            System.out.println("2. Concatenar Lenguajes");
            System.out.println("3. Potenciar Lenguaje");
            System.out.println("4. Inversión de Lenguaje");
            System.out.println("5. Unión de Lenguajes");
            System.out.println("6. Intersección de Lenguajes");
            System.out.println("7. Resta de Lenguajes (this - otro)");
            System.out.println("8. Resta de Lenguajes en Ambos Sentidos (this - otro) y (otro - this)");
            System.out.println("9. Cerradura de Kleene (CK)");
            System.out.println("10. Cerradura Positiva (CP)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // Crear un nuevo lenguaje
                    List<String> datos = solicitarDatos("Lenguaje");
                    Lenguaje nuevoLenguaje = new Lenguaje(datos);
                    lenguajes.add(nuevoLenguaje);
                    System.out.println("Lenguaje creado.");
                    break;
                case 2:
                    // Concatenar lenguajes
                    if (lenguajes.size() < 2) {
                        System.out.println("Se necesitan al menos dos lenguajes para concatenar.");
                    } else {
                        Lenguaje resultado = lenguajes.get(0);
                        for (int i = 1; i < lenguajes.size(); i++) {
                            resultado = resultado.concatenar(lenguajes.get(i));
                        }
                        System.out.print("Resultado de la concatenación: ");
                        resultado.imprimir();
                    }
                    break;
                case 3:
                    // Potenciar un lenguaje
                    if (lenguajes.size() < 1) {
                        System.out.println("Se necesita al menos un lenguaje para potenciar.");
                    } else {
                        System.out.print("Ingrese el número de repeticiones: ");
                        int veces = scanner.nextInt();
                        scanner.nextLine();  // Consumir el salto de línea
                        Lenguaje resultado = lenguajes.get(0).potenciar(veces);
                        System.out.print("Resultado de la potenciación: ");
                        resultado.imprimir();
                    }
                    break;
                case 4:
                    // Inversión de un lenguaje
                    if (lenguajes.size() < 1) {
                        System.out.println("Se necesita al menos un lenguaje para invertir.");
                    } else {
                        Lenguaje resultado = lenguajes.get(0).inversa();
                        System.out.print("Resultado de la inversión: ");
                        resultado.imprimir();
                    }
                    break;
                case 5:
                    // Unión de lenguajes
                    if (lenguajes.size() < 2) {
                        System.out.println("Se necesitan al menos dos lenguajes para la unión.");
                    } else {
                        Lenguaje resultado = lenguajes.get(0);
                        for (int i = 1; i < lenguajes.size(); i++) {
                            resultado = resultado.union(lenguajes.get(i));
                        }
                        System.out.print("Resultado de la unión: ");
                        resultado.imprimir();
                    }
                    break;
                case 6:
                    // Intersección de lenguajes
                    if (lenguajes.size() < 2) {
                        System.out.println("Se necesitan al menos dos lenguajes para la intersección.");
                    } else {
                        Lenguaje resultado = lenguajes.get(0);
                        for (int i = 1; i < lenguajes.size(); i++) {
                            resultado = resultado.interseccion(lenguajes.get(i));
                        }
                        System.out.print("Resultado de la intersección: ");
                        resultado.imprimir();
                    }
                    break;
                case 7:
                    // Resta de lenguajes
                    if (lenguajes.size() < 2) {
                        System.out.println("Se necesitan al menos dos lenguajes para la resta.");
                    } else {
                        Lenguaje resultado = lenguajes.get(0).resta(lenguajes.get(1));
                        System.out.print("Resultado de la resta (this - otro): ");
                        resultado.imprimir();
                    }
                    break;
                case 8:
                    // Resta en ambos sentidos
                    if (lenguajes.size() < 2) {
                        System.out.println("Se necesitan al menos dos lenguajes para la resta en ambos sentidos.");
                    } else {
                        Lenguaje resultado = lenguajes.get(0).restaAmbosSentidos(lenguajes.get(1));
                        System.out.print("Resultado de la resta en ambos sentidos: ");
                        resultado.imprimir();
                    }
                    break;
                case 9:
                    // Cerradura de Kleene (CK)
                    if (lenguajes.size() < 1) {
                        System.out.println("Se necesita al menos un lenguaje para aplicar la cerradura de Kleene.");
                    } else {
                        Lenguaje resultado = lenguajes.get(0).cerraduraKleene();
                        System.out.print("Resultado de la cerradura de Kleene (CK): ");
                        resultado.imprimir();
                    }
                    break;
                case 10:
                    // Cerradura Positiva (CP)
                    if (lenguajes.size() < 1) {
                        System.out.println("Se necesita al menos un lenguaje para aplicar la cerradura positiva.");
                    } else {
                        Lenguaje resultado = lenguajes.get(0).cerraduraPositiva();
                        System.out.print("Resultado de la cerradura positiva (CP): ");
                        resultado.imprimir();
                    }
                    break;
                case 0:
                    // Salir
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }
    // Método para concatenar dos lenguajes
    public Lenguaje concatenar(Lenguaje otro) {
        List<String> concatenacion = new ArrayList<>();
        for (String itemA : this.items) {
            for (String itemB : otro.items) {
                concatenacion.add(itemA + itemB);
            }
        }
        return new Lenguaje(concatenacion);
    }

    // Método para potenciar un lenguaje
    public Lenguaje potenciar(int veces) {
        List<String> potenciacion = new ArrayList<>();
        for (String item : this.items) {
            for (int i = 0; i < veces; i++) {
                potenciacion.add(item);
            }
        }
        return new Lenguaje(potenciacion);
    }

    // Método para invertir los elementos del lenguaje
    public Lenguaje inversa() {
        List<String> inversa = new ArrayList<>();
        for (String item : this.items) {
            StringBuilder sb = new StringBuilder(item);
            inversa.add(sb.reverse().toString());
        }
        return new Lenguaje(inversa);
    }

    // Método para la unión de lenguajes
    public Lenguaje union(Lenguaje otro) {
        List<String> union = new ArrayList<>(this.items);
        for (String item : otro.items) {
            if (!union.contains(item)) {
                union.add(item);
            }
        }
        return new Lenguaje(union);
    }

    // Método para la intersección de lenguajes
    public Lenguaje interseccion(Lenguaje otro) {
        List<String> interseccion = new ArrayList<>();
        for (String item : this.items) {
            if (otro.items.contains(item) && !interseccion.contains(item)) {
                interseccion.add(item);
            }
        }
        return new Lenguaje(interseccion);
    }

    // Método para la resta de lenguajes (this - otro)
    public Lenguaje resta(Lenguaje otro) {
        List<String> resta = new ArrayList<>(this.items);
        resta.removeAll(otro.items);
        return new Lenguaje(resta);
    }

    // Método para la resta en ambos sentidos (this - otro) y (otro - this)
    public Lenguaje restaAmbosSentidos(Lenguaje otro) {
        List<String> resta = new ArrayList<>(this.items);
        List<String> otraResta = new ArrayList<>(otro.items);
        resta.removeAll(otro.items);
        otraResta.removeAll(this.items);
        resta.addAll(otraResta);
        return new Lenguaje(resta);
    }

    // Método para la cerradura de Kleene (CK)
    public Lenguaje cerraduraKleene() {
        List<String> ck = new ArrayList<>();
        ck.add("¬");  // Agrega la cadena vacía

        // Definir el número máximo de repeticiones y límite de visualización
        int maxRepeticiones = 4; // Ajusta este valor según sea necesario
        int limiteMostrar = 10;  // Ajusta el límite de visualización para truncar la salida

        // Generar las cadenas para la cerradura de Kleene
        for (int i = 1; i <= maxRepeticiones; i++) {
            List<String> nuevasCadenas = new ArrayList<>();
            for (String cadena : ck) {
                for (String item : this.items) {
                    String nuevaCadena = cadena + item;
                    if (!ck.contains(nuevaCadena)) {
                        nuevasCadenas.add(nuevaCadena);
                    }
                }
            }
            ck.addAll(nuevasCadenas);

            // Romper el bucle si el número de cadenas supera el límite de visualización
            if (ck.size() > limiteMostrar) {
                break;
            }
        }

        // Truncar la lista si excede el límite de visualización
        if (ck.size() > limiteMostrar) {
            ck = ck.subList(0, limiteMostrar);
            ck.add("...");
        }

        return new Lenguaje(ck);
    }


    // Método para la cerradura positiva (CP)
    public Lenguaje cerraduraPositiva() {
        List<String> cp = new ArrayList<>();

        // Verificar si el conjunto de elementos está vacío
        if (items.isEmpty()) return new Lenguaje(cp);

        // Inicializar con las cadenas de un solo carácter
        cp.addAll(this.items);

        // Definir el número máximo de repeticiones
        int maxRepeticiones = 5; // Ajusta este valor según sea necesario

        // Generar las cadenas para la cerradura positiva
        for (int i = 1; i < maxRepeticiones; i++) {
            List<String> nuevasCadenas = new ArrayList<>();
            for (String cadena : cp) {
                for (String item : this.items) {
                    nuevasCadenas.add(cadena + item);
                }
            }
            cp.addAll(nuevasCadenas);
        }

        return new Lenguaje(cp);
    }


    // Método para pedir datos de cadenas, lenguajes, conjuntos, etc.
    public static List<String> solicitarDatos(String tipo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese los elementos del " + tipo + " separados por comas: ");
        String[] elementos = scanner.nextLine().split(",");
        return new ArrayList<>(Arrays.asList(elementos));
    }

    // Método para imprimir los elementos del lenguaje
    public void imprimir() {
        if (items.isEmpty()) {
            System.out.println("El Lenguaje está vacío.");
        } else {
            System.out.println("Elementos del Lenguaje:");
            for (String item : items) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
