package ProyectoED;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ProyectoED.OrdenacionInterna.Insercion;


public class LectordeMedline {
    
    public static ArrayList<String> readAndProcessFile(String filePath) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Eliminar signos de puntuación que no son letras y convertir a minúsculas
                /*
                 * \p{L} matches any kind of letter from any language
                 */
                String[] tokens = line.replaceAll("[^\\p{L} ]", "").toLowerCase().split("\\s+");

                // Agregar palabras al ArrayList
                for (String token : tokens) {
                    // Ignorar palabras vacías y duplicadas
                    if (!token.isEmpty() && !words.contains(token)) {
                        words.add(token);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    public static void main(String[] args) {
        String filePath = "src/ProyectoED/medline_CDs.txt"; // Ruta de tu archivo de texto Medline
        ArrayList<String> words = readAndProcessFile(filePath);

        BusquedaBinaria busqueda = new BusquedaBinaria();
        
        System.out.println(words.size());
        // Imprimir las palabras almacenadas en el ArrayList
        int i=0;
        for (String word : words) {
            i++;
            System.out.println(word);
        }
        System.out.println(i);

        //ordenar
        Insercion ordenar = new Insercion();
        ordenar.setA(words);
        ordenar.insercion();

        System.out.println(busqueda.busquedaBinaria(words, "russel"));

    }
}