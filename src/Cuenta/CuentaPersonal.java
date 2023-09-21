package Cuenta;

public class CuentaPersonal extends Cuenta{
    private String nombre;
    private String apellido;

    public CuentaPersonal(int numeroCuenta, double saldo, String nombre, String apellido) {
        super(numeroCuenta, saldo);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    void depositar(int cant) {
        this.saldo += cant;
    }

    @Override
    void retirar(int cant) {
        this.saldo -= cant;
    }

    @Override
    String mostrar(int cant) {
        return "ID cuenta: "+numeroCuenta+
                ", Propietaro: "+
                nombre+" "+apellido+
                ", saldo: $"+saldo;
    }

    @Override
    public String toString() {
        return "Cuenta Personal: " +
                "ID cuenta= " + numeroCuenta +
                ", nombre y apellido= " +
                nombre + ' ' + apellido +
                ", saldo= " + saldo;
    }
}
