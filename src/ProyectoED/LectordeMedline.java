package ProyectoED;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LectordeMedline {
    
    public static ArrayList<String> readAndProcessFile(String filePath) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Eliminar signos de puntuación que no son letras y convertir a minúsculas
                String[] tokens = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                // Agregar palabras al ArrayList
                for (String token : tokens) {
                    // Ignorar palabras vacías
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
        String filePath = "C:\\Users\\jeusm.MASTER\\Downloads\\medline_CDs.txt"; // Ruta de tu archivo de texto Medline
        ArrayList<String> words = readAndProcessFile(filePath);

        System.out.println(words.size());
        // Imprimir las palabras almacenadas en el ArrayList
        //for (String word : words) {
            //System.out.println(word);
        //}
    }
}