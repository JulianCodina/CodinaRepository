package __Prog2__.Grafos;
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
    public int encontrarCaminoMinimo(String inicio, String fin) {
        int inicioIndex = busquedaIndex(inicio);
        int finIndex = busquedaIndex(fin);

        if (inicioIndex == -1 || finIndex == -1) {
            System.out.println("Nodos no válidos");
            return -1;
        }

        int[] distancias = new int[vertices.length];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[inicioIndex] = 0;

        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>();
        colaPrioridad.add(new Nodo(inicioIndex, 0));

        while (!colaPrioridad.isEmpty()) {
            Nodo nodoActual = colaPrioridad.poll();
            int actualIndex = nodoActual.indice;

            for (int vecinoIndex = 0; vecinoIndex < vertices.length; vecinoIndex++) {
                int peso = matrizPesos[actualIndex][vecinoIndex];
                if (peso > 0 && distancias[actualIndex] + peso < distancias[vecinoIndex]) {
                    distancias[vecinoIndex] = distancias[actualIndex] + peso;
                    colaPrioridad.add(new Nodo(vecinoIndex, distancias[vecinoIndex]));
                }
            }
        }

        if (distancias[finIndex] == Integer.MAX_VALUE) {
            System.out.println("No hay camino entre " + inicio + " y " + fin);
            return -1;
        }

        System.out.println("Camino más corto de " + inicio + " a " + fin + ":");
        imprimirCaminoMinimo(inicioIndex, finIndex);
        System.out.println("\nDistancia total recorrida: " + distancias[finIndex]);
        return distancias[finIndex];
    }

    private void imprimirCaminoMinimo(int inicio, int fin) {
        imprimirCaminoMinimo(inicio, fin, new boolean[vertices.length]);
    }

    private void imprimirCaminoMinimo(int actual, int fin, boolean[] visitado) {
        System.out.print(vertices[actual]);

        if (actual == fin) {
            return; // Llegamos al nodo de destino, terminamos la recursión
        }

        System.out.print(" -> ");
        visitado[actual] = true;

        for (int i = 0; i < vertices.length; i++) {
            if (matrizPesos[actual][i] > 0 && !visitado[i]) {
                imprimirCaminoMinimo(i, fin, visitado);
                break; // Detenemos la recursión después de imprimir el primer nodo del camino
            }
        }
    }
    private static class Nodo implements Comparable<Nodo> {
        int indice;
        int distancia;

        Nodo(int indice, int distancia) {
            this.indice = indice;
            this.distancia = distancia;
        }
        @Override
        public int compareTo(Nodo otro) {
            return Integer.compare(this.distancia, otro.distancia);
        }
    }
}

public class main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo(new String[]{"A","B","C","D","E"});

        grafo.conectar("A","B",2);
        grafo.conectar("B","C",4);
        grafo.conectar("C","E",3);
        grafo.conectar("B","D",1);
        grafo.conectar("D","E",2);

        grafo.imprimir();

        grafo.encontrarCaminoMinimo("A", "E");
    }
}
