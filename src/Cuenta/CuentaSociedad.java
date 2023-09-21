package Cuenta;

public class CuentaSociedad extends Cuenta{
    private String nombreEmpresa;
    private String tipo;

    public CuentaSociedad(int numeroCuenta, double saldo, String nombreEmpresa, String tipo) {
        super(numeroCuenta, saldo);
        this.nombreEmpresa = nombreEmpresa;
        this.tipo = tipo;
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
        return "ID cuenta: "+numeroCuenta+", empresa: "+nombreEmpresa+
                ", tipo: "+tipo+
                ", saldo: $"+saldo;
    }
    @Override
    public String toString() {
        return "Cuenta Sociedad: " +
                "ID cuenta= " + numeroCuenta +
                ", nombre de Empresa= " +
                nombreEmpresa +
                ", saldo= " + saldo;
    }
}
