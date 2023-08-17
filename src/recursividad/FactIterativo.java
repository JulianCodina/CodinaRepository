package recursividad;

public class FactIterativo {
    public static int factorial(int n) {
        int result =1;
        if (n == 1 || n == 0) {
            return 1;
        }
        for(int i=n;i>=1;i--){
            result = result * i;
        }
        return result;
    }
}
