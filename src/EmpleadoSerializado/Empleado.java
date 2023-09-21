package EmpleadoSerializado;

import java.io.Serializable;

public abstract class Empleado implements Impuesto, Serializable {
     public String nombre;
     public int id;
     public double sueldoBase;

    public abstract double calcularSueldo();

    public void calcularImpuesto(){}

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", sueldoBase=" + sueldoBase +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}
