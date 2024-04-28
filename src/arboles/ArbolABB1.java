package arboles;
import java.util.ArrayList;

public class ArbolABB1 {
    protected NodoBin raiz;
    
    public ArbolABB1(){
        raiz = null; // No inicializar con un nodo vacío.
    }
    
    public ArbolABB1(String datoInicial){
        raiz = new NodoBin(datoInicial);
    }
    
    public void inOrden(){
        if (raiz != null)
            raiz.inOrden();
    }

    public void insertarCorpus(ArrayList<String> corpus){
        for (String dato : corpus) {
            insertar(dato);
        }
    }
    
    public void insertar(String dato){
        if (raiz == null) {
            raiz = new NodoBin(dato);
        } else {
            insertarOrdenado(raiz, dato);
        }
    }
    
    private void insertarOrdenado(NodoBin nodo, String dato){
        if (dato.compareTo(nodo.getDato()) < 0) {
            if (nodo.getIzq() == null)
                nodo.setIzq(new NodoBin(dato));
            else
                insertarOrdenado(nodo.getIzq(), dato);
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            if (nodo.getDer() == null)
                nodo.setDer(new NodoBin(dato));
            else
                insertarOrdenado(nodo.getDer(), dato);
        }
    }
    
    public void buscar(String dato) throws ItemNotFoundException{
        buscar(raiz, dato);
    }
    
    private void buscar(NodoBin nodo, String dato) throws ItemNotFoundException{
        if (nodo == null)
            throw new ItemNotFoundException("El elemento no se encuentra");
        else if (dato.compareTo(nodo.getDato()) < 0)
            buscar(nodo.getIzq(), dato);
        else if (dato.compareTo(nodo.getDato()) > 0)
            buscar(nodo.getDer(), dato);
        else
            System.out.println("El elemento sí está en el árbol");
    }
}