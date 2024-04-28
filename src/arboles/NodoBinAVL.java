package arboles;

/**
*
* @author jorge.reyes
* @param <T>
*/
public class NodoBinAVL<T> {
   protected T dato;
   protected NodoBinAVL<T> izq;
   protected NodoBinAVL<T> der;
   
   public NodoBinAVL(T dato, NodoBinAVL<T> izq, NodoBinAVL<T> der){
       this.dato = dato;
       this.izq = izq;
       this.der = der;
   }
   
   public NodoBinAVL(T dato){
       this(dato,null,null);
   }

   public NodoBinAVL(){
       this(null);
   }
   
   public void posOrden(){ //izquierda, dercha, raíz
       if (izq!= null)
           izq.posOrden();
       if (der!=null)
           der.posOrden();
       System.out.println(dato); //raiz
   }
   
   public void preOrden(){ //raiz, izquierda, derecha
       System.out.println(dato);
       if (izq!= null)
           izq.preOrden();
       if (der!=null)
           der.preOrden();
   }
   
   public void inOrden(){ //izquierda, raíz, derecha
       if (izq!= null)
           izq.inOrden();
       System.out.println(dato);
       if (der!=null)
           der.inOrden();
   }
   
   
   /**
    * @return the dato
    */
   public T getDato() {
       return dato;
   }

   /**
    * @param dato the dato to set
    */
   public void setDato(T dato) {
       this.dato = dato;
   }

   /**
    * @return the izq
    */
   public NodoBinAVL<T> getIzq() {
       return izq;
   }

   /**
    * @param izq the izq to set
    */
   public void setIzq(NodoBinAVL<T> izq) {
       this.izq = izq;
   }

   /**
    * @return the der
    */
   public NodoBinAVL<T> getDer() {
       return der;
   }

   /**
    * @param der the der to set
    */
   public void setDer(NodoBinAVL<T> der) {
       this.der = der;
   }

   @Override
   public String toString() {
       return "Dato: " + dato;
   }
   
   
}
