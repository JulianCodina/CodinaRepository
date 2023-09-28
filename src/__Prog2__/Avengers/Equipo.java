package __Prog2__.Avengers;
import java.util.ArrayList;
import java.util.List;

interface Acciones{
    String atacar();
    String atacar(String enemigo);
    String mover(String haciaDonde);
}
class Persona {
    private String Nombre;

    public Persona(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
class Heroe extends Persona implements Acciones{
    private String Poder;
    private String Origen;

    public Heroe(String nombre, String poder, String origen) {
        super(nombre);
        Poder = poder;
        Origen = origen;
    }

    public String atacar(){
        return super.getNombre()+" ataca con su "+this.Poder+ " a los enemigos";
    }
    public String atacar(String enemigo){
        return this.getNombre()+" ataca con su "+this.Poder+" a "+enemigo;
    }
    public String mover(String haciaDonde){
        return this.getNombre()+" se mueve hacia "+haciaDonde;
    }

    public String getPoder() {
        return Poder;
    }

    public void setPoder(String poder) {
        Poder = poder;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String origen) {
        Origen = origen;
    }
}
class Jett implements Acciones{
    private String Clase;
    private String Arma;

    public Jett(String clase) {
        Clase = clase;
        Arma = null;
    }

    public Jett(String clase, String armas) {
        Clase = clase;
        Arma = armas;
    }
    public String atacar(){
        return "El "+this.Clase+" dispara con su "+this.Arma+ " a los enemigos";
    }
    public String atacar(String enemigo){
        return "El "+this.Clase+" dispara con su "+this.Arma+" a "+enemigo;
    }
    public String mover(String haciaDonde){
        return "El "+this.Clase+" vuela hacia "+haciaDonde;
    }

    public String getClase() {
        return Clase;
    }

    public void setClase(String clase) {
        Clase = clase;
    }

    public String getArma() {
        return Arma;
    }

    public void setArma(String arma) {
        Arma = arma;
    }
}
public class Equipo{

    private Jett nave;
    List<Heroe> equipo = new ArrayList<>();

    public void modificarNave(String clase, String arma){
        nave.setClase(clase);
        nave.setArma(arma);
    }
    public void AvengerAssemble(){
        for(Heroe a : equipo){
            System.out.println(a.atacar());
        }
        nave.atacar();
    }
    public void AvengerAssemble(String enemigo){
        for(Heroe a : equipo){
            System.out.println(a.atacar(enemigo));
        }
        nave.atacar(enemigo);
    }
    public void Origenes(){
        for(Heroe a : equipo){
            System.out.println("El origen de "+a.getNombre()+" es "+ a.getOrigen());
        }
    }

}
