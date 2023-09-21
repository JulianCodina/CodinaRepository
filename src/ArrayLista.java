import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLista {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> miLista = new ArrayList<>();
        miLista.add(2);
        miLista.add(5);
        miLista.add(6);
        miLista.add(8);
        miLista.add(9);

        System.out.print("agregar numero: ");
        miLista.add(sc.nextInt());
        System.out.print("buscar numero en indice: ");
        try {
            System.out.println(miLista.get(sc.nextInt()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("remover numero en indice: ");
        try {
            miLista.remove(sc.nextInt());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(miLista);
    }
}
