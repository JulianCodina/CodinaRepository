package AstVehiculos;

public abstract class Vehiculo implements Serializable{
    private String marca;
    private String modelo;
    private double precio;

    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public abstract double calcularImpuesto();

    public abstract void mostrarInformacion();

    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Precio: $" + precio;
    }
}


class Coche extends Vehiculo{
    public Coche(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public double calcularImpuesto() {
        // Implementa el cálculo de impuesto para coches
        return getPrecio() * 0.1;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo: Coche, " + this);
    }

    @Override
    public void guardar(String nombreArchivo) {

    }

    @Override
    public void cargar(String nombreArchivo) {

    }
}

class Moto extends Vehiculo {
    public Moto(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public double calcularImpuesto() {
        // Implementa el cálculo de impuesto para motos
        return getPrecio() * 0.05;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo: Moto, " + this);
    }

    @Override
    public void guardar(String nombreArchivo) {

    }

    @Override
    public void cargar(String nombreArchivo) {

    }
}
