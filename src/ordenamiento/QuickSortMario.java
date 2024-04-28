package ordenamiento;

import ProyectoED.LectordeMedline;

import java.util.ArrayList;
import java.math.BigInteger;

public class QuickSortMario {

    private ArrayList<String> arreglo;

    public ArrayList<String> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<String> arreglo) {
        this.arreglo = arreglo;
    }

    public boolean OrdenamientoQuicksort(ArrayList<String> arr) {
        boolean tst;
        setArreglo(arr);
        long start = System.currentTimeMillis();
        sort();
        tst = BusquedaBinaria.busquedaBinaria(arreglo, "complejo");
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Tiempo transcurrido (Quicksort): " + timeElapsed + " ms");
        return tst;
    }

    public void sort() {
        if (arreglo == null || arreglo.size() == 0) {
            return;
        }
        quickSort(BigInteger.ZERO, BigInteger.valueOf(arreglo.size() - 1));
    }

    private void quickSort(BigInteger low, BigInteger high) {
        if (low.compareTo(high) < 0) {
            BigInteger pi = partition(low, high);
            quickSort(low, pi.subtract(BigInteger.ONE));
            quickSort(pi.add(BigInteger.ONE), high);
        }
    }

    private BigInteger partition(BigInteger low, BigInteger high) {
        String pivot = arreglo.get(high.intValue());
        BigInteger i = low;
        for (BigInteger j = low; j.compareTo(high) < 0; j = j.add(BigInteger.ONE)) {
            if (arreglo.get(j.intValue()).compareTo(pivot) <= 0) {
                String temp = arreglo.get(i.intValue());
                arreglo.set(i.intValue(), arreglo.get(j.intValue()));
                arreglo.set(j.intValue(), temp);
                i = i.add(BigInteger.ONE);
            }
        }
        String temp = arreglo.get(i.intValue());
        arreglo.set(i.intValue(), arreglo.get(high.intValue()));
        arreglo.set(high.intValue(), temp);
        return i;
    }

    public static void main(String[] args) {
        ArrayList<String> palabras = LectordeMedline
                .readAndProcessFile("C:\\Users\\Mario\\Downloads\\LecturaEstructura\\Archivodetexto.txt");

        QuickSortMario proyecto = new QuickSortMario();

        System.out.println("Procesando (Q)...");
        boolean ordenado = proyecto.OrdenamientoQuicksort(palabras);
        System.out.println("¿Está la palabra? " + ordenado);
        System.out.println("Fin.");
    }

}
