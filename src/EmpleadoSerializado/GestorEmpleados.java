package EmpleadoSerializado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorEmpleados implements Serializable {
    List <Empleado> staff;

    public GestorEmpleados() {
        this.staff = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "EmpleadoSerializado.GestorEmpleados{" +
                "staff=" + staff +
                '}';
    }

    public void add(){
        Scanner input = new Scanner(System.in);

        try{
            System.out.println("Ingrese la informacion del empleado: ");
            System.out.println("""
                    Tipo de empleado:
                    [1]: Empleado Asalariado
                    [2]: Empleado por Horas
                    [3]: Epleado comisión""");
            int opcion = Main.verifyRange();
            System.out.print("Nombre: ");
            String nombre = input.nextLine();
            System.out.print("ID: ");
            int id = input.nextInt();
            System.out.print("Sueldo Base: ");
            double sueldo = input.nextDouble();

            switch (opcion) {
                case 1 -> staff.add(new EmpleadoAsalariado(nombre, id, sueldo));
                case 2 -> {
                    System.out.print("Horas trabajadas: ");
                    int horas = input.nextInt();
                    staff.add(new EmpleadoPorHoras(nombre, id, sueldo, horas));
                }
                case 3 -> {
                    System.out.print("Ventas hechas: ");
                    int ventas = input.nextInt();
                    staff.add(new EmpleadoComision(nombre, id, sueldo, ventas));
                }
            }
        }catch(ExceptionRange e){
            System.out.println(e.getMessage());
        }
    }
    public void remove(){
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el ID del empleado: ");
        int id = input.nextInt();
        staff.removeIf(empleado -> empleado.id == id);
    }
    public void modify(){
        Scanner input = new Scanner(System.in);
        System.out.println("Actualmente hay "+ staff.size() +" empleados");
        System.out.print("Ingrese el ID del empleado: ");
        int id = input.nextInt();
        for (Empleado empleado : staff) {
            if (empleado.getId() == id) {
                System.out.println("Datos actuales del empleado:");
                System.out.println(empleado);
                empleado.calcularImpuesto();
                System.out.println("""
                        Que datos desea modificar?:
                        [1]: Nombre
                        [2]: Salario Base
                        [3]: Horas o ventas""");
                try {
                    int opcion = Main.verifyRange();
                    switch (opcion) {
                        case 1 -> {
                            System.out.print("Cambiar nombre: ");
                            empleado.setNombre(input.nextLine());
                        }
                        case 2 -> {
                            System.out.print("Cambiar sueldo base: ");
                            empleado.setSueldoBase(input.nextInt());
                        }
                        case 3 -> {
                            if (empleado instanceof EmpleadoPorHoras) {
                                System.out.print("Cambiar horas: ");
                                ((EmpleadoPorHoras) empleado).setHorasTrabajadas(input.nextInt());
                            } else if (empleado instanceof EmpleadoComision) {
                                System.out.print("Cambiar ventas: ");
                                ((EmpleadoComision) empleado).setVentasRealizadas(input.nextInt());
                            } else System.out.println("El empleado no tiene ese tipo de dato");
                        }
                    }
                }catch(ExceptionRange e){
                    System.out.println(e.getMessage());
                }

                System.out.println("Datos actualizados del empleado:");
                System.out.println(empleado);
                empleado.calcularImpuesto();
                break;
            }
        }

    }
}
