package Cuenta;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorCuentas gestor = new GestorCuentas();
        int repit;
        do{
            System.out.println("""
                                Que desea hacer:
                                [1]: Agregar una cuenta
                                [2]: Eliminar una cuenta
                                [3]: Modificar una cuenta
                                [4]: Mostrar informacion de las cuentas""");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese informacion de la cuenta: ");
                    System.out.print("ID cuenta: ");
                    int id = sc.nextInt();
                    System.out.println("Tipo de cuenta: \n[1]:Personal\n[2]:Sociedad");
                    int tipoCuenta = sc.nextInt();
                    if (tipoCuenta == 1) {
                        System.out.print("Nombre y Apellido del Propietario: ");
                        String nombre = sc.next();
                        String apellido = sc.next();
                        System.out.print("Saldo: ");
                        double saldo = sc.nextDouble();
                        gestor.agregarCuentaPersonal(new CuentaPersonal(id, saldo, nombre, apellido));
                    } else if (tipoCuenta == 2) {
                        sc.nextLine();//se bugea con el /int tipoCuenta = sc.nextInt();/
                        System.out.print("Nombre de Empresa: ");
                        String nombre = sc.nextLine();
                        System.out.print("Tipo de Empresa: ");
                        String tipo = sc.nextLine();
                        System.out.print("Saldo: ");
                        double saldo = sc.nextDouble();
                        gestor.agregarCuentaSociedad(new CuentaSociedad(id, saldo, nombre, tipo));
                    }else System.out.println("Opcion Invalida");
                }
                case 2 -> {
                    System.out.print("Ingrese el ID de la cuenta a borrar: ");
                    int borrar = sc.nextInt();
                    gestor.eliminarCuentaPersonal(borrar);
                    gestor.eliminarCuentaSociedad(borrar);
                }
                case 3 -> {
                    System.out.print("Ingrese el ID de la cuenta a modificar: ");
                    int id = sc.nextInt();
                    System.out.print("Ingrese el saldo correspondiente: ");
                    double saldo = sc.nextDouble();
                    gestor.editarCuentaPersona(id,saldo);
                    gestor.editarCuentaSociedad(id,saldo);
                }
                case 4 -> gestor.mostrarTodasLasCuentas();

                default -> System.out.println("ERROR: Opcion "+ opcion + " invalida.");
            }
            System.out.println("Quiere realizar otra acción?\n[1]: Sí");
            repit=sc.nextInt();
        }while (repit==1);
    }
}
