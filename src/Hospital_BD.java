import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Hospital_BD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:8081/hospital";
        String usuario = "usuario";
        String contraseña = "contraseña";
        try{
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conexion.createStatement();
            String consulta = "SELECT * FROM pacientes";
            ResultSet resultado = statement.executeQuery(consulta);

            while (resultado.next()){

            }

            resultado.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    class Hospital {
        private List <Doctor> doctors = new ArrayList <>();
        private List <Paciente> pacientes = new ArrayList <>();

        public Hospital() {
        }

        public void agregarPaciente(Paciente paciente) {
      /*Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los datos del paciente:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("edad: ");
        int edad = sc.nextInt();
        System.out.print("Historial Medico: ");
        String historialMedico = sc.nextLine();
        Hospital.agregarPaciente(new Paciente(id, nombre, edad, historialMedico));*/
            pacientes.add(paciente);
            System.out.println("-Paciente añadido exitosamente-");
        }

        public void mostrarListaPacientes() {
            for (Paciente p : pacientes) {
                System.out.println(p.ToString());
            }
        }

        public void asignarDoctorCabecera(String nombreDoctor, String nombrePaciente) {
            // Implementación para asignar doctor a paciente
        }
    }

    abstract class Persona {
        private int id;
        private String nombre;
        private int edad;

        public Persona() {
        }

        public Persona(int id, String nombre, int edad) {
            this.id = id;
            this.nombre = nombre;
            this.edad = edad;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }
    }

    class Paciente extends Persona {
        private String historialMedico;

        public Paciente() {
        }

        public Paciente(int id, String nombre, int edad, String historialMedico) {
            super(id, nombre, edad);
            this.historialMedico = historialMedico;
        }

        public String ToString() {
            return "ID: " + getId() + ", Nombre: " + getNombre() + ", Edad: " + getEdad() + "\nHistorial Medico: " + this.historialMedico;
        }

        public String getHistorialMedico() {
            return historialMedico;
        }

        public void setHistorialMedico(String historialMedico) {
            this.historialMedico = historialMedico;
        }
    }

    class Doctor extends Persona {
        private String especialidad;

        public Doctor() {
        }

        public Doctor(int id, String nombre, int edad, String especialidad) {
            super(id, nombre, edad);
            this.especialidad = especialidad;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }
    }
}