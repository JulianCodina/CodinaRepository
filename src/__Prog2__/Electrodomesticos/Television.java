package __Prog2__.Electrodomesticos;

public class Television extends Electrodoméstico {
    protected double resolucion;
    protected boolean sintonizador;

    protected final double RESOLUCION_DEF = 20;
    protected final boolean SINTONIZADOR_DEF = false;

    public Television() {
        super();
        this.resolucion = RESOLUCION_DEF;
        this.sintonizador = SINTONIZADOR_DEF;
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        this.resolucion = RESOLUCION_DEF;
        this.sintonizador = SINTONIZADOR_DEF;
    }

    public Television(double precioBase, String color, char consumoEnerg, double peso, double resolucion, boolean sintonizador) {
        super(precioBase, color, consumoEnerg, peso);
        this.resolucion = resolucion;
        this.sintonizador = sintonizador;
    }

    //METODOS
    protected double precioFinal(){
       super.precioFinal();
        if (this.resolucion > 40) this.precioBase += this.precioBase*0.3;
        if (this.sintonizador == true) this.precioBase += 50;
        return this.precioBase;
    }

    //GETTERS
    public double getResolucion() {
        return resolucion;
    }

    public boolean isSintonizador() {
        return sintonizador;
    }
}
