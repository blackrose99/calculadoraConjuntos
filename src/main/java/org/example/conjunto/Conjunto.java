package org.example.conjunto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conjunto {
    private List<String> items;

    public Conjunto() {
        this.items = new ArrayList<>();
    }

    public Conjunto(String[] elementos) {
        this.items = new ArrayList<>(Arrays.asList(elementos));
    }

    public void insertar(String dato) {
        if (!pertenece(dato)) {
            items.add(dato);
        } else {
            System.out.println("El elemento ya se encuentra en el conjunto.");
        }
    }

    public Conjunto Union(Conjunto a) {
        Conjunto R = new Conjunto();
        R.items.addAll(this.items);
        for (String item : a.items) {
            if (!R.pertenece(item)) {
                R.insertar(item);
            }
        }
        return R;
    }

    public Conjunto Interseccion(Conjunto a) {
        Conjunto R = new Conjunto();
        for (String item : this.items) {
            if (a.pertenece(item)) {
                R.insertar(item);
            }
        }
        return R;
    }

    public Conjunto Diferencia(Conjunto a) {
        Conjunto R = new Conjunto();
        for (String item : this.items) {
            if (!a.pertenece(item)) {
                R.insertar(item);
            }
        }
        return R;
    }

    public Conjunto diferenciaSimetrica(Conjunto a) {
        Conjunto R1 = this.Diferencia(a);
        Conjunto R2 = a.Diferencia(this);
        return R1.Union(R2);
    }

    public boolean pertenece(String dato) {
        return items.contains(dato);
    }

    public Conjunto complemento(Conjunto universo) {
        Conjunto R = new Conjunto();
        for (String item : universo.items) {
            if (!this.pertenece(item)) {
                R.insertar(item);
            }
        }
        return R;
    }

    public void imprimir() {
        if (items.isEmpty()) {
            System.out.println("El conjunto está vacío.");
        } else {
            System.out.println("Elementos del conjunto:");
            for (String item : items) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
