import java.sql.*;
import java.util.ArrayList;

public class SistemaDeVentas {
    public static void main(String[] args) {
        Comerciales.listadoDeVendedores();
        Productos.obtenerProductoMasVendido();
        Productos.generarInforme();

        System.out.println("Fin del programa");
    }
}
class DBHelper {
    private static final String URL = "jdbc:mysql://localhost:33061/sistemadeventas";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void ejecutarConsulta(String consulta) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                statement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ResultSet ejecutarConsultaConResultado(String consulta) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(consulta);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
class Producto{
    private int producto_id;
    private String nombre;
    private float precio_por_unidad;
    private int stock;

    public Producto(int producto_id, String nombre, float precio_por_unidad, int stock) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.precio_por_unidad = precio_por_unidad;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "producto_id=" + producto_id + ", nombre='" + nombre + '\'' + ", precio_por_unidad=" + precio_por_unidad + ", stock=" + stock + '}';
    }
}
class Productos{
    public static void generarInforme() {

        String consulta = "SELECT * FROM productos";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        try {
            float TOTAL=0;
            System.out.println("Informe de Productos en stock:");
            System.out.println("Producto            Stock   Precio  Total");
            System.out.println("------------------------------------------");
            while(resultado.next()){
                int stock = resultado.getInt("stock");
                float precio = resultado.getFloat("precio_por_unidad");
                String nombre = resultado.getString("nombre");
                float total = stock*precio;
                TOTAL+=total;
                System.out.println(nombre+"\t\t"+stock+"\t"+precio+"\t"+total);
            }
            System.out.println("------------------------------------------");
            System.out.println("\t\t\t\t\tTotal:\t\t\t"+TOTAL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Producto obtenerProducto(int productoID) {
        String consulta = "SELECT * FROM productos WHERE producto_id = '"+productoID+"'";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        if (resultado != null) {
            try {
                int producto_id = resultado.getInt("producto_id");
                String nombre = resultado.getString("nombre");
                float precio_por_unidad = resultado.getFloat("precio_por_unidad");
                int stock = resultado.getInt("stock");

                System.out.println("producto:"+producto_id+", nombre: "+nombre+",precio: "+precio_por_unidad+", stock:"+stock);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static Producto obtenerProductoMasVendido() {

        String consulta = "SELECT producto_id, SUM(cantidad_vendida) as total_vendido\n" + "FROM ventas\n" + "GROUP BY producto_id\n" + "ORDER BY total_vendido DESC\n" + "LIMIT 1";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        try {
            if (resultado.next()) {
                int producto_id = resultado.getInt("producto_id");
                return obtenerProducto(producto_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
class Vendedor{
    private int vendedor_id;
    private String nombre;
    private String apellido;
    private int dni;
    private Date fecha_nacimiento;
    private Date fecha_contratacion;

    public Vendedor(int vendedor_id, String nombre, String apellido, int dni, Date fecha_nacimiento, Date fecha_contratacion) {
        this.vendedor_id = vendedor_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_contratacion = fecha_contratacion;
    }

    public Vendedor(String consultaBusqueda) {
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consultaBusqueda);
        try {
            System.out.println("Datos del vendedor");

            int vendedor_id = resultado.getInt("vendedor_id");
            String nombre = resultado.getString("nombre");
            String apellido = resultado.getString("apellido");
            int dni = resultado.getInt("dni");
            Date fecha_nacimiento = resultado.getDate("fecha_nacimiento");
            Date fecha_contratacion = resultado.getDate("fecha_contratacion");

            System.out.printf("%-10d %-15s %-5d %-20s %-12s %-10d\n", vendedor_id, nombre,apellido, dni, fecha_nacimiento, fecha_contratacion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Vendedor{" + "vendedor_id=" + vendedor_id + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni=" + dni + ", fecha_nacimiento=" + fecha_nacimiento + ", fecha_contratacion=" + fecha_contratacion + '}';
    }
}
class Venta{
    private int venta_id;
    private int vendedor_id;
    private int producto_id;
    private int cantidad_vendida;
    private Date fecha_venta;

    public Venta(int venta_id, int vendedor_id, int producto_id, int cantidad_vendida, Date fecha_venta) {
        this.venta_id = venta_id;
        this.vendedor_id = vendedor_id;
        this.producto_id = producto_id;
        this.cantidad_vendida = cantidad_vendida;
        this.fecha_venta = fecha_venta;
    }
}
class Comerciales{
    public static Vendedor obtenerVendedorPorID(int vendedorID) {
        String consulta = "SELECT * FROM vendedores WHERE vendedor_id = '"+vendedorID+"'";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        if (resultado != null) {
            try {
                System.out.println("Datos del vendedor");

                int vendedor_id = resultado.getInt("vendedor_id");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                int dni = resultado.getInt("dni");
                Date fecha_nacimiento = resultado.getDate("fecha_nacimiento");
                Date fecha_contratacion = resultado.getDate("fecha_contratacion");

                System.out.printf("%-10d %-15s %-5d %-20s %-12s %-10d\n", vendedor_id, nombre,apellido, dni, fecha_nacimiento, fecha_contratacion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static ArrayList<Vendedor> listadoDeVendedores() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        String consulta = "SELECT * FROM vendedores";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);
        if (resultado != null) {
            try {
                while(resultado.next()) {
                    int vendedor_id = resultado.getInt("vendedor_id");
                    String nombre = resultado.getString("nombre");
                    String apellido = resultado.getString("apellido");
                    int dni = resultado.getInt("dni");
                    Date fecha_nacimiento = resultado.getDate("fecha_nacimiento");
                    Date fecha_contratacion = resultado.getDate("fecha_contratacion");

                    Vendedor vendedor = new Vendedor(vendedor_id, nombre, apellido, dni, fecha_nacimiento, fecha_contratacion);
                    vendedores.add(vendedor);
                    }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vendedores;
    }
}


