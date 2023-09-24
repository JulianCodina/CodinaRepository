package AstVehiculos;

import java.io.*;
import java.util.ArrayList;

public class Concesionaria implements Serializable{
    private ArrayList<Vehiculo> inventario = new ArrayList<>();

    public void agregarVehiculo(Vehiculo vehiculo) {
        inventario.add(vehiculo);
    }

    public void eliminarVehiculo(String marca, String modelo) {
        inventario.removeIf(v -> v.getMarca().equals(marca) && v.getModelo().equals(modelo));
    }

    public void editarPrecio(String marca, String modelo, double nuevoPrecio) {
        for (Vehiculo vehiculo : inventario) {
            if (vehiculo.getMarca().equals(marca) && vehiculo.getModelo().equals(modelo)) {
                vehiculo.setPrecio(nuevoPrecio);
                break;
            }
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventario de la Concesionaria:");
        for (Vehiculo vehiculo : inventario) {
            vehiculo.mostrarInformacion();
        }
    }

    public void guardar(String nombreArchivo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(this);
            System.out.println("Estado de la concesionaria guardado en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar la concesionaria en el archivo " + nombreArchivo);
            e.printStackTrace();
        }
    }

    public void cargar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe en la ruta especificada. Se creará uno nuevo.");
            return;
        }

        try (FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Concesionaria concesionariaCargada = (Concesionaria) objectInputStream.readObject();
            this.inventario = concesionariaCargada.inventario;

            System.out.println("Estado de la concesionaria cargado desde " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar la concesionaria desde el archivo " + nombreArchivo);
            e.printStackTrace();
        }
    }
}



