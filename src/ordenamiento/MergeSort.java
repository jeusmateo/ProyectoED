package ordenamiento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ProyectoED.LectordeMedline;

public class MergeSort<T extends Comparable<T>> {

    public List<T> ordenaMerge(List<T> L) {
        int n = L.size(), i, m;
        List<T> L1 = new ArrayList<T>(), L2 = new ArrayList<T>();
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

    public List<T> merge(List<T> L1, List<T> L2) {
        List<T> lista = new ArrayList<T>();
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
        List<String> lista = LectordeMedline.readAndProcessFile("medline_CDs.txt");
        BusquedaBinaria busqueda = new BusquedaBinaria();
        boolean encontrado = false;

        long start = System.currentTimeMillis();
        lista = merge.ordenaMerge(lista);
        encontrado = busqueda.busquedaBinaria(lista, "elemento2");
        long finish = System.currentTimeMillis();
        
        System.out.println("Tiempo de ejecución: " + (finish - start) + " ms");
        System.out.println("Encontrado: " + encontrado);
    }
}