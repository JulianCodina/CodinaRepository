package recursividad;

import java.util.Scanner;

public class divisionRestas {

    public static int recursivo(int ndo, int sor){
        if(ndo<sor)return 0;

        return 1 + recursivo(ndo-sor, sor);
    }
    public static int iterativo(int ndo, int sor){

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingresar el dividendo: ");
        int dvdendo = input.nextInt();
        System.out.print("Ingresar el divisor: ");
        int dvsor = input.nextInt();
        System.out.print("\nEl resultado con recursividad es: " + recursivo(dvdendo, dvsor));
        System.out.print("\nEl resultado con iteración es: " + iterativo(dvdendo, dvsor));
    }
}
