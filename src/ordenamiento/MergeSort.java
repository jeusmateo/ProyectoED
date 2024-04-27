/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author jorge.reyes
 */
public class MergeSort<T extends Comparable<T>> {

    public ArrayList<T> ordenaMerge(ArrayList<T> L) {
        int n = L.size(), i, m;
        ArrayList<T> L1 = new ArrayList<T>(), L2 = new ArrayList<T>();
        if (n > 1) {
            m = n / 2;
            for (i = 0; i < m; i++)
                L1.add(L.get(i));
            for (i = m; i < n; i++)
                L2.add(L.get(i));
            L = merge(ordenaMerge(L1), ordenaMerge(L2));
        }
        return L;
    }

    public ArrayList<T> merge(ArrayList<T> L1, ArrayList<T> L2) {
        ArrayList<T> lista = new ArrayList<T>();
        while (!L1.isEmpty() && !L2.isEmpty()) {
            if (L1.get(0).compareTo(L2.get(0)) < 0) {
                lista.add(L1.get(0));
                L1.remove(0);
                if (L1.isEmpty()) {
                    lista.addAll(L2);
                    L2.clear();
                }
            } else {
                lista.add(L2.get(0));
                L2.remove(0);
                if (L2.isEmpty()) {
                    lista.addAll(L1);
                    L1.clear();
                }
            }
        }
        return lista;
    }

    public static void main(String[] args) {
        MergeSort<String> merge = new MergeSort<>();
        ArrayList<String> lista = new ArrayList<>();

        // Random rand = new Random();
        // for (int i = 0; i < 10; i++){
        //     lista.add(rand.nextInt());
        // }
        // lista.add("null");
        // lista.add("nul22");
        // lista.add("nulleee");
        // lista.add("asnull");

        System.out.println("Lista desordenada");
        System.out.println(lista);
        long start = System.currentTimeMillis();
        lista = merge.ordenaMerge(lista);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Lista ordenada");
        System.out.println(lista);
        System.out.println("El tiempo total es de " + timeElapsed);
    }
}