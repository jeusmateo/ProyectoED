package ProyectoED.OredenacionExterna;

 import java.io.*; //Importar las clases necesarias para la manipulacion de archivos
import java.util.ArrayList;

 public class MezclaEquilibrada {

   public void crearArchivoDatos(String nombreArchivo, ArrayList<String> nombres) throws Exception {
       DataOutputStream dos = null;
       try {
           dos = new DataOutputStream(new FileOutputStream(nombreArchivo, false));
           for (String nombre : nombres) {
               if (!nombre.isEmpty()) {  // Verifica que el nombre no esté vacío
                   dos.writeUTF(nombre);
               }
           }
       } catch (IOException e) {
           System.out.println("Error de Apertura o Creacion");
       } finally {
           if (dos != null) {
               dos.close();
           }
       }
   }
 
   //Metodo para generar particiones de secuencias
   public boolean particion(String nombreArchivo, String archivo1, String archivo2) {
 
     String actual = null;
     String anterior = null;
 
     //Variable para controlar el indice del archivo al cual se va a escribir.
     int indexOutputStream = 0;
 
     //Variable que determina si existe un cambio de secuencia en el ordenamiento
     boolean hayCambioDeSecuencia = false;
 
     //Declaracion de los objetos asociados a los archivos y del arreglo de archivos
     //que sirven para las particiones
     DataOutputStream dos[] = new DataOutputStream[2];
     DataInputStream dis = null;
 
     try {
       //Abre o crea los archivos
       dos[0] = new DataOutputStream(new FileOutputStream(archivo1, false));
       dos[1] = new DataOutputStream(new FileOutputStream(archivo2, false));
       dis = new DataInputStream(new FileInputStream(nombreArchivo));
 
       //Primero, verifica si existen datos en el archivo que se va a leer
       while (dis.available() != 0) {

         anterior = actual;
         actual = dis.readUTF();
 
         if (anterior == null) {
           anterior = actual;
         }
 
         //Cambio de secuencia. Manipulacion del indice del arreglo de archivos
         if (anterior.compareTo(actual) > 0) {
           indexOutputStream = indexOutputStream == 0 ? 1 : 0;
           //Actualizacion de la variable booleana, esto indica la existencia
           //de un cambio de secuencia
           hayCambioDeSecuencia = true;
         }
 
         //Imprimir el dato contenido en actual y escribirlo en el archivo correspondiente
         //System.out.println(indexOutputStream + ") "+ actual);
         dos[indexOutputStream].writeUTF(actual);
       }
     } catch (FileNotFoundException e) {
       System.out.println("Error lectura/escritura");
     } catch (IOException e) {
       System.out.println("Error en la creacion o apertura del archivo 1");
     } finally {
       //Verificar para cada archivo, que efectivamente se encuentre abierto
       //antes de cerrarlo
       try {
         if (dis != null) {
           dis.close();
         }
 
         if (dos[0] != null) {
           dos[0].close();
         }
 
         if (dos[1] != null) {
           dos[1].close();
         }
       } catch (IOException ex) {
         System.out.println("Error al cerrar archivos");
       }
     }
     //El valor retornado sirve para determinar cuando existe una particion
     return hayCambioDeSecuencia;
   }
 
   //Metodo de fusion de los datos obtenidos en el metodo de particion
   public void fusion(String nombreArchivo, String archivo1, String archivo2) {
     //Variables para almacenar los datos de los archivos
     //que contienen las particiones
     String[] actual = new String[2];
     String[] anterior = new String[2];
     boolean[] finArchivo = new boolean[2];
     int indexArchivo = 0;
 
     //Creacion de los objetos asociacos a los archivos
     DataOutputStream dos = null;
     DataInputStream dis[] = new DataInputStream[2];
 
     try {
       //Abre o crea los archivos
       dis[0] = new DataInputStream(new FileInputStream(archivo1));
       dis[1] = new DataInputStream(new FileInputStream(archivo2));
       dos = new DataOutputStream(new FileOutputStream(nombreArchivo, false));
 
       //Condicion principal: debe haber datos en ambos archivos de lectura
       //Es importante notar que al inicio siempre hay al menos un dato en
       //cada archivo, de otra forma el metodo de particion hubiera
       //generado una sola secuencia y no entrariamos a la fusion.
       while (dis[0].available() != 0 && dis[1].available() != 0) {
 
         // 1era vez: inicializar con la primera palabra de cada archivo
         if (anterior[0] == null && anterior[1] == null) {
           anterior[0] = actual[0] = dis[0].readUTF();
           anterior[1] = actual[1] = dis[1].readUTF();
         }
 
         // al inicio del procesamiento de dos secuencias, anterior y
         // actual apuntan a la primer palabra de cada secuencia.
         anterior[0] = actual[0];
         anterior[1] = actual[1];
 
         // mezclamos las dos secuencias hasta que una acaba
         while (anterior[0].compareTo(actual[0]) <= 0 &&
             anterior[1].compareTo(actual[1]) <= 0) {
           indexArchivo = (actual[0].compareTo(actual[1]) <= 0) ? 0 : 1;
           dos.writeUTF(actual[indexArchivo]);
           anterior[indexArchivo] = actual[indexArchivo];
 
           // salir del while cuando no haya datos, pero ya procesamos
           // el ultimo nombre del archivo
           if (dis[indexArchivo].available() != 0) {
             actual[indexArchivo] = dis[indexArchivo].readUTF();
           } else {
             finArchivo[indexArchivo] = true;
             break;
           }
         }
 
         // en este punto indexArchivo nos dice que archivo causo
         // que salieramos del while anterior, por lo que tenemos
         // que purgar el otro archivo
         indexArchivo = indexArchivo == 0 ? 1 : 0;
 
         while (anterior[indexArchivo].compareTo(actual[indexArchivo]) <= 0) {
           dos.writeUTF(actual[indexArchivo]);
           anterior[indexArchivo] = actual[indexArchivo];
           if (dis[indexArchivo].available() != 0) {
             actual[indexArchivo] = dis[indexArchivo].readUTF();
           } else {
             finArchivo[indexArchivo] = true;
             break;
           }
         }
       }
 
       // purgar los dos archivos en caso de que alguna secuencia haya quedado sola al final del archivo.
       // Para salir del while anterior alguno de los 2 archivos debio terminar, por lo que a lo mas uno de los dos whiles siguientes se ejecutara
       if (!finArchivo[0]) {
         dos.writeUTF(actual[0]);
         while (dis[0].available() != 0) {
           dos.writeUTF(dis[0].readUTF());
         }
       }
 
       if (!finArchivo[1]) {
         dos.writeUTF(actual[1]);
         while (dis[1].available() != 0) {
           dos.writeUTF(dis[1].readUTF());
         }
       }
     } catch (FileNotFoundException e) {
       System.err.println(e);
     } catch (IOException e) {
       System.err.println(e);
     } finally {
       //Verificar para cada archivo, que efectivamente se encuentre abierto
       //antes de cerrarlo
       try {
         if (dis[0] != null) {
           dis[0].close();
         }
 
         if (dis[1] != null) {
           dis[1].close();
         }
 
         if (dos != null) {
           dos.close();
         }
       } catch (IOException ex) {
         System.out.println("Error al cerrar archivos");
       }
     }
   }
 
   public void ordenar(String nombreArchivo) {
     int index = 0;
     while (particion(nombreArchivo, "archivo1.txt", "archivo2.txt")) {
       //Imprime el numero de particiones-fusiones que le llevo a los
       //metodos de particion y fusion el ordenar el archivo
       System.out.println("Fusion " + ++index);
       fusion(nombreArchivo, "archivo1.txt", "archivo2.txt");
     }
   }

  public ArrayList<String> ArchivoToArrayList(String nombreArchivo) throws Exception {
    ArrayList<String> lista = new ArrayList<>();
    DataInputStream dis = null;

    try {
        dis = new DataInputStream(new FileInputStream(nombreArchivo));
        while (dis.available() != 0) {
            String nombre = dis.readUTF();
            lista.add(nombre);
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error de Apertura-Lectura archivo: " + nombreArchivo);
    } catch (IOException e) {
        System.out.println("Error de lectura archivo: " + nombreArchivo);
    } finally {
        if (dis != null) {
            dis.close();
        }
    }
    return lista;
}
  //  public static void main(String[] args) {

  //         try {
  //             MezclaEquilibrada mezcla = new MezclaEquilibrada();
  //             ArrayList<String> nombres = new ArrayList<>();
  //             nombres.add("bob");
  //             nombres.add("brayan");
  //             nombres.add("clara");
  //             nombres.add("chicharito");
  //             nombres.add("daniel");
  //             nombres.add("david");
  //             nombres.add("diana");
  //             nombres.add("daniela");
  //             nombres.add("ana");
  //             nombres.add("anahi");
  //             nombres.add("laura");
      
  //             String nombreArchivo = "nombres.txt";
  //             mezcla.crearArchivoDatos(nombreArchivo, nombres);

  //             // Ordenar el archivo
  //             mezcla.ordenar(nombreArchivo);
  //             // Verificar y mostrar el contenido del archivo ordenado
  //             System.out.println("Contenido del archivo después de ordenar:");
  //             //mezcla.desplegar(nombreArchivo);
  //             ArrayList<String> lista = mezcla.ArchivoToArrayList(nombreArchivo);
  //             for (String nombre : lista) {
  //                 System.out.println(nombre);
  //             }
  
  //         } catch (Exception e) {
  //             e.printStackTrace();
  //         }
  // }

 }