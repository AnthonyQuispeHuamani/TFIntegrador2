
package Recurso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Datos para la conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/sistema";
    private static final String USER = "root"; // Cambia 'root' por tu usuario de MySQL si es diferente
    private static final String PASSWORD = ""; // Si tienes contraseña, inclúyela aquí

    // Método para obtener la conexión
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida exitosamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }
    // Método para cerrar la conexión
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Probar la conexión
        Connection connection = Conexion.getConnection();
        if (connection != null) {
            System.out.println("Conexión a MySQL realizada correctamente.");
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}