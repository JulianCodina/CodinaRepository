package Parcial1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Informacion{
    void verHistorialDeEventos();
}
class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String contacto = "";
        try {
            File archivoHospital = new File("nombreHospital.txt");
            Scanner archivoScanner = new Scanner(archivoHospital);

            contacto = archivoScanner.nextLine();
            archivoScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: El archivo de nombre del hotel no se encuentra.");
        }
        if (contacto != null) {
            System.out.println("BIENVENIDO A " + contacto);
        } else {
            System.out.println("BIENVENIDO A [CREAR UN .TXT CON EL CONTACTO DEL HOTEL ADENTRO]");
        }

        List<Doctores> doctores = new ArrayList<>();
        doctores.add(new Doctores("Dr. James", 40371208, "07/01/1980", "Terapeuta"));
        doctores.add(new Doctores("Dr. Carlitos", 37876543, "04/09/1975", "Pediatra"));

        List<Pacientes> pacientes = new ArrayList <>();

        boolean exit = false;
        do {
            System.out.print("Menu:\n1. Listar Doctores\n2. Registrar un nuevo paciente.\n3. Actualizar información personal de un paciente.\n" +
                    "4. Consultar el historial medico de un paciente.\n5. Nuevo historial para un paciente. \n" +
                    "6. Guardar Historial de pacientes en archivo \n7. Cargar Historial de pacientes desde archivo \n" +
                    "8. Salir.\n→ ");
            int opc = sc.nextInt();
            switch (opc) {
                case 1:// Listar Doctores.
                    for (Doctores d : doctores) {
                        System.out.println(d.Listar());
                    }
                    break;
                case 2://Registrar un nuevo paciente.
                    System.out.println("Ingrese los datos del paciente:");
                    System.out.print("Nombre y apellido: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    System.out.print("DNI: ");
                    int dni = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fecha de nacimiento(dd/mm/yyyy): ");
                    String fechaN = sc.nextLine();
                    System.out.print("Numero de telefono: ");
                    int numTel = sc.nextInt();
                    System.out.print("Tipo Sanguineo: ");
                    int TipoSang = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese los eventos medicos del paciente:");
                    System.out.print("Para terminar inserte 1\n→ ");
                    boolean listo = false;
                    int cont=1;
                    String evento;
                    List<String> historial = new ArrayList <>();
                    do{
                        System.out.println("Evento "+cont+" :");
                        evento=sc.nextLine();
                        if(evento.equals("1")){
                            listo=true;
                        }else{
                            historial.add(evento);
                        }
                        cont++;
                    }while(!listo);

                    pacientes.add(new Pacientes(nombre, dni, fechaN, numTel,TipoSang,historial));
                    System.out.println("- Se lo agregó exitosamente -");
                    break;
                case 3://Actualizar información personal de un paciente.
                    System.out.print("Ingrese el DNI del paciente: ");
                    int DNI=sc.nextInt();
                    sc.nextLine();
                    for (Pacientes p : pacientes) {
                        if (p.getDNI() == DNI) {
                            System.out.println("Ingrese la informacion del paciente:");
                            System.out.print("Nombre y Apellido: ");
                            String nuevoNombre = sc.nextLine();
                            p.setNombre(nuevoNombre);
                            System.out.print("Numero Telefonico: ");
                            int nuevoNroTelef = sc.nextInt();
                            p.setNroTelef(nuevoNroTelef);

                            System.out.println("Ingrese los eventos medicos del paciente:");
                            System.out.print("Para terminar inserte 1\n→ ");
                            listo = false;
                            cont=1;
                            evento="1";
                            List<String> historial2 = new ArrayList <>();
                            do{
                                System.out.println("Evento "+cont+" :");
                                evento=sc.nextLine();
                                if(evento.equals("1")){
                                    listo=true;
                                }else{
                                    historial2.add(evento);
                                }
                                cont++;
                            }while(!listo);
                            p.setHistorialMedico(historial2);
                            System.out.println("- Información del paciente actualizada. -");
                            break;
                        }
                    }
                    System.out.println("- Paciente no encontrado. -");
                    break;
                case 4://Consultar el historial médico de un paciente.
                    System.out.println("Ingrese el DNI del paciente: a buscar");
                    DNI=sc.nextInt();
                    sc.nextLine();
                    for (Pacientes p : pacientes) {
                        if (p.getDNI() == DNI) {
                            p.verHistorialDeEventos();
                        }
                    }
                    break;
                case 5://Nuevo historial para un paciente..
                    System.out.print("Ingrese el DNI del paciente: ");
                    DNI=sc.nextInt();
                    sc.nextLine();
                    for (Pacientes p : pacientes) {
                        if (p.getDNI() == DNI) {

                            System.out.println("Ingrese los eventos medicos del paciente:");
                            System.out.print("Para terminar inserte 1\n→ ");
                            listo = false;
                            cont=1;
                            List<String> historial3 = new ArrayList <>();
                            do{
                                System.out.println("Evento "+cont+" :");
                                evento=sc.nextLine();
                                if(evento.equals("1")){
                                    listo=true;
                                }else{
                                    historial3.add(evento);
                                }
                                cont++;
                            }while(!listo);
                            p.setHistorialMedico(historial3);
                            System.out.println("- Información del paciente actualizada. -");
                            break;
                        }
                    }
                    break;
                case 6://Guardar Historial de pacientes en archivo
                    String archivoGuardado = "hospital.txt";

                    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivoGuardado))) {
                        outputStream.writeObject(pacientes);
                        System.out.println("- Datos guardados con éxito.-");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7://Cargar Historial de pacientes desde archivo
                    String archivoCarga = "hospital.txt";

                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivoCarga))) {
                        ArrayList<Pacientes> hospital = (ArrayList<Pacientes>) inputStream.readObject();
                        pacientes = hospital;
                        System.out.println("Datos cargados con éxito.");
                    } catch (EOFException e) {
                        System.err.println("El archivo está vacío o dañado.");
                    } catch (FileNotFoundException e) {
                        System.err.println("El archivo de carga no se encuentra.");
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8://Salir
                    exit = true;
                    break;
            }
        } while (!exit);
    }
}

abstract class Persona implements Serializable{
    private String nombre;
    private int DNI;
    private String FechaN;

    public Persona(String nombre, int DNI, String fechaN) {
        this.nombre = nombre;
        this.DNI = DNI;
        FechaN = fechaN;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setFechaN(String fechaN) {
        FechaN = fechaN;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public String getFechaN() {
        return FechaN;
    }
}

class Doctores extends Persona implements Serializable{
    private String Especialidad;

    public Doctores(String nombre, int DNI, String fechaN, String especialidad) {
        super(nombre, DNI, fechaN);
        Especialidad = especialidad;
    }

    public String Listar(){
        return "Doctor: "+super.getNombre()+", DNI: "+super.getDNI()+", Fecha de Nacimiento: "+super.getFechaN()+", Especialidad: "+this.Especialidad;
    }

}
class Pacientes extends Persona implements Informacion {
    private int NroTelef;
    private int TipoSangre;
    private List<String> historialMedico;

    public Pacientes(String nombre, int DNI, String fechaN, int nroTelef, int tipoSangre, List <String> historialMedico) {
        super(nombre, DNI, fechaN);
        NroTelef = nroTelef;
        TipoSangre = tipoSangre;
        this.historialMedico = historialMedico;
    }

    @Override
    public void verHistorialDeEventos() {
        System.out.println("Historial Médico del Pacientes " + super.getNombre() + ":");
        for (String evento : historialMedico) {
            System.out.println(evento);
        }
    }

    public void agregarEventoMedico(String evento) {
        historialMedico.add(evento);
    }

    public int getNroTelef() {
        return NroTelef;
    }

    public void setNroTelef(int nroTelef) {
        NroTelef = nroTelef;
    }

    public int getTipoSangre() {
        return TipoSangre;
    }

    public void setTipoSangre(int tipoSangre) {
        TipoSangre = tipoSangre;
    }

    public List <String> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(List <String> historialMedico) {
        this.historialMedico = historialMedico;
    }
}

