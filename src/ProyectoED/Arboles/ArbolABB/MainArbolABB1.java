package ProyectoED;

import java.util.ArrayList;

public class MainArbolABB1 {
    public static void main(String[] args) {
        // Crear una instancia de ArbolABB1
        ArbolABB1 arbol = new ArbolABB1();

        // Lista de cadenas para insertar en el árbol
        ArrayList<String> corpus = new ArrayList<>();
        corpus.add("manzana");
        corpus.add("banana");
        corpus.add("cereza");
        corpus.add("durazno");
        corpus.add("higo");
        corpus.add("kiwi");
        corpus.add("limón");
        corpus.add("mango");
        corpus.add("naranja");
        corpus.add("papaya");

        // Insertar cada cadena en el árbol
        arbol.insertarCorpus(corpus);

        // Mostrar el recorrido InOrden del árbol
        System.out.println("Recorrido en InOrden del árbol:");
        arbol.inOrden();

        // Buscar algunos elementos en el árbol
        System.out.println("\nBuscando elementos en el árbol:");
        buscarEnArbol(arbol, "kiwi");
        buscarEnArbol(arbol, "uva");  // Este no está en el árbol, debería mostrar un error
    }

    // Método auxiliar para buscar en el árbol y manejar excepciones
    private static void buscarEnArbol(ArbolABB1 arbol, String dato) {
        try {
            arbol.buscar(dato);
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
