/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ordenamiento;

import ProyectoED.LectordeMedline;

import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public class ProyectoEstructuraMario {
    private ArrayList<String> arreglo;

    public void setArreglo(ArrayList<String> arreglo) {
        this.arreglo = arreglo;
    }
    
    public ArrayList<String>  getArreglo(){
        return this.arreglo;
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

    public boolean OrdenamientoBurbuja(ArrayList<String> arg) {
        boolean tst;
        setArreglo(arg);
        long start = System.currentTimeMillis();
        bubbleSort();
        tst = BusquedaBinaria.busquedaBinaria(arreglo, "diferentesY");
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Tiempo transcurrido: " + timeElapsed + " ms");
        return tst;
    }

    public static void main(String[] args) {
        ArrayList<String> palabras = LectordeMedline
                .readAndProcessFile("C:\\Users\\Mario\\Downloads\\LecturaEstructura\\Archivodetexto.txt");

        ProyectoEstructuraMario proyecto = new ProyectoEstructuraMario();

        System.out.println("Procesando...");
        boolean ordenado = proyecto.OrdenamientoBurbuja(palabras);
        System.out.println("¿Está la palabra? " + ordenado);
        System.out.println("Fin.");
    }
}
