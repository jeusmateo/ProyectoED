package arboles;

import java.util.ArrayList;

import ProyectoED.ItemNotFoundException;

/**
 *
 * @author jorge.reyes
 */
public class ArbolABB1<T extends Comparable<T>> {
    protected NodoBin<T> raiz;

    public ArbolABB1() {
        this(null);
    }

    public ArbolABB1(T o) {
        raiz = new NodoBin<T>(o);
    }

    public void inOrden() {
        if (raiz != null)
            raiz.inOrden();
    }

    // public void insertarCorpus(ArrayList<String> corpus) {
    //     for (int i = 0; i < corpus.size(); i++) {
    //         insertar((T) corpus.get(i));
    //     }
    // }

    public void insertar(T o) {
        insertarOrdenado(raiz, o);
    }

    public void insertarOrdenado(NodoBin<T> n, T o) {
        // if ((int)o<(int)n.getDato()){
        if (o.compareTo(n.getDato()) < 0) {
            if (n.getIzq() == null)
                n.setIzq(new NodoBin<T>(o));
            else
                insertarOrdenado(n.getIzq(), o);
        } else {
            // if ((int) o > (int) n.getDato()) {
            if (o.compareTo(n.getDato()) > 0){
                if (n.getDer() == null)
                    n.setDer(new NodoBin<T>(o));
                else
                    insertarOrdenado(n.getDer(), o);
            }
        }
    }

    public void buscar(T o) {
        buscar(raiz, o);
    }

    public void buscar(NodoBin<T> n, T o) throws ItemNotFoundException {
        if (o.compareTo(n.getDato()) < 0) {
            if (n.getIzq() == null)
                throw new ItemNotFoundException("El elemento no se encuentra");
            else
                buscar(n.getIzq(), o);
        } else if (o.compareTo(n.getDato()) > 0) {
            if (n.getDer() == null)
                throw new ItemNotFoundException("El elemento no se encuentra");
            else
                buscar(n.getDer(), o);
        } else
            System.out.println("El elemento si está en el árbol");
    }

    public static void main(String[] args) {
        // ArbolABB1 arbol = new ArbolABB1(120);
        // arbol.insertar(87);
        // arbol.insertar(43);
        // arbol.insertar(65);
        // arbol.insertar(140);
        // arbol.insertar(99);
        // arbol.insertar(130);
        // arbol.insertar(22);
        // arbol.insertar(56);
        // System.out.println("Recorrido en InOrden");
        // arbol.inOrden();

        // System.out.println("Buscando datos en el árbol");
        // try{
        // arbol.buscar(122);
        // }
        // catch(ItemNotFoundException e){
        // System.out.println("Error: " + e.getMessage());
        // }

    }

}
