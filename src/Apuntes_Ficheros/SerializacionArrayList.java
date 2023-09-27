package Apuntes_Ficheros;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializacionArrayList {

    public static void guardarArrayListSerializado(List<MiObjeto2> listaObjetos, String nombreArchivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(listaObjetos);
            System.out.println("ArrayList serializado guardado en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<MiObjeto2> cargarArrayListSerializado(String nombreArchivo) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            List<MiObjeto2> listaObjetos = (List<MiObjeto2>) entrada.readObject();
            System.out.println("ArrayList serializado cargado desde " + nombreArchivo);
            return listaObjetos;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Ejemplo de cómo guardar y cargar un ArrayList serializado
        String nombreArchivo = "arraylist_serializado.ser";

        // Crear un ArrayList de objetos
        List<MiObjeto2> listaObjetos = new ArrayList<>();
        listaObjetos.add(new MiObjeto2("Objeto 1"));
        listaObjetos.add(new MiObjeto2("Objeto 2"));
        listaObjetos.add(new MiObjeto2("Objeto 3"));

        // Guardar el ArrayList serializado
        guardarArrayListSerializado(listaObjetos, nombreArchivo);

        // Cargar el ArrayList serializado
        List<MiObjeto2> listaCargada = cargarArrayListSerializado(nombreArchivo);

        // Verificar si se cargó correctamente
        if (listaCargada != null) {
            System.out.println("Elementos en el ArrayList cargado:");
            for (MiObjeto2 objeto : listaCargada) {
                System.out.println(objeto.getTexto());
            }
        }
    }
}

// Clase que se va a serializar
class MiObjeto2 implements Serializable {
    private String texto;

    public MiObjeto2(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
