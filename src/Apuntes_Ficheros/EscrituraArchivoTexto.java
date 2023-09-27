package Apuntes_Ficheros;
import java.io.*;

public class EscrituraArchivoTexto {

    public static void escribirArchivoTexto(String nombreArchivo, String contenido) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            escritor.write(contenido);
            System.out.println("Contenido escrito en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de cómo crear, escribir y guardar un archivo de texto
        String nombreArchivo = "archivo.txt";
        String contenido = "Este es el contenido del archivo de texto.";

        escribirArchivoTexto(nombreArchivo, contenido);
    }
}

