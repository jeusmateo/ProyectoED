/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoED.OrdenacionInterna;
import java.util.ArrayList;

public class QuickSort {

    private ArrayList<String> arreglo;

    public void setArreglo(ArrayList<String> arreglo) {
        this.arreglo = arreglo;
    }

    public boolean OrdenamientoQuicksort(ArrayList<String> arreglo) {
        boolean tst = false;
        setArreglo(arreglo);
        long start = System.currentTimeMillis();
            quickSort(arreglo, 0, arreglo.size() - 1);
            //tst = BusquedaBinaria(arreglo)
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Tiempo transcurrido (Quicksort): " + timeElapsed + " ms");
        return tst;
    }

    private void quickSort(ArrayList<String> arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private int partition(ArrayList<String> arr, int left, int right) {
        String pivot = arr.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr.get(j).compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private void swap(ArrayList<String> arr, int i, int j) {
        String temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    
    //public static void main(String[] args){
        //ArrayList<String> palabras = new ArrayList<>();
        //palabras.add("perro");
        //palabras.add("gato");
        //palabras.add("elefante");
        //palabras.add("abeja");
        //palabras.add("leon");
        //QuickSortMario ordenamiento = new QuickSortMario();

        //System.out.println("Lista original: " + palabras);
        //ordenamiento.OrdenamientoQuicksort(palabras);
        //System.out.println("Lista ordenada: " + palabras);
    //}
}
