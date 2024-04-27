package ordenamiento;

import java.util.ArrayList;
import java.util.List;

public class ShellSortString2 {
    List<String> arr;

    public ShellSortString2(List<String> arr){
        this.arr = arr;
    }

    public void sort() {
        int intervalo, i;
        String aux;
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
