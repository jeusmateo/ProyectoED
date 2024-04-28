
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ProyectoED.LectordeMedline;
import arboles.ArbolAVL;
import ordenamiento.BusquedaBinaria;
import ordenamiento.Insercion;
import ordenamiento.MergeSort;
import ordenamiento.ShellSort;
import ordenamiento.ShellSort2;
import ordenamiento.ShellSortString;
import ordenamiento.ShellSortString2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jeusm
 */
public class NewClass {

    public static void main(String[] args) {
        List<String> cadena = LectordeMedline.readAndProcessFile("C:\\Users\\jeusm.MASTER\\Downloads\\medline_CDs.txt");
        // var busqueda = new BusquedaBinaria();
        // var encontrado = false;
        
        // var ordenamiento = new Insercion();
        // ordenamiento.setA(nuevo);
        // var ordenamiento = new MergeSort<String>();
        // var ordenamiento = new ShellSort<String>(nuevo);
        // var ordenamiento = new ShellSort2<String>(nuevo.toArray(new String[nuevo.size()]));
        // var ordenamiento = new ShellSortString(nuevo.toArray(String[]::new));
        // var ordenamiento = new ShellSortString2(nuevo);
        long start = System.currentTimeMillis();
        ArbolAVL<String> arbol = new ArbolAVL<>(cadena.get(0));
        for (int i = 1; i < cadena.size(); i++) {
            arbol.insertar(cadena.get(i));
        }
        arbol.buscar("úvulopalatofaringoplastia");
        // cadena = ordenamiento.ordenaMerge(cadena);
        // ordenamiento.sort();
        // ordenamiento.insercion();
        // encontrado = busqueda.busquedaBinaria(cadena, "úvulopalatofaringoplastia");
        // ordenamiento.insercion();
        long finish = System.currentTimeMillis();
        // // System.out.println();
        System.out.println("tiempo: " + (finish-start));
        // System.out.println("Encontrado: "+encontrado);
    }
    

}
