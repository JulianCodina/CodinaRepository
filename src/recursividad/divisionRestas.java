package recursividad;

import java.util.Scanner;

public class divisionRestas {

    public static int recursivo(int ndo, int sor){
        if(ndo<sor)return 0;                            //si el dividendo es menor al divisor el resultado es 0

        return 1 + recursivo(ndo-sor, sor);        //el resultado sera la suma de las repeticiones hasta que el dividendo sea menor al divisor
    }

    public static int iterativo(int ndo, int sor){
        int result=0;
        if(ndo<sor) return 0;                           //si el dividendo es menor al divisor el resultado es 0
        for(int i=1;ndo>=sor;i++){
            ndo-=sor;
            result=i;                                   //el resultado sera la suma de las repeticiones hasta que el dividendo sea menor al divisor
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingresar el dividendo: ");
        int dvdendo = input.nextInt();
        System.out.print("Ingresar el divisor: ");
        int dvsor = input.nextInt();
        System.out.print("\nEl resultado con recursividad es: " + recursivo(dvdendo, dvsor));
        System.out.println("\nEl resultado con iteración es: " + iterativo(dvdendo, dvsor));
    }
}
