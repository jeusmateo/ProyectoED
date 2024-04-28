/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenamiento;

import java.util.ArrayList;
import java.util.List;

import ProyectoED.BusquedaBinaria;
import ProyectoED.LectordeMedline;

/**
 *
 * @author jeusm
 */
public class ShellSort<T extends Comparable<T>> {
    List<T> arr;

    public List<T> getArr() {
        return arr;
    }

    public void setArr(List<T> arr) {
        this.arr = arr;
    }

    public ShellSort(List<T> arr){
        this.arr = arr;
    }

    public void sort() {
        int intervalo, i;
        T aux;
        boolean band;
        intervalo = arr.size();
        while (intervalo > 1) {
            intervalo /= 2;
            band = true;
            while (band) {
                band = false;
                i = 0;
                while ((intervalo + i) < arr.size()) {
                    if (arr.get(i).compareTo(arr.get(i + intervalo)) > 0) { // > 0 significa que es mayor
                        aux = arr.get(i);
                        arr.set(i, arr.get(i + intervalo));
                        arr.set(i + intervalo, aux);
                        band = true;
                    }
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> arr = LectordeMedline.readAndProcessFile("medline_CDs.txt");
        ShellSort<String> shellSort = new ShellSort<>(arr);
        BusquedaBinaria busqueda = new BusquedaBinaria();
        boolean encontrado = false;

        long start = System.currentTimeMillis();
        shellSort.sort();
        encontrado = busqueda.busquedaBinaria(arr, "encontrado");
        long finish = System.currentTimeMillis();

        System.out.println("Tiempo de ejecución: " + (finish - start) + " ms");
        System.out.println("Encontrado: " + encontrado);
    }
}
