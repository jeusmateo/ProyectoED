/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ProyectoED.OrdenacionInterna;

import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public class BoobleSort {
    private ArrayList<String> arreglo;

    public void setArreglo(ArrayList<String> arreglo) {
        this.arreglo = arreglo;
    }
    
    public void bubbleSort() {
        int n = arreglo.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo.get(j).compareTo(arreglo.get(j + 1)) > 0) {
                    String temp = arreglo.get(j);
                    arreglo.set(j, arreglo.get(j + 1));
                    arreglo.set(j + 1, temp);
                }
            }
        }
    }
    
    public boolean OrdenamientoBurbuja(ArrayList<String> arreglo){
        boolean tst = false;
        setArreglo(arreglo);
        long start = System.currentTimeMillis();
            bubbleSort();
            //tst = BusquedaBinaria(arreglo);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Tiempo transcurrido: " + timeElapsed + " ms");
        return tst;
    }
    
      //  public static void main(String[] args) {
        //ArrayList<String> palabras = new ArrayList<>();
       // palabras.add("perro");
       // palabras.add("gato");
       // palabras.add("elefante");
        //palabras.add("abeja");
       //palabras.add("leon");
        
        
      //  ProyectoEstructuraMario proyecto = new ProyectoEstructuraMario();
        
       // System.out.println("Lista original: " + palabras);
        //boolean ordenado = proyecto.OrdenamientoBurbuja(palabras);
        //System.out.println("Lista ordenada: " + palabras);
        //System.out.println("¿Está ordenada? " + ordenado);
    //}
}
