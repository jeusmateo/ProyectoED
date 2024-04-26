package ProyectoED;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class mezclaEquilibrada {
    public int PART;

        public void particionInicial(String F, String F2, String F3, int PART) throws IOException {
        // Abrir el archivo F para lectura
        BufferedReader br = new BufferedReader(new FileReader(F));
        
        // Abrir los archivos F2 y F3 para escritura
        BufferedWriter bwF2 = new BufferedWriter(new FileWriter(F2));
        BufferedWriter bwF3 = new BufferedWriter(new FileWriter(F3));

        // Leer el primer valor de F y preparar variables
        String linea = br.readLine();
        if (linea == null) { // Terminar si el archivo está vacío
            br.close();
            bwF2.close();
            bwF3.close();
            return;
        }

        int R = Integer.parseInt(linea);
        boolean BAND = true; // Verdadero indica escribir en F2, falso en F3
        int AUX = R; // Almacenar el último valor leído

        // Escribir el primer valor en F2
        bwF2.write(R + "\n");

        // Leer el resto de los valores del archivo F
        while ((linea = br.readLine()) != null) {
            R = Integer.parseInt(linea); // Convertir el valor leído a entero

            if (R >= AUX) {
                AUX = R;
                if (BAND) {
                    bwF2.write(R + "\n");
                } else {
                    bwF3.write(R + "\n");
                }
            } else {
                AUX = R;
                if (BAND) {
                    bwF3.write(R + "\n");
                    BAND = false;
                } else {
                    bwF2.write(R + "\n");
                    BAND = true;
                }
            }
        }

        // Cerrar los archivos
        br.close();
        bwF2.close();
        bwF3.close();
    }

        public void mezclaEquilibradaMetodo(String F, String F1, String F2, String F3) throws IOException {
        boolean band;
        String inLineF1 = "", inLineF3 = "";
        particionInicial(F, F2, F3);
        band = true;
        do {
            if (band) {
                particionFusion(F2, F3, F, F1);
                band = false;
            } else {
                particionFusion(F, F1, F2, F3);
                band = true;
            }
            FileReader fr1 = new FileReader(F1);
            BufferedReader br1 = new BufferedReader(fr1);
            FileReader fr3 = new FileReader(F3);
            BufferedReader br3 = new BufferedReader(fr3);
            inLineF1 = br1.readLine();
            inLineF3 = br3.readLine();
            br1.close();
            br3.close();
        } while (inLineF1 != null || inLineF3 != null);
    }

    // EL ALGORITMO PRODUCE LA PARTICION Y LA FUSIØN DE LOS ARCHIVOS FA Y FB, EN LOS
    // ARCHIVOS FC y FD
    public void particionFusion(String FA, String FB, String FC, String FD) throws IOException {
        int r1 = 0, r2 = 0, aux;
        boolean ban1, ban2, ban3;

        Scanner fa = new Scanner(FA);
        Scanner fb = new Scanner(FB);
        FileWriter fc = new FileWriter(FC);
        FileWriter fd = new FileWriter(FD);

        ban1 = ban2 = ban3 = true;
        aux = Integer.MIN_VALUE; // cambiar por Integer.MIN_VALUE si no rompe nada

        while ((fa.hasNextLine() || ban1 == false) && (fb.hasNextLine() || ban2 == false)) {
            if (ban1 == true) {
                r1 = fa.nextInt();
                ban1 = false;
            }
            if (ban2 == true) {
                r2 = fb.nextInt();
                ban2 = false;
            }

            // 4.5
            if (r1 < r2) {
                // 4.5.1
                if (r1 >= aux) {
                    // 4.5.1.1
                    if (ban3 == true) {
                        fc.append(r1 + " ");
                    } else {
                        fd.append(r1 + " ");
                    }
                    // 4.5.1.2 end
                    ban1 = true;
                    aux = r1;
                } else {
                    // 4.5.1.3
                    if (ban3 == true) {
                        fc.append(r2 + " ");
                        ban3 = false;
                    } else {
                        fd.append(r2 + " ");
                        ban3 = true;
                    }
                    // 4.5.1.4 end
                    ban2 = true;
                    aux = Integer.MIN_VALUE;
                }
                // 4.5.2 end
            } else {
                // 4.5.3
                if (r2 >= aux) {
                    // 4.5.3.1
                    if (ban3 == true) {
                        fc.append(r2 + " ");
                    } else {
                        fd.append(r2 + " ");
                    }
                    // 4.5.3.2 end
                    ban2 = true;
                    aux = r2;
                } else {
                    // 4.5.3.3
                    if (ban3 == true) {
                        fc.append(r1 + " ");
                        ban3 = false;
                    } else {
                        fd.append(r1 + " ");
                        ban3 = true;
                    }
                    // 4.5.3.4 END
                    ban1 = true;
                    aux = Integer.MIN_VALUE;
                }
                // 4.5.4 END
            }
            // 4.6 END
        } // 5 END

        //6
        if (ban1 == false) {
            //6.1
            if(ban3 == true){
                fc.append(r1 + " ");
                //6.1.1
                while(fa.hasNextLine()){
                    r1 = fa.nextInt();
                    fc.append(r1 + " ");
                }
                //6.1.2 END
            }
            else{
                fd.append(r1 + " ");
                //6.1.3
                while(fa.hasNextLine()){
                    r1 = fa.nextInt();
                    fd.append(r1 + " ");
                }
                //6.1.4 END
            }
            //6.2 END
        }
        //7 END

        //8
        if(ban2 == false){
            //8.1
            if(ban3 == true){
                fc.append(r2 + " ");
                //8.1.1
                while(fb.hasNextLine()){
                    r2 = fb.nextInt();
                    fc.append(r2 + " ");
                }
                //8.1.2 END
            }
            else{
                fd.append(r2 + " ");
                //8.1.3
                while(fb.hasNextLine()){
                    r2 = fb.nextInt();
                    fd.append(r2 + " ");
                }
                //8.1.4 END
            }
            //8.2 END
        }
        //9 END

        //10 
        fa.close();
        fb.close();
        fc.close();
        fd.close();
    }

    public void particionInicial(String F, String F2, String F3) throws IOException {
        int aux = 0, r = 0;
        boolean band;
        FileReader fr = new FileReader(F);
        BufferedReader br = new BufferedReader(fr);

        // byscar la forma optima para escribir salida xdd

    }

    public static void main(String[] args) {
        mezclaEquilibrada particionador = new mezclaEquilibrada();
        try {
            particionador.mezclaEquilibradaMetodo("/Users/becario/Desktop/ProyectoED/src/ProyectoED/archivoOriginal.txt", "archivoParticion1.txt", "archivoParticion2.txt", "archivoParticion3.txt");
        } catch (Exception e) {
            System.out.println("Ocurrió un error " + e.getMessage());
            //para tener un mejor control de los errores
            e.printStackTrace();
        }
    }
}