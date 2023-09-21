package EmpleadoSerializado;

public class EmpleadoPorHoras extends Empleado implements Impuesto{
    public int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = sueldoBase;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSueldo() {
        double total;
        if(horasTrabajadas>40) {
            total = this.sueldoBase + horasTrabajadas * 6000;
        }else{
            total = (sueldoBase / 40) * horasTrabajadas;
        }
        return total;
    }
    public void calcularImpuesto(){
        System.out.println("Impuestos= "+this.calcularSueldo()*0.12);
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public String toString() {
        return "Empleado Por Horas {" +
                " Horas Trabajadas=" + horasTrabajadas +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                ", sueldo Base=" + sueldoBase +
                ", sueldo Total= " + this.calcularSueldo() +
                '}';
    }
}
