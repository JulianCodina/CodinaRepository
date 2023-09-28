public abstract class Persona {
    private String nombreApellido;

    public Persona(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombreApellido='" + nombreApellido + '\'' + '}';
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
}
