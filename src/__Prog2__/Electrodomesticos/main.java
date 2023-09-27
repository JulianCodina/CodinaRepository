package __Prog2__.Electrodomesticos;

public class main {
    public static void main(String[] args) {
        Electrodoméstico[] array = new Electrodoméstico[10];
        array[0] = new Lavarropas(1400,34);
        array[1] = new Lavarropas(2345,50);
        array[2] = new Lavarropas(6700,30);
        array[3] = new Lavarropas(2400,40);
        array[4] = new Lavarropas(1500,78);
        array[5] = new Television(7600,39);
        array[6] = new Television(3400,93);
        array[7] = new Television(3100,33);
        array[8] = new Television(2000,46);
        array[9] = new Television(2900,74);

        double totalTeles=0;
        double totalLavas=0;
        double Total=0;

        for (Electrodoméstico elemento : array) {
            System.out.println(elemento.precioFinal());
            Total += elemento.precioFinal();
            if(elemento instanceof Television){
                totalTeles += elemento.precioFinal();
            }else{
                totalLavas += elemento.precioFinal();
            }
        }

        System.out.println("\nTotal en Prog2.Electrodomesticos: "+Total+"\nTotal en Prog2.Electrodomesticos.Lavarropas: "+totalLavas+"\nTotal en Televisores: "+totalTeles);

    }
}
