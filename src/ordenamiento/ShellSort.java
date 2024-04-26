/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenamiento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeusm
 */
public class ShellSort<T extends Comparable<T>> {
    List<T> arr = new ArrayList<>();

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
}
