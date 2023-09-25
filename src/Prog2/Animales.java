package Prog2;

import java.util.ArrayList;
import java.util.Scanner;

interface AnimalInterface{
    String movimiento();
}

class Persona {
    private String nombreApellido;
    private String mail;
    private int telefono;

    public Persona(String nombreApellido, String mail, int telefono) {
        this.nombreApellido = nombreApellido;
        this.mail = mail;
        this.telefono = telefono;
    }
    public String getNombreApellido() {
        return nombreApellido;
    }
    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
public abstract class Animales implements AnimalInterface{
    private String nombre;
    private int edad;
    private char sexo;
    private Persona dueño;

    public Animales(Persona dueño, String nombre, int edad, char sexo) {
        this.dueño = dueño;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    public String mostrarInformacion(String nombre, int edad, char sexo){
        return "Dueño: -ninguno- ,Nombre: "+nombre+", Edad: "+edad+", Sexo: "+sexo;
    }
    public String mostrarInformacion(Persona dueño,String nombre, int edad, char sexo){
        return "Dueño: "+dueño.getNombreApellido()+", Nombre: "+nombre+", Edad: "+edad+", Sexo: "+sexo;
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
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public Persona getDueño() {
        return dueño;
    }
    public void setDueño(Persona dueño) {
        this.dueño = dueño;
    }
}

class perro extends Animales{
    public perro(Persona dueño, String nombre, int edad, char sexo) {
        super(dueño, nombre, edad, sexo);
    }
    @Override
    public void emitirSonido() {
        System.out.println("¡Guau!");
    }
    @Override
    public String movimiento() {
        return "Camina por 4 patas";
    }
    public String mostrarInformacion(String nombre, int edad, char sexo){
        return "Dueño: -ninguno-, Animal: perro, Nombre: "+nombre+", Edad: "+edad+", Sexo: "+sexo;
    }
    public String mostrarInformacion(Persona dueño,String nombre, int edad, char sexo){
        return "Dueño: "+dueño.getNombreApellido()+", Animal: perro, Nombre: "+nombre+", Edad: "+edad+", Sexo: "+sexo;
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
    public char getSexo() {
        return super.getSexo();
    }
    @Override
    public void setSexo(char sexo) {
        super.setSexo(sexo);
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
    public gato(Persona dueño, String nombre, int edad, char sexo) {
        super(dueño, nombre, edad, sexo);
    }
    @Override
    public void emitirSonido() {
        System.out.println("¡Miau!");
    }
    @Override
    public String movimiento() {
        return "Camina por 4 patas";
    }
    public String mostrarInformacion(String nombre, int edad, char sexo){
        return "Dueño: -ninguno-, Animal: gato, Nombre: "+nombre+", Edad: "+edad+", Sexo: "+sexo;
    }
    public String mostrarInformacion(Persona dueño,String nombre, int edad, char sexo){
        return "Dueño: "+dueño.getNombreApellido()+", Animal: gato, Nombre: "+nombre+", Edad: "+edad+", Sexo: "+sexo;
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
    public char getSexo() {
        return super.getSexo();
    }
    @Override
    public void setSexo(char sexo) {
        super.setSexo(sexo);
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
    public delfin(Persona dueño, String nombre, int edad, char sexo) {
        super(dueño, nombre, edad, sexo);
    }
    @Override
    public void emitirSonido() {
        System.out.println("¡iiiiiiiiiiiiiiii!");
    }
    @Override
    public String movimiento() {
        return "Nada con aletas y cola";
    }
    public String mostrarInformacion(String nombre, int edad, char sexo){
        return "Dueño: -ninguno-, Animal: delfin, Nombre: "+nombre+", Edad: "+edad+", Sexo: "+sexo;
    }
    public String mostrarInformacion(Persona dueño,String nombre, int edad, char sexo){
        return "Dueño: "+dueño.getNombreApellido()+", Animal: delfin, Nombre: "+nombre+", Edad: "+edad+", Sexo: "+sexo;
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
    public char getSexo() {
        return super.getSexo();
    }
    @Override
    public void setSexo(char sexo) {
        super.setSexo(sexo);
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
    public aguila(Persona dueño, String nombre, int edad, char sexo) {
        super(dueño, nombre, edad, sexo);
    }
    @Override
    public void emitirSonido() {
        System.out.println("¡Kraaaaaa!");
    }
    @Override
    public String movimiento() {
        return "Camina por 2 patas y vuela con sus alas";
    }
    public String mostrarInformacion(String nombre, int edad, char sexo){
        return "Dueño: -ninguno-, Animal: aguila, Nombre: "+nombre+", Edad: "+edad+", Sexo: "+sexo;
    }
    public String mostrarInformacion(Persona dueño,String nombre, int edad, char sexo){
        return "Dueño: "+dueño.getNombreApellido()+", Animal: aguila, Nombre: "+nombre+", Edad: "+edad+", Sexo: "+sexo;
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
    public char getSexo() {
        return super.getSexo();
    }
    @Override
    public void setSexo(char sexo) {
        super.setSexo(sexo);
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
        ArrayList<Animales> gestor = new ArrayList<>();

        System.out.println("""
                -----------------------
                Que desea hacer?: 
                [1]: Ingresar animal
                [2]: Modificar animal
                [3]: Ver animales
                [4]: Salir""");
        switch (sc.nextInt()){
            case 1 -> {
                System.out.println("""
                        Que animal es?
                        [1]: Perro
                        [2]: Gato
                        [3]: Delfin
                        [4]: Aguila""");
                switch (sc.nextInt()){
                    case 1 -> {
                    }
                }
            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            default -> {

            }
        }
    }
} // Mucho bardo