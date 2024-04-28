/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

import ProyectoED.LectordeMedline;

import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public class Raiz {
    public static int grado;
    public Nodo primerNodo;
    public static boolean esRaiz;
    public static int nivel = 1;
    public static int imprimir = 1;
    public static String arbol = "";

    public Raiz(int grado) {
        this.grado = grado;
        primerNodo = new Nodo();
        esRaiz = true;
        Lista.ingresados = new ArrayList<>(); // Inicialización de la lista
    }

    public void insertar(String valor) {
        if (primerNodo.tengoHijos == false) {
            int j = 0;
            for (int i = 0; i < primerNodo.valores.length; i++) {
                if (primerNodo.valores[i] == null) {
                    primerNodo.valores[i] = valor;
                    Lista.ingresados.add(valor);
                    j = i;
                    ordenar(primerNodo.valores, 6);
                    break;
                }
            }
            if (j == 2 * grado) {
                split(primerNodo);
            }
        } else {
            setTengoHijos(primerNodo);
            ingresarEnHijos(primerNodo, valor);

        }
    }

    public void ordenar(String[] arr, int longitud) {
        longitud = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                longitud++;
            } else {
                break;
            }
        }
        for (int ord = 0; ord < longitud; ord++) {
            for (int ord1 = 0; ord1 < longitud - 1; ord1++) {
                if (arr[ord1].compareTo(arr[ord1 + 1]) > 0) {
                    String tmp = arr[ord1];
                    arr[ord1] = arr[ord1 + 1];
                    arr[ord1 + 1] = tmp;
                }
            }
        }
    }

    public void setTengoHijos(Nodo nodo) {
        if (nodo == primerNodo) {
            if (primerNodo.nodo[0] != null) {
                primerNodo.tengoHijos = true;
            }
        }
        for (int i = 0; i < nodo.nodo.length; i++) {
            if (nodo.nodo[i] != null) {
                nodo.tengoHijos = true;
                setTengoHijos(nodo.nodo[i]);
            }
        }
    }

    public void ingresarEnHijos(Nodo conHijos, String valor) {
        boolean entro = false;
        if (conHijos != null && !conHijos.tengoHijos) {
            ubicarValorEnArreglo(conHijos, valor);
            entro = true;
        }
        for (int i = 0; conHijos != null && i < 2 * grado + 1 && !entro; i++) {
            if (conHijos.valores[i] == null || valor.compareTo(conHijos.valores[i]) < 0) {
                entro = true;
                ingresarEnHijos(conHijos.nodo[i], valor);
                i = 2 * grado; // Salir del bucle for
            }
        }
    }

    public void ubicarValorEnArreglo(Nodo nodoA, String valor) {
        int cont = 0;
        while (cont <= 2 * grado) {
            if (nodoA.valores[cont] == null) {
                nodoA.valores[cont] = valor;
                ordenar(nodoA.valores, 5);
                Lista.ingresados.add(valor);
                if (cont == 2 * grado) {
                    split(nodoA);
                }
                break;
            }
            cont++;
        }
    }

    public void ordenarNodos(Nodo aOrdenar) {
        int i = 0, j;
        Nodo tmp;

        while (i < 2 * grado + 3 && aOrdenar.nodo[i] != null) {
            j = 0;
            while (j < 2 * grado + 2 && aOrdenar.nodo[j] != null && aOrdenar.nodo[j + 1] != null) {
                if (aOrdenar.nodo[j].valores[0].compareTo(aOrdenar.nodo[j + 1].valores[0]) > 0) {
                    tmp = aOrdenar.nodo[j];
                    aOrdenar.nodo[j] = aOrdenar.nodo[j + 1];
                    aOrdenar.nodo[j + 1] = tmp;
                }
                j++;
            }
            i++;
        }
    }

    public void split(Nodo nodo) {
        Nodo hijoIzq = new Nodo();
        Nodo hijoDer = new Nodo();

        // Split general
        if (nodo.nodo[0] != null) { // Si tiene hijos antes de hacer el split
            for (int i = 0; i < grado + 1; i++) { // Separa los hijos del nodo en hijoIzq e hijoDer
                hijoIzq.nodo[i] = nodo.nodo[i];
                hijoIzq.nodo[i].padre = hijoIzq;
                nodo.nodo[i] = null;
                hijoDer.nodo[i] = nodo.nodo[grado + 1 + i];
                hijoDer.nodo[i].padre = hijoDer;
                nodo.nodo[grado + 1 + i] = null;
            }
        }

        for (int i = 0; i < grado; i++) { // Guarda los valores en hijoIzq e hijoDer
            hijoIzq.valores[i] = nodo.valores[i];
            nodo.valores[i] = null;
            hijoDer.valores[i] = nodo.valores[grado + 1 + i];
            nodo.valores[grado + 1 + i] = null;
        }
        nodo.valores[0] = nodo.valores[grado];
        nodo.valores[grado] = null; // Queda en nodo solo el valor que "subió"

        nodo.nodo[0] = hijoIzq; // Asigna a nodo el nuevo hijo izquierdo (hijoIzq)
        nodo.nodo[0].padre = nodo; // Se hizo en primer ciclo
        nodo.nodo[1] = hijoDer; // Asigna a nodo el nuevo hijo derecho (hijoDer)
        nodo.nodo[1].padre = nodo; // Se hizo en el primer ciclo
        setTengoHijos(primerNodo);
        ordenarNodos(nodo);

        if (nodo.padre != null) { // Luego del split y asignar los hijos (hijoIzq, hijoDer), subir el valor al
                                  // padre
            boolean subido = false;
            for (int i = 0; i < nodo.padre.valores.length && !subido; i++) {
                if (nodo.padre.valores[i] == null) {
                    nodo.padre.valores[i] = nodo.valores[0];
                    subido = true;
                    nodo.valores[0] = null;
                    ordenar(nodo.padre.valores, 5);
                }
            }
            int posHijos = 0;
            for (int i = 0; i < 2 * grado + 3; i++) {
                if (nodo.padre.nodo[i] != null) {
                    posHijos++;
                } else {
                    break;
                }
            }
            nodo.padre.nodo[posHijos] = nodo.nodo[0];
            nodo.padre.nodo[posHijos + 1] = nodo.nodo[1];
            nodo.padre.nodo[posHijos].padre = nodo.padre;
            nodo.padre.nodo[posHijos + 1].padre = nodo.padre;
            int aqui = 0;
            for (int i = 0; i < 2 * grado + 3 && nodo.padre.nodo[i] != null; i++) {
                if (nodo.padre.nodo[i].valores[0] == nodo.valores[0]) {
                    aqui = i;
                    break;
                }
            }
            Nodo papa = nodo.padre;
            nodo = null;
            int j = aqui;
            while (j < 2 * grado + 2 && papa.nodo[j] != null && papa.nodo[j + 1] != null) {
                papa.nodo[j] = papa.nodo[j + 1];
                j++;
            }
            papa.nodo[j] = null;
            ordenar(papa.valores, 5);
            ordenarNodos(papa);
            if (papa.valores[2 * grado] != null) {
                split(papa);
            }
        }
    }

    public boolean buscar(String valor) {
        boolean esta = false;
        for (int i = 0; i < Lista.ingresados.size() && !esta; i++) {
            if (Lista.ingresados.get(i).equals(valor)) {
                esta = true;
                System.out.println("El elemento buscado '" + valor + "' se encuentra en el árbol B");
                return esta;
            }
        }
        System.out.println("El elemento buscado '" + valor + "' no se encuentra en el árbol B");
        return false;
    }

    public String recorrer(Nodo nodo) {
        arbol += "\n";
        for (int i = 0; i < 2 * grado + 1; i++) {
            if (nodo.nodo[i] != null) {
                if (i == 0) {
                    nivel++;
                    imprimir = 1;
                } else {
                    imprimir++;
                }
                recorrer(nodo.nodo[i]);
            }
            arbol += "[ ";
            for (int j = 0; nodo.nodo[i] != null && j < nodo.nodo[i].valores.length; j++) {
                if (nodo.nodo[i].valores[j] != null) {
                    arbol += nodo.nodo[i].valores[j] + ", ";
                }
            }
            arbol += " ]";
        }
        if (arbol.length() > (2 * grado + 3) * 4) {
            System.out.println(arbol);
            return arbol;
        }
        return arbol;
    }

    public String llamarRecorrer() {
        String mostrar = recorrer(primerNodo);
        nivel = 1;
        imprimir = 1;
        return arbol;
    }

    public boolean OrdenamientoArbolB(ArrayList<String> arreglo) {
        boolean tst = false;

        long start = System.currentTimeMillis();

        // Establecer el nuevo arreglo en el árbol B
        setArreglo(arreglo);
        buscar("perro");

        // tst = BusquedaBinaria(arreglo);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Tiempo transcurrido: " + timeElapsed + " ms");

        return tst;
    }

    private void setArreglo(ArrayList<String> arreglo) {
        // Aquí debes recorrer el árbol B e insertar cada elemento del arreglo en el
        // árbol B
        for (String valor : arreglo) {
            insertar(valor);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> palabras = LectordeMedline
                .readAndProcessFile("C:\\Users\\Mario\\Downloads\\LecturaEstructura\\Archivodetexto.txt");

        Raiz ordenamiento = new Raiz(2);

        System.out.println("Procesando (AB)...");
        ordenamiento.OrdenamientoArbolB(palabras);
        System.out.println("Fin.");
    }
}
