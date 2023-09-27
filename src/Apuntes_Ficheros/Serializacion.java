package Apuntes_Ficheros;
import java.io.*;
public class Serializacion {
    public static void guardarObjetoSerializado(Object objeto, String nombreArchivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(objeto);
            System.out.println("Objeto serializado guardado en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object cargarObjetoSerializado(String nombreArchivo) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Object objeto = entrada.readObject();
            System.out.println("Objeto serializado cargado desde " + nombreArchivo);
            return objeto;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Ejemplo de cómo guardar y cargar un objeto serializado
        String nombreArchivo = "objeto_serializado.txt";

        // Objeto a serializar y guardar
        MiObjeto objetoParaGuardar = new MiObjeto("Hola, mundo!");

        // Guardar el objeto serializado
        guardarObjetoSerializado(objetoParaGuardar, nombreArchivo);

        // Cargar el objeto serializado
        MiObjeto objetoCargado = (MiObjeto) cargarObjetoSerializado(nombreArchivo);

        // Verificar si se cargó correctamente
        if (objetoCargado != null) {
            System.out.println("Texto en el objeto cargado: " + objetoCargado.getTexto());
        }
    }
}

// Clase que se va a serializar
class MiObjeto implements Serializable {
    private String texto;

    public MiObjeto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}

