/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoED.Arboles.ArbolB;

/**
 *
 * @author Mario
 */
public class Nodo {
    public String[] valores;
    public Nodo[] nodo;
    public static int numValores;
    public boolean tengoHijos = false;
    public int ocupados = 0;
    public Nodo padre;

    public Nodo() {
       nodo = new Nodo[Raiz.grado * 2 + 3];
       valores = new String[Raiz.grado * 2 + 1];
    }
}
