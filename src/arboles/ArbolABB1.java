package arboles;

import java.util.ArrayList;

import ProyectoED.ItemNotFoundException;

/**
 *
 * @author jorge.reyes
 */
public class ArbolABB1 {
    protected NodoBin raiz;
    
    public ArbolABB1(){
        this(null);
    }
    
    public ArbolABB1(Object o){
        raiz = new NodoBin(o);
    }
    
    public void inOrden(){
        if (raiz!=null)
            raiz.inOrden();
    }

    public void insertarCorpus(ArrayList<String> corpus){
        for (int i=0;i<corpus.size();i++){
            insertar(corpus.get(i));
        }
    }
    
    public void insertar(Object o){
        insertarOrdenado(raiz,o);
    }
    
    public void insertarOrdenado(NodoBin n,Object o){
        if ((int)o<(int)n.getDato()){
            if (n.getIzq()==null)
                n.setIzq(new NodoBin(o));
            else
                insertarOrdenado(n.getIzq(),o);
        }
        else{
            if ((int)o>(int)n.getDato()){
                if (n.getDer()==null)
                    n.setDer(new NodoBin(o));
                else
                    insertarOrdenado(n.getDer(),o);
            }
        }
    }
    
    public void buscar(Object o){
        buscar(raiz,o);
    }
    
    public void buscar(NodoBin n, Object o) throws ItemNotFoundException{
        if ((int)o<(int)n.getDato()){
            if (n.getIzq()==null)
                throw new ItemNotFoundException("El elemento no se encuentra");
            else
                buscar(n.getIzq(),o);
        }
        else
            if ((int)o>(int)n.getDato()){
                if (n.getDer()==null)
                    throw new ItemNotFoundException("El elemento no se encuentra");
                else
                    buscar(n.getDer(),o);
            }
            else
                System.out.println("El elemento si está en el árbol");
    }

    
   
    
    
    public static void main(String[] args) {
        // ArbolABB1  arbol = new ArbolABB1(120);
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
        //     System.out.println("Error: " + e.getMessage());
        // }
        
    }
    
    
}

