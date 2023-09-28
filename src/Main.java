import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Habitaciones> habitaciones = new ArrayList <>();
        habitaciones.add(new Habitaciones(4,4,1));
        habitaciones.add(new Habitaciones(5,6,2));
        habitaciones.add(new Habitaciones(5,5,3));
        try {
            boolean exit = false;
            do {
                System.out.println("-------------------------------------");
                System.out.print("Menu:\n1. Ver la lista de habitaciones.\n" + "2. Reservar una habitacion.\n3. Cancelar una reserva.\n" + "4. Guardar reservas en un archivo.\n" + "5. Cargar reservas desde un archivo.\n6. Salir\n→");
                int opc = sc.nextInt();
                switch (opc) {
                    case 1://Ver la lista de habitaciones
                        for(Habitaciones h : habitaciones){
                            h.Listado();
                        }
                        break;
                    case 2://Reservar una habitación.
                        sc.nextLine();
                        for(Habitaciones h : habitaciones) {
                            if (h.isEstado() == false) {
                                h.mostarInfo();
                            }
                        }

                        for(Habitaciones h : habitaciones){
                            if(h.isEstado()==false) {
                                h.mostarInfo();
                            }
                            for(int i=0; i<h.getCapacidad(); i++) {
                                System.out.print("Ingrese su nombre y apellido: ");
                                String nombreApellido = sc.nextLine();
                                System.out.print("Ingrese su nombre y apellido: ");
                                String nacionalidad = sc.nextLine();
                                h.setHuesped(new Huespedes(nombreApellido,nacionalidad));
                            }
                            break;
                        }

                        System.out.println("Lo sentimos. Todas las habitaciones ya estan reservadas");
                        break;
                    case 3://Cancelar una reserva.
                        sc.nextLine();
                        System.out.print("A que habitacion se cancela la reserva: ");
                        int numero = sc.nextInt();
                        for(Habitaciones h : habitaciones){
                            if(h.getNumero()==numero){
                                h.setHuesped(null);
                            }else{
                                System.out.println("La habitacion no existe");
                            }
                        }
                        break;
                    case 4://Guardar reservas en un archivo.

                        break;
                    case 5://Cargar reservas desde un archivo.
                        break;
                    case 6:
                        exit = true;
                        break;
                }
            } while (!exit);
        }catch (InputMismatchException e) {
            System.err.println("Entrada inválida. Debe ingresar un número.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}
