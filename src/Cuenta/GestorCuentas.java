package Cuenta;

import java.util.ArrayList;
import java.util.List;

public class GestorCuentas {
    List<Cuenta> gestorP;
    List<Cuenta> gestorS;

    public GestorCuentas() {
        this.gestorP = new ArrayList<>();
        this.gestorS = new ArrayList<>();
    }

    public void agregarCuentaPersonal(Cuenta cuenta){
        gestorP.add(cuenta);
        System.out.println(" - Cuenta Personal agregada. - ");
    }
    public void agregarCuentaSociedad(Cuenta cuenta){
        gestorS.add(cuenta);
        System.out.println(" - Cuenta Sociedad agregada. - ");
    }
    public void eliminarCuentaPersonal(int id){
        for(Cuenta cuenta : gestorP) {
            if(cuenta.numeroCuenta==id) {
                gestorP.remove(cuenta);
                System.out.println(" - Cuenta Personal eliminada. - ");
            }
        }
    }
    public void eliminarCuentaSociedad(int id){
        for(Cuenta cuenta : gestorS) {
            if (cuenta.numeroCuenta == id) {
                gestorS.remove(cuenta);
                System.out.println(" - Cuenta Sociedad eliminada. - ");
            }
        }
    }
    public void editarCuentaPersona(int id, double saldo){
        for(Cuenta cuenta : gestorP) {
            if (cuenta.numeroCuenta == id) {
                cuenta.setSaldo(saldo);
                System.out.println(" - Cuenta Personal Modificada. - ");
            }
        }
    }
    public void editarCuentaSociedad(int id, double saldo){
        for(Cuenta cuenta : gestorS) {
            if (cuenta.numeroCuenta == id) {
                cuenta.setSaldo(saldo);
                System.out.println(" - Cuenta Personal Modificada. - ");
            }
        }
    }
    public void mostrarTodasLasCuentas(){
        for(Cuenta cuentas: gestorP) {
            System.out.println(cuentas.toString());
        }
        for(Cuenta cuentas: gestorS) {
            System.out.println(cuentas.toString());
        }
    }

}
