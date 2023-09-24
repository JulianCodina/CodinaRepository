package Vehiculos;

public interface Serializable extends java.io.Serializable {
    void guardar(String archivo);
    void cargar(String archivo);
}
