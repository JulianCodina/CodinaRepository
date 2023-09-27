import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Bloc_Notas implements Serializable {
    ArrayList<String> texto = new ArrayList<>();

    public Bloc_Notas() {
    }

    public void Escribir (String nuevo_texto) {
        texto.add(nuevo_texto);
    }

    public void borrar (String elimina_texto){
        for (int i = 0; i < texto.size(); i++) {
            String linea = texto.get(i);
            String[] palabras = linea.split("\\s+"); // Dividir la línea en palabras

            for (int j = 0; j < palabras.length; j++) {
                if (elimina_texto.contains(palabras[j])) {
                    palabras[j] = ""; // Reemplazar la palabra con una cadena vacía
                }
            }

            // Reconstruir la línea sin las palabras específicas eliminadas
            linea = String.join(" ", palabras).trim();

            // Actualizar la línea en el ArrayList
            texto.set(i, linea);
        }
    }

    @Override
    public String toString() {
        return "Contenido de la lista de texto:\n" + String.join("\n", texto);
    }

    public void guardar(String nombreArchivo) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            objectOutputStream.writeObject(this);
            System.out.println("Bloc de notas guardado en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el Bloc de notas en el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }

    public void cargar(String nombreArchivo) {

        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            System.out.println("El archivo no existe en la ruta especificada. Se creará uno nuevo.");
            return;
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Bloc_Notas blocNotasCargado = (Bloc_Notas) objectInputStream.readObject();
            this.texto = blocNotasCargado.texto;
            System.out.println("Contenido del Bloc de notas cargado desde " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el Bloc de notas desde " + nombreArchivo + ": " + e.getMessage());
        }
    }

    public void mostrarRuta(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        System.out.println("Ruta: " + archivo.getAbsolutePath());
    }

    public void borrarContenido(String nombreArchivo) {
        this.texto.clear();
        guardar(nombreArchivo);
    }

}

class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Bloc_Notas bloc_notas = new Bloc_Notas();

        String archvo = "notas.txt";

        boolean salir = false;
        int opc;

        bloc_notas.cargar(archvo);

        while (!salir){

            System.out.println("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                EDITOR DE TEXTOS
                Elije una opción:
                1) Escribir
                2) Borrar
                3) Leer
                4) Mostrar directorio
                5) Borrar todo el contenido
                6) Salir
                """);
            opc = input.nextInt();

            switch (opc){

                case 1: // escribir
                    System.out.println("Escribir: ");
                    input.nextLine(); // Consumir el Enter pendiente
                    String texto_agregado = input.nextLine();

                    bloc_notas.Escribir(texto_agregado);
                    bloc_notas.guardar(archvo);

                    break;

                case 2: // borrar
                    System.out.println("Eliminar: ");
                    input.nextLine(); // Consumir el Enter pendiente
                    String texto_elimina = input.nextLine();

                    bloc_notas.borrar(texto_elimina);
                    bloc_notas.guardar(archvo);

                    break;

                case 3: // leer
                    System.out.println(bloc_notas);
                    break;

                case 4: // mostrar dir
                    bloc_notas.mostrarRuta(archvo);
                    break;

                case 5:
                    bloc_notas.borrarContenido(archvo);
                    break;

                case 6: // salir
                    salir = true;
                    bloc_notas.guardar(archvo);
                    break;
            }
        }
    }
}