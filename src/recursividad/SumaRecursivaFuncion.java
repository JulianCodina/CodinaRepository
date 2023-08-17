package recursividad;

public class SumaRecursivaFuncion {
    public static int Funcion(int n){
        if(n<1) return 0;
        return n + Funcion(n-1);
    }
}
