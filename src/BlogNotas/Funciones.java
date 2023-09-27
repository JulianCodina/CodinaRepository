package BlogNotas;
import java.io.*;
import java.util.Scanner;

public class Funciones {
    public static String crear(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del archivo: ");
        String nombre = sc.nextLine();

        File archivo = new File(nombre + ".txt");
        try{
            if(archivo.createNewFile()){
                System.out.println("- Archivo creado exitosamente-");
            }else{
                System.out.println("- El archivo ya existe -");
            }
        }catch (IOException e){
            System.out.println("ERROR al crear el archivo: " + e.getMessage());
        }
        return nombre;
    }

    public static String abrir(String nombre){
        StringBuilder contenido = new StringBuilder();
        try {
            String linea;
            File archivo = new File(nombre + ".txt");
            if(archivo.exists()) {
                System.out.println("- Archivo abierto -");
                BufferedReader br = new BufferedReader(new FileReader(nombre + ".txt"));

                System.out.print("contenido: \n");

                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                    contenido.append(linea).append("\n");
                }
                br.close();
            }else{
                System.out.println("- Archivo no encontrado.-");
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }
        return contenido.toString();
    }

    public static void escribir(String nombre, String contenido){
        Scanner sc = new Scanner(System.in);
        System.out.print("Para terminar de escribir ingrese una linea vacia.\n->");

        try {
            FileWriter archivo = new FileWriter(nombre + ".txt", true);
            String texto;
            do{
                texto = sc.nextLine();
                contenido += texto+' ';
                archivo.write(texto+' ');
            }while(!texto.isEmpty());
            archivo.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void eliminar(String nombre) {
        File archivo = new File(nombre + ".txt");

        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("- Archivo eliminado exitosamente -");
            } else {
                System.out.println("- No se pudo eliminar el archivo -");
            }
        } else {
            System.out.println("- Archivo no encontrado -");
        }
    }

    public static void listarArchivos(){
        File directorioActual = new File(".");
        File[] archivos = directorioActual.listFiles();

        if (archivos != null) {
            System.out.println("- Archivos en el directorio actual: -");
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    System.out.println(archivo.getName());
                }
            }
        }
    }
}
