package recursividad;

import java.util.Scanner;
public class factorial{
public static void main(String[]args){
    Scanner input=new Scanner(System.in);
    System.out.print("Inserte un numero para sacar factorial: ");
    int n=input.nextInt();
    System.out.println("El resultado de manera recursiva es: "+FactRecursivo.factorial(n));
    System.out.println("El resultado de manera iterativa es: "+FactIterativo.factorial(n));
    }
}

