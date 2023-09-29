package Hotel;

import Vehiculos.Vehiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

interface MostrarInformacion {
    void mostrarInfo();
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Habitaciones> habitaciones = new ArrayList<>();
        habitaciones.add(new Habitaciones(4,3,1));
        habitaciones.add(new Habitaciones(5,4,2));
        habitaciones.add(new Habitaciones(3,3,3));

        String nombreHotel = "";
        try {
            File archivoHotel = new File("nombreHotel.txt");
            Scanner archivoScanner = new Scanner(archivoHotel);

            nombreHotel = archivoScanner.nextLine();
            archivoScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: El archivo de nombre del hotel no se encuentra.");
        }
        if (nombreHotel != null) {
            System.out.println("BIENVENIDO A " + nombreHotel);
        } else {
            System.out.println("BIENVENIDO A [CREAR EN EL PROYECTO UN .TXT CON NOMBRE DEL HOTEL ADENTRO]"); // Nombre predeterminado en caso de error
        }


        try {
            boolean exit = false;
            do {
                System.out.println("-------------------------------------");
                System.out.print("""
                        Menu:
                        1. Ver la lista de habitaciones.
                        2. Reservar una habitacion.
                        3. Cancelar una reserva.
                        4. Guardar reservas en un archivo.
                        5. Cargar reservas desde un archivo.
                        6. Salir
                        →\s""");
                int opc = sc.nextInt();
                int numero;
                switch (opc) {
                    case 1://Ver la lista de habitaciones
                        for (Habitaciones h : habitaciones) {
                            h.Listado();
                        }
                        break;
                    case 2://Reservar una habitación.
                        sc.nextLine();

                        for (Habitaciones h : habitaciones) {
                            if (!h.isEstado()) {
                                h.mostrarInfo();
                            }
                        }
                        boolean next = false;
                        do {
                            System.out.print("Seleccione la habitacion que reservará: ");
                            numero = sc.nextInt();

                            for (Habitaciones h : habitaciones) {
                                if (h.getNumero() == numero) {
                                    if (h.isEstado()) {
                                        System.out.println("Esa habitacion no esta disponible.");
                                        next = true;
                                    }
                                }
                            }
                        } while (next);

                        for (Habitaciones h : habitaciones) {
                            if (h.getNumero() == numero) {
                                System.out.print("Ingrese cantidad de huespedes: ");
                                int cant = sc.nextInt();
                                sc.nextLine();
                                for (int i = 1; i <= cant; i++) {
                                    System.out.println("Ingrese los datos del huesped " + i);
                                    System.out.print("Nombre y apellido: ");
                                    String nombreApellido = sc.nextLine();
                                    System.out.print("Nacionalidad: ");
                                    String nacionalidad = sc.nextLine();

                                    h.agregarHuesped(new Huespedes(nombreApellido, nacionalidad));
                                }
                                System.out.println("- Reserva exitosa -");
                            }
                        }
                        break;
                    case 3://Cancelar una reserva.
                        sc.nextLine();
                        boolean exist = false;
                        System.out.print("A que habitacion se cancela la reserva: ");
                        numero = sc.nextInt();
                        for (Habitaciones h : habitaciones) {
                            if (h.getNumero() == numero) {
                                h.eliminarHuesped();
                                exist = true;
                                System.out.println("- Reserva cancelada -");
                            }
                        }
                        if (!exist) System.out.println("La habitacion no existe");
                        break;
                    case 4://Guardar reservas en un archivo.
                        String archivoGuardado = "hotel.txt";

                        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivoGuardado))) {
                            outputStream.writeObject(habitaciones);
                            System.out.println("- Datos guardados con éxito.-");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5://Cargar reservas desde un archivo.
                        String archivoCarga = "hotel.txt";

                        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivoCarga))) {
                            ArrayList<Habitaciones> hotel = (ArrayList<Habitaciones>) inputStream.readObject();
                            habitaciones = hotel;
                            System.out.println("Datos cargados con éxito.");
                        } catch (EOFException e) {
                            System.err.println("El archivo está vacío o dañado.");
                        } catch (FileNotFoundException e) {
                            System.err.println("El archivo de carga no se encuentra.");
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 6:
                        exit = true;
                        break;
                }
            } while (!exit);
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Debe ingresar un número.");
            }
        }
    }


    abstract class Persona implements Serializable{
        private String nombreApellido;

        public Persona(String nombreApellido) {
            this.nombreApellido = nombreApellido;
        }

        public Persona() {
        }

        public String getNombreApellido() {
            return nombreApellido;
        }
        public abstract void mostrarInfo();
    }

    class Huespedes extends Persona implements MostrarInformacion, Serializable {
        private String nacionalidad;

        public Huespedes(String nombreApellido, String nacional) {
            super(nombreApellido);
            this.nacionalidad = nacional;
        }
        public Huespedes() {
            super("");
            this.nacionalidad = "";
        }

        @Override
        public void mostrarInfo() {
            System.out.println("- Huesped: " + super.getNombreApellido() + ", nacionalidad: " + nacionalidad);
        }
    }

    class Habitaciones implements MostrarInformacion, Serializable {
        private int camas;
        private int capacidad;
        private int numero;
        private boolean Estado;
        List<Huespedes> huespedes = new ArrayList<>();

        public Habitaciones(int camas, int capacidad, int numero) {
            this.camas = camas;
            this.capacidad = capacidad;
            this.numero = numero;
            this.Estado = false;
        }

        public Habitaciones(int camas, int capacidad, int numero, List huespedes) {
            this.camas = camas;
            this.capacidad = capacidad;
            this.numero = numero;
            this.huespedes = huespedes;
            this.Estado = true;
        }
        public Habitaciones() {
            this.camas = 0;
            this.capacidad = 0;
            this.numero = 0;
            this.Estado = false;
            this.huespedes = new ArrayList<>();
        }

        public void Listado() {
            if (Estado) {
                System.out.println("La habitacion " + this.numero + " esta ocupada.");
                for (Huespedes h : huespedes) {
                    h.mostrarInfo();
                }
            } else {
                System.out.println("La habitacion " + this.numero + " esta libre.");
            }
        }

        public void mostrarInfo() {
            if (Estado) {
                System.out.println("La habitacion " + this.numero + " esta ocupada\n");
                for (Huespedes h : huespedes) {
                    h.mostrarInfo();
                }
                System.out.println("camas: " + camas + "\ncapacidad: " + capacidad + "\n");
            } else {
                System.out.println("La habitacion " + this.numero + " esta libre\ncamas: " + camas + "\ncapacidad: " + capacidad + "\n");
            }
        }

        public void agregarHuesped(Huespedes huespedes) {
            this.huespedes.add(huespedes);
            this.setEstado(true);
        }

        public void eliminarHuesped() {
            huespedes.clear();
            this.setEstado(false);
        }

        public int getNumero() {
            return numero;
        }

        public boolean isEstado() {
            return Estado;
        }

        public void setEstado(boolean estado) {
            Estado = estado;
        }
    }


