package arboles;

public class NodoBin {
    private String dato;
    private NodoBin izq;
    private NodoBin der;

    public NodoBin(String dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public String getDato() {
        return dato;
    }

    public NodoBin getIzq() {
        return izq;
    }

    public void setIzq(NodoBin izq) {
        this.izq = izq;
    }

    public NodoBin getDer() {
        return der;
    }

    public void setDer(NodoBin der) {
        this.der = der;
    }

    public void inOrden() {
        if (izq != null) izq.inOrden();
        System.out.println(dato);
        if (der != null) der.inOrden();
    }
}