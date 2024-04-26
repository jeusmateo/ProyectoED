
import java.util.ArrayList;

import ProyectoED.LectordeMedline;
import ordenamiento.ShellSort;
import ordenamiento.ShellSort2;
import ordenamiento.ShellSortString;

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
        ArrayList<String> nuevo = LectordeMedline.readAndProcessFile("C:\\Users\\jeusm.MASTER\\Downloads\\medline_CDs.txt");
        var ordenamiento = new ShellSort<String>(nuevo);
        // var ordenamiento = new ShellSort2<String>(nuevo.toArray(new String[nuevo.size()]));
        // var ordenamiento = new ShellSortString(nuevo.toArray(new String[nuevo.size()]));
        long start = System.currentTimeMillis();
        ordenamiento.sort();
        long finish = System.currentTimeMillis();
        // System.out.println();
        System.out.println("tiempo: " + (finish-start));
        
    }
    

}
