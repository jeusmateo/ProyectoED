/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;


import ProyectoED.NodoBin;

/**
 *
 * @author jorge.reyes
 * @param <T>
 */
public class NodoAVL<T> extends NodoBin<T> {
    protected int fe;
    protected NodoAVL<T> padre;

    public NodoAVL() {
    }

    public NodoAVL(T dato) {
        super(dato);
    }

    public NodoAVL(T dato, NodoBin<T> izq, NodoBin<T> der) {
        super(dato, izq, der);
    }

    public NodoAVL(T dato, NodoBin<T> izq, NodoBin<T> der, NodoAVL<T> padre) {
        super(dato, izq, der);
        this.padre = padre;
    }

    public static <T> int altura(NodoAVL<T> a) {
        if (a == null)
            return -1;
        else
            return 1 + Math.max(altura((NodoAVL<T>) a.getIzq()),
                    altura((NodoAVL<T>) a.getDer()));
    }

    @Override
    public void inOrden() {
        if (izq != null)
            izq.inOrden();
        System.out.println(dato + " FE:" + getFe());
        if (der != null)
            der.inOrden();
    }

    @Override
    public void preOrden() {
        System.out.println(dato + " FE:" + getFe());
        if (izq != null)
            izq.preOrden();
        if (der != null)
            der.preOrden();
    }

    @Override
    public void posOrden() {
        if (izq != null)
            izq.posOrden();
        if (der != null)
            der.posOrden();
        System.out.println(dato + " FE:" + getFe());
    }

    /**
     * @return the fe
     */
    public int getFe() {
        return fe;
    }

    /**
     * @param fe the fe to set
     */
    public void setFe(int fe) {
        this.fe = fe;
    }

    /**
     * @return the padre
     */
    public NodoAVL<T> getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoAVL<T> padre) {
        this.padre = padre;
    }

}
