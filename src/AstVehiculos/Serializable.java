package AstVehiculos;

public interface Serializable extends java.io.Serializable{
    void guardar(String nombreArchivo);
    void cargar(String nombreArchivo);
}
