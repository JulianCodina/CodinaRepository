package AstVehiculos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Concesionaria concesionaria = new Concesionaria();

        String archivo = "listaVehiculos.txt";

        boolean salir = false;
        int tipoVehiculo;
        int opc;

        concesionaria.cargar(archivo);

        while (!salir){

            System.out.println("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                Deseas realizar una operación?
                1) Agregar
                2) Eliminar
                3) Editar precio
                4) Mostrar información
                5) Leer archivo guardado
                6) Salir
                """);

            opc = input.nextInt();
            input.nextLine(); // Consume la nueva línea pendiente después de nextInt()

            switch (opc){

                case 1: // agregar
                    System.out.println("""
                    Deseas agregar:
                    1) Coche
                    2) Moto
                    """);
                    tipoVehiculo = input.nextInt();
                    input.nextLine(); // Consume la nueva línea pendiente después de nextInt()

                    if (tipoVehiculo == 1) {

                        // Agregar un coche
                        System.out.print("Marca: ");
                        String marca = input.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = input.nextLine();
                        System.out.print("Precio: ");
                        double precio = input.nextDouble();
                        input.nextLine(); // Consume la nueva línea pendiente después de nextDouble()
                        Coche coche = new Coche(marca, modelo, precio);

                        concesionaria.agregarVehiculo(coche);
                        concesionaria.guardar(archivo); // Guardar después de agregar

                    } else if (tipoVehiculo == 2) {

                        // Agregar una moto
                        System.out.print("Marca: ");
                        String marca = input.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = input.nextLine();
                        System.out.print("Precio: ");
                        double precio = input.nextDouble();
                        input.nextLine(); // Consume la nueva línea pendiente después de nextDouble()
                        Moto moto = new Moto(marca, modelo, precio);

                        concesionaria.agregarVehiculo(moto);
                        concesionaria.guardar(archivo); // Guardar después de agregar

                    } else {
                        System.out.println("ERROR: opción incorrecta");
                    }

                    break;

                case 2: // eliminar

                    System.out.println("""
                        Deseas eliminar:
                        1) Coche
                        2) Moto
                        """);

                    tipoVehiculo = input.nextInt();
                    input.nextLine(); // Consume la nueva línea pendiente después de nextInt()

                    if(tipoVehiculo == 1){

                        // eliminar un coche
                        System.out.print("Marca: ");
                        String marca = input.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = input.nextLine();

                        concesionaria.eliminarVehiculo(marca, modelo);
                        concesionaria.guardar(archivo); // Guardar después de eliminar

                    } else if(tipoVehiculo == 2){

                        // eliminar una moto
                        System.out.print("Marca: ");
                        String marca = input.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = input.nextLine();

                        concesionaria.eliminarVehiculo(marca, modelo);
                        concesionaria.guardar(archivo); // Guardar después de eliminar

                    } else {
                        System.out.println("ERROR: opción incorrecta");
                    }

                    break;

                case 3: // editar precio

                    System.out.println("""
                    Deseas editar:
                    1) Coche
                    2) Moto
                    """);
                    tipoVehiculo = input.nextInt();
                    input.nextLine(); // Consume la nueva línea pendiente después de nextInt()

                    if (tipoVehiculo == 1) {

                        // editar un coche
                        System.out.print("Marca: ");
                        String marca = input.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = input.nextLine();
                        System.out.print("Precio nuevo: ");
                        double precioNuevo = input.nextDouble();
                        input.nextLine(); // Consume la nueva línea pendiente después de nextDouble()

                        concesionaria.editarPrecio(marca, modelo, precioNuevo);
                        concesionaria.guardar(archivo); // Guardar después de editar

                    } else if (tipoVehiculo == 2) {

                        // editar una moto
                        System.out.print("Marca: ");
                        String marca = input.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = input.nextLine();
                        System.out.print("Precio nuevo: ");
                        double precioNuevo = input.nextDouble();
                        input.nextLine(); // Consume la nueva línea pendiente después de nextDouble()

                        concesionaria.editarPrecio(marca, modelo, precioNuevo);
                        concesionaria.guardar(archivo); // Guardar después de editar

                    } else {
                        System.out.println("ERROR: opción incorrecta");
                    }

                    break;

                case 4: // mostrar información

                    concesionaria.mostrarInventario();
                    break;

                case 5: // leer archivo

                    concesionaria.cargar(archivo);

                    break;

                case 6:
                    salir = true;
                    concesionaria.guardar(archivo);
                    break;

                default:
                    System.out.println("ERROR: opción inválida");
            }
        }
    }
}
