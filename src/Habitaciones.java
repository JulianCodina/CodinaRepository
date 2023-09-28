import java.util.ArrayList;
import java.util.List;

public class Habitaciones {
    private int camas;
    private int capacidad;
    private int numero;
    private boolean Estado;
    List <Huespedes> huespedes = new ArrayList <>();

    public Habitaciones(int camas, int capacidad, int numero) {
        this.camas = camas;
        this.capacidad = capacidad;
        this.numero = numero;
        this.huespedes = null;
        this.Estado = false;
    }

    public Habitaciones(int camas, int capacidad, int numero, List huespedes) {
        this.camas = camas;
        this.capacidad = capacidad;
        this.numero = numero;
        this.huespedes = huespedes;
        this.Estado = true;
    }

    public void Listado() {
        if (Estado) {
            System.out.println("La habitacion "+numero+" esta ocupada\n" + huespedes.toString());
        } else {
            System.out.println("La habitacion "+numero+" esta libre");
        }
    }
    public void mostarInfo(){
        if (Estado) {
            System.out.println("La habitacion "+numero+" esta ocupada\n" + huespedes.toString()+"camas: "+camas+"\ncapacidad: "+capacidad);
        } else {
            System.out.println("La habitacion esta libre\ncamas: "+camas+"\ncapacidad: "+capacidad);
        }
    }

    public void setHuesped(Huespedes huespedes) {
        this.huespedes.add(huespedes);
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getCamas() {
        return camas;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }
}
