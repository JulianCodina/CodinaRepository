package __Prog2__;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface AnimalInterface{
    String movimiento();
}

class Persona {
    private String nombreApellido;

    public Persona(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
    public String getNombreApellido() {
        return nombreApellido;
    }
    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
}
public abstract class Animales implements AnimalInterface{
    private String nombre;
    private int edad;
    private Persona dueño;

    public Animales(Persona dueño, String nombre, int edad) {
        this.dueño = dueño;
        this.nombre = nombre;
        this.edad = edad;
    }
    public Animales(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String mostrarInformacion(String nombre, int edad){
        return null;
    }
    public String mostrarInformacion(Persona dueño,String nombre, int edad){
        return null;
    }
    void emitirSonido(){}

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Persona getDueño() {
        return dueño;
    }
    public void setDueño(Persona dueño) {
        this.dueño = dueño;
    }
}

class perro extends Animales{
    public perro(Persona dueño, String nombre, int edad) {
        super(dueño, nombre, edad);
    }
    public perro(String nombre, int edad) {
        super(nombre, edad);
    }
    @Override
    public void emitirSonido() {
        System.out.println("¡Guau!");
    }
    @Override
    public String movimiento() {
        return "Camina por 4 patas";
    }
    public String mostrarInformacion(String nombre, int edad){
        if (getDueño() != null) {
            return "Dueño: "+getDueño().getNombreApellido()+", Animal: perro, Nombre: "+nombre+", Edad: "+edad;
        } else {
            return "Dueño: -ninguno-, Animal: perro, Nombre: "+nombre+", Edad: "+edad;
        }
    }
    @Override
    public String getNombre() {
        return super.getNombre();
    }
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
    @Override
    public int getEdad() {
        return super.getEdad();
    }
    @Override
    public void setEdad(int edad) {
        super.setEdad(edad);
    }
    @Override
    public Persona getDueño() {
        return super.getDueño();
    }
    @Override
    public void setDueño(Persona dueño) {
        super.setDueño(dueño);
    }
}
class gato extends Animales{
    public gato(Persona dueño, String nombre, int edad) {
        super(dueño, nombre, edad);
    }
    public gato(String nombre, int edad) {
        super(nombre, edad);
    }
    @Override
    public void emitirSonido() {
        System.out.println("¡Miau!");
    }
    @Override
    public String movimiento() {
        return "Camina por 4 patas";
    }
    public String mostrarInformacion(String nombre, int edad){
        if (getDueño() != null) {
            return "Dueño: "+getDueño().getNombreApellido()+", Animal: gato, Nombre: "+nombre+", Edad: "+edad;
        } else {
            return "Dueño: -ninguno-, Animal: gato, Nombre: "+nombre+", Edad: "+edad;
        }
    }

    public String mostrarInformacion(Persona dueño, String nombre, int edad){
        return "Dueño: "+dueño.getNombreApellido()+", Animal: gato, Nombre: "+nombre+", Edad: "+edad;
    }
    @Override
    public String getNombre() {
        return super.getNombre();
    }
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
    @Override
    public int getEdad() {
        return super.getEdad();
    }
    @Override
    public void setEdad(int edad) {
        super.setEdad(edad);
    }
    @Override
    public Persona getDueño() {
        return super.getDueño();
    }
    @Override
    public void setDueño(Persona dueño) {
        super.setDueño(dueño);
    }
}
class delfin extends Animales{
    public delfin(Persona dueño, String nombre, int edad) {
        super(dueño, nombre, edad);
    }
    public delfin(String nombre, int edad) {
        super(nombre, edad);
    }
    @Override
    public void emitirSonido() {
        System.out.println("¡iiiiiiiiiiiiiiii!");
    }
    @Override
    public String movimiento() {
        return "Nada con aletas y cola";
    }
    public String mostrarInformacion(String nombre, int edad){
        if (getDueño() != null) {
            return "Dueño: "+getDueño().getNombreApellido()+", Animal: delfin, Nombre: "+nombre+", Edad: "+edad;
        } else {
            return "Dueño: -ninguno-, Animal: delfin, Nombre: "+nombre+", Edad: "+edad;
        }
    }

    public String mostrarInformacion(Persona dueño, String nombre, int edad){
        return "Dueño: "+dueño.getNombreApellido()+", Animal: delfin, Nombre: "+nombre+", Edad: "+edad;
    }
    @Override
    public String getNombre() {
        return super.getNombre();
    }
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
    @Override
    public int getEdad() {
        return super.getEdad();
    }
    @Override
    public void setEdad(int edad) {
        super.setEdad(edad);
    }
    @Override
    public Persona getDueño() {
        return super.getDueño();
    }
    @Override
    public void setDueño(Persona dueño) {
        super.setDueño(dueño);
    }
}
class aguila extends Animales{
    public aguila(Persona dueño, String nombre, int edad) {
        super(dueño, nombre, edad);
    }
    public aguila(String nombre, int edad) {
        super(nombre, edad);
    }
    @Override
    public void emitirSonido() {
        System.out.println("¡Kraaaaaa!");
    }
    @Override
    public String movimiento() {
        return "Camina por 2 patas y vuela con sus alas";
    }
    public String mostrarInformacion(String nombre, int edad){
        if (getDueño() != null) {
            return "Dueño: "+getDueño().getNombreApellido()+", Animal: aguila, Nombre: "+nombre+", Edad: "+edad;
        } else {
            return "Dueño: -ninguno-, Animal: aguila, Nombre: "+nombre+", Edad: "+edad;
        }
    }

    public String mostrarInformacion(Persona dueño, String nombre, int edad){
        return "Dueño: "+dueño.getNombreApellido()+", Animal: aguila, Nombre: "+nombre+", Edad: "+edad;
    }
    @Override
    public String getNombre() {
        return super.getNombre();
    }
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
    @Override
    public int getEdad() {
        return super.getEdad();
    }
    @Override
    public void setEdad(int edad) {
        super.setEdad(edad);
    }
    @Override
    public Persona getDueño() {
        return super.getDueño();
    }
    @Override
    public void setDueño(Persona dueño) {
        super.setDueño(dueño);
    }
}

class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Animales> zoo = new ArrayList<>();
        boolean sindueño = true;
        boolean exit = false;

        do {
            System.out.println("""
                    -----------------------
                    Que desea hacer?:
                    [1]: Ingresar animal
                    [2]: Ver animales
                    [3]: Ver animal especifico
                    [4]: Salir""");
            int opc = sc.nextInt();
            switch (opc) {
                case 1 -> {
                    System.out.println("""
                            Que animal es?
                            [1]: Perro
                            [2]: Gato
                            [3]: Delfin
                            [4]: Aguila""");
                    opc = sc.nextInt();
                    switch (opc) {
                        case 1 -> {
                            sc.nextLine();
                            System.out.println("Ingrese sus datos");
                            System.out.print("Nombre y apellido del dueño: ");
                            String dueño = sc.nextLine();
                            if (!dueño.isEmpty()) sindueño = false;
                            System.out.print("Nombre del perro: ");
                            String nombre = sc.nextLine();
                            System.out.print("Edad del perro: ");
                            int edad = sc.nextInt();

                            if (!sindueño) {
                                zoo.add(new perro(new Persona(dueño), nombre, edad));
                            } else {
                                zoo.add(new perro(nombre, edad));
                            }
                        }
                        case 2 -> {
                            sc.nextLine();
                            System.out.println("Ingrese sus datos");
                            System.out.print("Nombre y apellido del dueño: ");
                            String dueño = sc.nextLine();
                            if (!dueño.isEmpty()) sindueño = false;
                            System.out.print("Nombre del gato: ");
                            String nombre = sc.nextLine();
                            System.out.print("Edad del gato: ");
                            int edad = sc.nextInt();

                            if (!sindueño) {
                                zoo.add(new gato(new Persona(dueño), nombre, edad));
                            } else {
                                zoo.add(new gato(nombre, edad));
                            }
                        }
                        case 3 -> {
                            sc.nextLine();
                            System.out.println("Ingrese sus datos");
                            System.out.print("Nombre y apellido del dueño: ");
                            String dueño = sc.nextLine();
                            if (!dueño.isEmpty()) sindueño = false;
                            System.out.print("Nombre del delfin: ");
                            String nombre = sc.nextLine();
                            System.out.print("Edad del delfin: ");
                            int edad = sc.nextInt();

                            if (!sindueño) {
                                zoo.add(new delfin(new Persona(dueño), nombre, edad));
                            } else {
                                zoo.add(new delfin(nombre, edad));
                            }
                        }
                        case 4 -> {
                            sc.nextLine();
                            System.out.println("Ingrese sus datos");
                            System.out.print("Nombre y apellido del dueño: ");
                            String dueño = sc.nextLine();
                            if (!dueño.isEmpty()) sindueño = false;
                            System.out.print("Nombre del aguila: ");
                            String nombre = sc.nextLine();
                            System.out.print("Edad del aguila: ");
                            int edad = sc.nextInt();

                            if (!sindueño) {
                                zoo.add(new aguila(new Persona(dueño), nombre, edad));
                            } else {
                                zoo.add(new aguila(nombre, edad));
                            }
                        }
                    }
                }
                case 2 -> {
                    sc.nextLine();
                    for (Animales a : zoo) {
                        if (a.getDueño()==null) {
                            System.out.println(a.mostrarInformacion(a.getNombre(), a.getEdad()));
                        }
                        System.out.println(a.mostrarInformacion(a.getDueño(), a.getNombre(), a.getEdad()));

                    }
                }
                case 3 -> {
                    sc.nextLine();
                    System.out.print("Ingrese nombre del animal: ");
                    String nombre = sc.nextLine();
                    for (Animales a : zoo) {
                        if (a.getNombre().equals(nombre)) {
                            System.out.print("El animal dice: ");
                            a.emitirSonido();
                            System.out.println("El animal se mueve " + a.movimiento());
                            break;
                        }
                    }
                }
                case 4 -> exit = true;
            }
        }while(!exit);
    }
}