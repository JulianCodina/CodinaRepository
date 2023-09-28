public class Huespedes extends Persona{
    private String nacional;

    public Huespedes(String nombreApellido, String nacional) {
        super(nombreApellido);
        this.nacional = nacional;
    }

    @Override
    public String toString() {
        return "Huesped: "+super.getNombreApellido()+", nacional: " + nacional;
    }
}
