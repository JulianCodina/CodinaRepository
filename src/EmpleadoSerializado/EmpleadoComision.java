package EmpleadoSerializado;

public class EmpleadoComision extends Empleado implements Impuesto{

    int ventasRealizadas;
    public EmpleadoComision(String nombre, int id, double sueldoBase,int ventasRealizadas) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = sueldoBase;
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public double calcularSueldo() {
        return this.sueldoBase + (ventasRealizadas * 25000);
    }
    public void calcularImpuesto(){
        System.out.println("Impuestos= "+this.calcularSueldo()*0.15);
    }

    @Override
    public String toString() {
        return "EmpleadoComision {" +
                " Ventas Realizadas=" + ventasRealizadas +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                ", sueldo Base=" + sueldoBase +
                ", sueldo Total= " + this.calcularSueldo() +
                '}';
    }

    public void setVentasRealizadas(int ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }
}
