package EmpleadoSerializado;

import java.io.*;
import java.util.Scanner;

class ExceptionRange extends Exception {
    public ExceptionRange(String mensaje) {
        super("ERROR:" + mensaje);
    }

}
public class Main {
    public static int verifyRange() throws ExceptionRange {
        Scanner input = new Scanner(System.in);
        int valor = input.nextInt();
        if (valor < 1 || valor > 3) {
            throw new ExceptionRange("Opción fuera de rango.");
        } else {
            return valor;
        }
    }

    public static void main(String[] args) {

        String archivo = "gestor_empleados.txt";
        File file = new File(archivo);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream(archivo));
            GestorEmpleados gestorLeido = (GestorEmpleados) leerFichero.readObject();
            leerFichero.close();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo '" + archivo + "' no existe. Debe crearlo primero.");
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        Scanner input = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();
        int again;
        do {
            System.out.println("""
                    Qué desea hacer?
                    [1]: Añadir un empleado
                    [2]: Eliminar un empleado
                    [3]: Modificar o ver empleado""");

            try {
                int opcion = verifyRange();
                switch (opcion) {
                    case 1 -> gestor.add();
                    case 2 -> gestor.remove();
                    case 3 -> gestor.modify();
                }
            } catch (ExceptionRange e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Si desea realizar otro cambio ingrese 1: ");
            again = input.nextInt();

        } while (again == 1);

        try {
            ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream(file));
            escribirFichero.writeObject(gestor);
            escribirFichero.close();
        } catch (IOException e) {
            System.out.println("Error al escribir o crear el archivo: " + e.getMessage());
        }
    }
}
