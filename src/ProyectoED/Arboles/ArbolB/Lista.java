/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoED.Arboles.ArbolB;
import java.util.ArrayList;

public class Lista {
    public static ArrayList<String> ingresados;

    public Lista() {
       ingresados = new ArrayList<String>();
    }

    public boolean buscar(String valor) {
        boolean esta = false;
        for (int i = 0; i < ingresados.size() && !esta; i++) {
            if (ingresados.get(i).equals(valor)) {
                esta = true;
            }
        }
        return esta;
    }
}