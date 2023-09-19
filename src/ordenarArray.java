/*Deberás crear un proyecto en Java que resuelva el siguiente problema:
Dado un conjunto de tres números ingresados por el usuario a través de la consola,
el programa debe ordenarlos de mayor a menor y mostrar el resultado por pantalla.*/

import java.util.Scanner;
import java.util.Arrays;
public class ordenarArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese 3 numeros: ↓");

        System.out.print("[1]: ");
        int num1 = scanner.nextInt();

        System.out.print("[2]: ");
        int num2 = scanner.nextInt();

        System.out.print("[3]: ");
        int num3 = scanner.nextInt();

        int[] numeros = {num1, num2, num3};
        Arrays.sort(numeros);

        System.out.println("Números ordenados de mayor a menor:");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
    }
}
