package Vehiculos;

import java.util.InputMismatchException;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        try {
        Scanner sc = new Scanner(System.in);
        Concesionaria gestor = new Concesionaria();

        String archivo = "vehiculos.txt";
        gestor.cargar(archivo);

        boolean salir = false;
        int repit;
        do{
            System.out.println("""
                                -------------------------------------------------------
                                Que desea hacer:
                                [1]: Agregar un vehiculo
                                [2]: Eliminar un vehiculo
                                [3]: Modificar un vehiculo
                                [4]: Mostrar inventario
                                [5]: Salir""");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese informacion del vehiculo: ");
                    sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    do {
                        repit=0;
                        System.out.println("""
                                Tipo de vehiculo:
                                [1]: Coche
                                [2]: Moto""");
                        int tipo = sc.nextInt();
                        if (tipo == 1) {
                            gestor.agregarVehiculo(new Coche(marca, modelo, precio));
                        } else if (tipo == 2) {
                            gestor.agregarVehiculo(new Moto(marca, modelo, precio));
                        } else {
                            System.out.println("Opcion invalida");
                            repit=1;
                        }

                    }while (repit == 1);
                }
                case 2 -> {
                    System.out.println("Ingrese la la informacion del vehiculo a eliminar ");
                    sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    gestor.eliminarvehiculo(marca, modelo);

                }
                case 3 -> {
                    System.out.print("Ingrese la informacion del vehiculo a modificar\n");
                    sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    gestor.editarVehiculo(marca, modelo, precio);

                }
                case 4 -> gestor.mostrarInventario();
                case 5 -> salir=true;

                default -> System.out.println("ERROR: Opcion "+ opcion + " invalida.");
            }

        }while (!salir);
        gestor.guardar(archivo);
        } catch (InputMismatchException e) {
            System.err.println("Entrada inválida. Debe ingresar un número.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}
