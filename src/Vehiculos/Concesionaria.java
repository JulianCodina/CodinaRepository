package Vehiculos;

import java.io.*;
import java.util.ArrayList;

public class Concesionaria implements Serializable {
    private ArrayList<Vehiculo> staff = new ArrayList<>();

    @Override
    public void guardar(String Archivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(Archivo))) {
            outputStream.writeObject(staff);
            System.out.println("Datos guardados con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cargar(String Archivo) {
        File archivo = new File(Archivo);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe en la ruta especificada. Se creará uno nuevo.");
            return;
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(Archivo))) {
            ArrayList<Vehiculo> concesionariaCargada = (ArrayList<Vehiculo>) inputStream.readObject();
            this.staff = concesionariaCargada;
            System.out.println("Datos cargados con éxito.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void agregarVehiculo(Vehiculo v){
        staff.add(v);
    }
    public void eliminarvehiculo(String marca, String modelo){
        boolean exist = false;
        for(Vehiculo v : staff){
            if(v.getMarca().equals(marca) && v.getModelo().equals(modelo)){
                staff.remove(v);
                System.out.println("- Vehiculo eliminado -");
                exist = true;
                break;
            }
        }
        if(!exist)System.out.println("- No se encontró el vehiculo -");
    }
    public void editarVehiculo(String marca, String modelo, double precio) {
        boolean exist = false;
        for (Vehiculo v : staff) {
            if (v != null && v.getMarca() != null && v.getModelo() != null && v.getMarca().equals(marca) && v.getModelo().equals(modelo)) {
                v.setPrecio(precio);
                System.out.println("- Precio del vehiculo modificado -");
                exist = true;
                break;
            }
        }
        if(!exist)System.out.println("- No se encontró el vehiculo -");
    }
    public void mostrarInventario(){
        if (staff.isEmpty()) System.out.println("- No se encontró ningun vehiculo en el inventario -");

        for(Vehiculo v : staff){
            v.mostrarInformacion();
        }
    }
}

