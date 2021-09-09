package tienda.persistencia;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    protected Connection connection = null;
    protected Statement statement = null;
    protected ResultSet resultSet = null;

    private final String user = "root";
    private final String password = "root";
    private final String schema = "tienda";

    public void Conectarse() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" + schema + "?useSSL=false";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encontro el driver de MYSQL");
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la conexion a la base de datos" + schema);
        }
    }

    public void Desconectarse() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            System.out.println("Ocurrio un error al desconectarse de la base de datos");
        }
    }

    public void insertarModificarEliminar(String query) throws Exception {
        Conectarse();
        try {

            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            throw new Exception("Ocurrio un error al crear el statement", ex);
        } finally {
            Desconectarse();
        }
    }

    public void consultar(String query) throws Exception {
        try {
            Conectarse();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            throw new Exception("Ocurrio un error al realizar la consulta", ex);
        }
    }

}
