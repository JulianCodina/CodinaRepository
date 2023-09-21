package EmpleadoSerializado;

public class EmpleadoAsalariado extends Empleado{
    public EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = sueldoBase;
    }

    @Override
    public double calcularSueldo() {
        return this.sueldoBase;
    }
    public void calcularImpuesto(){
        System.out.println("Impuestos= "+this.calcularSueldo()*0.2);
    }

    @Override
    public String toString() {
        return "Empleado Asalariado {" +
                "nombre= '" + nombre + '\'' +
                ", id= " + id +
                ", sueldo Base= " + sueldoBase +
                ", sueldo Total= " + this.calcularSueldo() +
                '}';
    }
}
