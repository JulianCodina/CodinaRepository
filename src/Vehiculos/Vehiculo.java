package Vehiculos;
import java.io.Serializable;

public abstract class Vehiculo  implements Vehiculos.Serializable {
    protected String marca;
    protected String modelo;
    protected double precio;

    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    public abstract void mostrarInformacion();

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio;
    }
}

class Coche extends Vehiculo {

    public Coche(String marca, String modelo, double precio) {
        super(marca,modelo,precio);
    }


    public void mostrarInformacion() {
        System.out.println("Tipo: Coche, " + this);
    }

    @Override
    public void guardar(String nombreArchivo) {}
    @Override
    public void cargar(String nombreArchivo) {}

}
class Moto extends Vehiculo{

    public Moto(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }


    public void mostrarInformacion() {
        System.out.println("Tipo: Moto, " + this);
    }

    @Override
    public void guardar(String nombreArchivo) {}
    @Override
    public void cargar(String nombreArchivo) {}

}

