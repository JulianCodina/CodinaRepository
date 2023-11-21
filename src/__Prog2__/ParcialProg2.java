import java.util.*;

class Grafo {
    int[][] matrizPesos;
    String[] vertices;

    public Grafo(String[] vertices) {
        this.vertices = vertices;
        matrizPesos = new int[vertices.length][vertices.length];
    }
    public void conectar(String v1, String v2, int peso) {

        int index1 = busquedaIndex(v1);
        int index2 = busquedaIndex(v2);

        if (index1 != -1 && index2 != -1) {
            matrizPesos[index1][index2] = peso;
            matrizPesos[index2][index1] = peso;
        }
    }
    public void eliminarConexion(String v1, String v2) {
        int index1 = busquedaIndex(v1);
        int index2 = busquedaIndex(v2);

        if (index1 != -1 && index2 != -1) {
            matrizPesos[index1][index2] = 0;
            matrizPesos[index2][index1] = 0;
        }
    }
    public void imprimir() {
        for (int i = 0; i < matrizPesos.length; i++) {
            for (int j = 0; j < matrizPesos.length; j++) {
                System.out.print(matrizPesos[i][j] + " ");
            }
            System.out.println();
        }
    }
    private int busquedaIndex(String v) {
        int resultado = -1;

        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(v)) {
                resultado = i;
                break;
            }
        }
        return resultado;
    }
    public List<String> nodosAdyacentes(String v) {
        List<String> adyacentes = new ArrayList<>();
        int index = busquedaIndex(v);

        if (index != -1) {
            for (int i = 0; i < vertices.length; i++) {
                if (matrizPesos[index][i] != 0) {
                    adyacentes.add(vertices[i]);
                }
            }
        }
        return adyacentes;
    }
    public void eliminarNodosAdyacentes(String v){
        int index = busquedaIndex(v);

        if (index != -1) {
            for (int i = 0; i < vertices.length; i++) {
                if (matrizPesos[index][i] != 0) {
                    matrizPesos[index][i] = 0;
                }
            }
        }
    }
}

public class ParcialProg2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Grafo grafo = new Grafo(new String[]{"A","B","C","D","E","F","G"});

        grafo.conectar("A","B",7);
        grafo.conectar("A","D",5);
        grafo.conectar("B","C",8);
        grafo.conectar("B","E",7);
        grafo.conectar("B","D",9);
        grafo.conectar("C","E",5);
        grafo.conectar("D","E",15);
        grafo.conectar("D","F",6);
        grafo.conectar("E","F",8);
        grafo.conectar("E","G",9);
        grafo.conectar("F","G",11);

        grafo.imprimir();

        System.out.print("conectar: ");
        grafo.conectar(sc.next(),sc.next(),sc.nextInt());

        grafo.imprimir();

        System.out.print("desconectar: ");
        grafo.eliminarConexion(sc.next(),sc.next());

        grafo.imprimir();

        System.out.print("eliminar adyacentes: ");
        grafo.eliminarNodosAdyacentes(sc.next());

        grafo.imprimir();
    }
}
