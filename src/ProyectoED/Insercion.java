package ProyectoED;

import java.util.ArrayList;

public class Insercion {
    //este es un shell sort para ordenar palabras de un corpus médico en un arraylist
    //inserta de menor a mayor
    protected ArrayList<String> A;

    public ArrayList<String> getA() {
        return A;
    }

    public void setA(ArrayList<String> A) {
        this.A = A;
    }

    public void insercion() {
        int i, k;
        String aux;
        for (i = 1; i < A.size(); i++) {
            aux = A.get(i);
            k = i - 1;
            while (k >= 0 && aux.compareTo(A.get(k)) < 0) {
                A.set(k + 1, A.get(k)); // Desplaza el elemento a la derecha
                k--;
            }
            A.set(k + 1, aux); // Inserta el elemento en la posición correcta
        }
    }

}
