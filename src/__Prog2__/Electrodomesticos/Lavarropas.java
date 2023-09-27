package __Prog2__.Electrodomesticos;

public class Lavarropas extends Electrodoméstico {
    protected double carga;
    protected final double CARGA_DEF = 5;

    public Lavarropas() {
        super();
        this.carga = CARGA_DEF;
    }

    public Lavarropas(double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = CARGA_DEF;
    }

    public Lavarropas(double precioBase, String color, char consumoEnerg, double peso, double carga) {
        super(precioBase, color, consumoEnerg, peso);
        this.carga = carga;
    }

    //METODOS

    protected double precioFinal() {
       super.precioFinal();
        if (this.carga > 30) this.precioBase += 50;
        return this.precioBase;
    }
    //getters
    public double getCarga() {
        return carga;
    }
}
