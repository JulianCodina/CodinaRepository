package Cuenta;

public abstract class Cuenta {
    protected int numeroCuenta;
    protected double saldo;

    public Cuenta(int numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    abstract void depositar(int cant);
    abstract void retirar(int cant);
    abstract String mostrar(int cant);

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
