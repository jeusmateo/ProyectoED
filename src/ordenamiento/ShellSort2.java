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
public class ShellSort2<T extends Comparable<T>> {
    T[] A;

    public ShellSort2(T[] A) {
        this.A = A;
    }

    public void sort() {
        int intervalo, i;
        T aux;
        boolean band;
        intervalo = A.length;
        while (intervalo > 1) {
            intervalo /= 2;
            band = true;
            while (band) {
                band = false;
                i = 0;
                while ((intervalo + i) < A.length) {
                    if (A[i].compareTo(A[i + intervalo]) > 0) {
                        aux = A[i];
                        A[i] = A[i + intervalo];
                        A[i + intervalo] = aux;
                        band = true;
                    }
                    i++;
                }
            }
        }
    }
}
