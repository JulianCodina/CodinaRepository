package recursividad;

import java.util.Scanner;

public class SumaRecursiva {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingresar un número: ");
        int n = input.nextInt();
        System.out.println("La sumatoria de todos los números desde el 1 hasta el "+n+" es de: "+ SumaRecursivaFuncion.Funcion(n));
    }
}
