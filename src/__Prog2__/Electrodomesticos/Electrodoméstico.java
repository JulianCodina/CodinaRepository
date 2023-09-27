package __Prog2__.Electrodomesticos;

public class Electrodoméstico {
    protected double precioBase;
    protected String color;
    protected char consumoEnerg;
    protected double peso;

    protected final char CONSUMO_DEF = 'F';
    protected final String COLOR_DEF = "blanco";
    protected final double PRECIO_DEF = 100;
    protected final double PESO_DEF = 5;

    //CONSTRUCTORES
    public Electrodoméstico() {
        this.consumoEnerg = CONSUMO_DEF;
        this.color = COLOR_DEF;
        this.precioBase = PRECIO_DEF;
        this.peso = PESO_DEF;
    }

    public Electrodoméstico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = COLOR_DEF;
        this.consumoEnerg = CONSUMO_DEF;
    }

    public Electrodoméstico(double precioBase, String color, char consumoEnerg, double peso) {
        this.precioBase = precioBase;
        this.color = color;
        this.consumoEnerg = consumoEnerg;
        this.peso = peso;
    }

    //METODOS
    protected char comprobarConsumoEnergetico(char letra){
        if(letra>='A' && letra <= 'F'){
            this.consumoEnerg = letra;
        }else{
            this.consumoEnerg = CONSUMO_DEF;
        }
        return this.consumoEnerg;
    }
    protected String comprobarColor(String color){
        String[] colores = {"blanco", "negro","rojo","azul","gris","BLANCO","NEGRO","ROJO","AZUL","GRIS"};
        for(int i=0;i<=9;i++){
            if(colores[i]==color){
                this.color = color;
                break;
            }else{
                this.color = COLOR_DEF;
            }
        }
        return this.color;
    }
    protected double precioFinal(){
        char[] consumo = {'A','B','C','D','E','F'};
        int[] precios = {100,90,60,50,30,10};
        for(int i=0; i<=5;i++){
            if(this.consumoEnerg == consumo[i]){
                this.precioBase+=precios[i];
            }
        }
        int[] tamaño = {19,49,79};
        int[] precioArray = {10,50,80};
        for(int i=0;i<=2;i++){
            if(this.peso <= tamaño[i]) {
                this.precioBase += precioArray[i];
                break;
            }else{
                this.precioBase += 100;
            }
        }
        return this.precioBase;
    }
    //GETTERS
    public double getPrecioBase() {
        return precioBase;
    }
    public String getColor() {
        return color;
    }
    public char getConsumoEnerg() {
        return consumoEnerg;
    }
    public double getPeso() {
        return peso;
    }
}
