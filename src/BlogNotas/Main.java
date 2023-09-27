package BlogNotas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        String nombre= "";
        String contenido= "";

        do {
            System.out.print("""
                    Inicio:
                    [1]: Nuevo
                    [2]: Abrir
                    [3]: Eliminar
                    [4]: Seguir escribiendo
                    [5]: Salir
                    ->\s""");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> {
                    nombre = Funciones.crear();
                    contenido = "";
                    Funciones.abrir(nombre);
                    Funciones.escribir(nombre, contenido);
                }
                case 2 -> {
                    Funciones.listarArchivos();
                    nombre = sc.nextLine();
                    contenido = Funciones.abrir(nombre);
                    Funciones.escribir(nombre, contenido);
                }
                case 3 -> {
                    Funciones.listarArchivos();
                    System.out.print("Nombre del archivo a eliminar: ");
                    String eliminar = sc.nextLine();
                    Funciones.eliminar(eliminar);
                }
                case 4 -> Funciones.escribir(nombre, contenido);
                case 5 -> salir = true;
                default -> System.out.println("- Opcion invalida -");
            }
        } while (!salir);
    }
}
