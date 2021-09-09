package tienda.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tienda.Entidades.Producto;

public class ProductoDAO extends DAO {

    private final Scanner read = new Scanner(System.in).useDelimiter("\n");

    public List<Producto> listAll() throws Exception {
        List<Producto> lista = new ArrayList<>();
        try {
            consultar("select * from producto");
            //va a llenar el resultset
            Producto producto = null;
            while (resultSet.next()) {
                producto = new Producto();
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCodigo_fabricante(resultSet.getInt("codigo_fabricante"));
                lista.add(producto);
            }
        } catch (SQLException ex) {
            throw new Exception("ocurrio un error", ex);
        }
        return lista;
    }

    public List<Producto> listPrecioNombre() throws Exception {

        List<Producto> lista = new ArrayList<>();
        try {
            consultar("select nombre, precio from producto");
            Producto producto = null;
            while (resultSet.next()) {
                producto = new Producto();
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                lista.add(producto);
            }
        } catch (SQLException ex) {
            throw new Exception("ocurrio un error", ex);
        }
        return lista;
    }

//    Listar aquellos productos que su precio esté entre 120 y 202. 
    public List<Producto> listPrecioEntre120y202() throws Exception {
        List<Producto> lista = new ArrayList<>();
        try {
            consultar("select * from producto where precio > 120 and precio < 202");
            Producto producto = null;

            while (resultSet.next()) {
                producto = new Producto();
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCodigo_fabricante(resultSet.getInt("codigo_fabricante"));
                lista.add(producto);
            }
        } catch (SQLException ex) {
            throw new Exception("ocurrio un error", ex);
        }
        return lista;
    }

//    Buscar y listar todos los Portátiles de la tabla producto. 
    public List<Producto> listPortatiles() throws Exception {

        List<Producto> lista = new ArrayList<>();
        try {
            consultar("select * from producto where nombre like '%portátil%'");
            Producto producto = null;
            while (resultSet.next()) {
                producto = new Producto();
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCodigo_fabricante(resultSet.getInt("codigo_fabricante"));
                lista.add(producto);
            }
        } catch (SQLException ex) {
            throw new Exception("ocurrio un error", ex);
        }
        return lista;
    }

    public Producto productoMasBarato() throws Exception {
        try {
            consultar("SELECT * FROM producto ORDER BY precio ASC LIMIT 1");
            Producto producto = null;
            while (resultSet.next()) {
                producto = new Producto();
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCodigo_fabricante(resultSet.getInt("codigo_fabricante"));
            }
            return producto;
        } catch (SQLException ex) {
            throw new Exception("ocurrio un error", ex);
        }
    }

    public Producto productoMasCaro() throws Exception {
        try {
            consultar("SELECT * FROM producto ORDER BY precio DESC LIMIT 1");
            Producto producto = null;
            while (resultSet.next()) {
                producto = new Producto();
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCodigo_fabricante(resultSet.getInt("codigo_fabricante"));
            }
            return producto;
        } catch (SQLException ex) {
            throw new Exception("ocurrio un error", ex);
        }
    }

    public void agregarProducto() throws Exception {

        System.out.println("Ingrese el codigo del producto");
        int codigo = read.nextInt();

        System.out.println("Nombre del producto:");
        String nombre = read.next();

        System.out.println("Precio: ");
        Double precio = read.nextDouble();

        System.out.println("Codigo del fabricante: ");
        int codigo_fabricante = read.nextInt();

        Conectarse();
        try {
            insertarModificarEliminar("insert into producto values(" + codigo + ",'" + nombre + "'," + precio + "," + codigo_fabricante + ")");
        } catch (Exception ex) {
            System.out.println("Ocurrio un error al insertar el producto");
        }
    }

    public void agregarFabricante() throws Exception {

        System.out.println("Ingrese el codigo del fabricante");
        int codigo = read.nextInt();

        System.out.println("Nombre del fabricante:");
        String nombre = read.next();

        Conectarse();
        try {
            insertarModificarEliminar("insert into fabricante values(" + codigo + ",'" + nombre + "')");
        } catch (Exception ex) {
            System.out.println("Ocurrio un error al insertar el producto");
        }
    }
}
