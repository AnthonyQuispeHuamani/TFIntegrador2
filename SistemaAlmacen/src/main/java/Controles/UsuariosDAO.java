
package Controles;

/**
 *
 * @author ACER
 */
import Objetos.PerfilUsuarios;
import Objetos.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Recurso.Conexion;

public class UsuariosDAO {
    private Connection connection;

    public UsuariosDAO(Connection connection) {
        this.connection = connection;
    }


    

    // Create - Insertar un nuevo usuario
    public void addUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuarios (primer_nombre, segundo_nombre, apellido_paterno, apellido_materno,"
                + " telefono_personal, telefono_emergencia, rol, estado_capacitacion, email, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usuario.getPrimerNombre());
            stmt.setString(2, usuario.getSegundoNombre());
            stmt.setString(3, usuario.getApellidoPaterno());
            stmt.setString(4, usuario.getApellidoMaterno());
            stmt.setString(5, usuario.getTelefonoPersonal());
            stmt.setString(6, usuario.getTelefonoEmergencia());
            stmt.setString(7, usuario.getRol());
            stmt.setString(8, usuario.getEstadoCapacitacion());
            stmt.setString(9, usuario.getEmail());
            stmt.setString(10, usuario.getContrasena());
            stmt.executeUpdate();
            System.out.println("Usuario agregado exitosamente.");
        }
        if (connection != null) connection.close();
    }
    

    // Read - Obtener un usuario por su ID
    public Usuario getUsuarioById(int id) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE id_usuario = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("primer_nombre"),
                    rs.getString("segundo_nombre"),
                    rs.getString("apellido_paterno"),
                    rs.getString(

    "apellido_materno"),
                    rs.getString("telefono_personal"),
                    rs.getString("telefono_emergencia"),
                    rs.getString("rol"),
                    rs.getString("estado_capacitacion"),
                    rs.getString("email"),
                    rs.getString("contrasena")
                );
            } else {
                return null;
            }
        } finally {
            // Cerrar ResultSet, Statement y Connection
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close(); // ¡Cerramos la conexión!
        }
    }

    // Update - Actualizar un usuario
    public void updateUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE usuarios SET primer_nombre = ?, segundo_nombre = ?, apellido_paterno = ?, apellido_materno = ?, telefono_personal = ?, telefono_emergencia = ?, rol = ?, estado_capacitacion = ?, email = ?, contrasena = ? WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usuario.getPrimerNombre());
            stmt.setString(2, usuario.getSegundoNombre());
            stmt.setString(3, usuario.getApellidoPaterno());
            stmt.setString(4, usuario.getApellidoMaterno());
            stmt.setString(5, usuario.getTelefonoPersonal());
            stmt.setString(6, usuario.getTelefonoEmergencia());
            stmt.setString(7, usuario.getRol());
            stmt.setString(8, usuario.getEstadoCapacitacion());
            stmt.setString(9, usuario.getEmail());       // Nuevo campo
            stmt.setString(10, usuario.getContrasena());  // Nuevo campo
            stmt.setInt(11, usuario.getIdUsuario());
            stmt.executeUpdate();
            System.out.println("Usuario actualizado exitosamente.");
        }
        if (connection != null) connection.close();
    }

    // Delete - Eliminar un usuario por su ID
    public void deleteUsuario(int idUsuario) throws SQLException {
        String query = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idUsuario);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Usuario eliminado exitosamente.");
            }
        } 
        if (connection != null) connection.close();
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() throws SQLException {
        
        String query = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("primer_nombre"),
                    rs.getString("segundo_nombre"),
                    rs.getString("apellido_paterno"),
                    rs.getString("apellido_materno"),
                    rs.getString("telefono_personal"),
                    rs.getString("telefono_emergencia"),
                    rs.getString("rol"),
                    rs.getString("estado_capacitacion"),
                    rs.getString("email"),           // Nuevo campo
                    rs.getString("contrasena")       // Nuevo campo
                );
                usuarios.add(usuario);
            }
        }
        if (connection != null) connection.close();
        return usuarios;
    }
    
    public List<Usuario> buscarUsuarios(String textoBusqueda) throws SQLException {
    String query = "SELECT * FROM usuarios WHERE primer_nombre LIKE ? OR segundo_nombre LIKE ? OR apellido_paterno LIKE ? OR apellido_materno LIKE ?";
    List<Usuario> usuarios = new ArrayList<>();
    
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Añadimos los parámetros para la búsqueda con el operador LIKE
            String parametroBusqueda = "%" + textoBusqueda + "%";  // Esto buscará cualquier coincidencia parcial
            stmt.setString(1, parametroBusqueda);
            stmt.setString(2, parametroBusqueda);
            stmt.setString(3, parametroBusqueda);
            stmt.setString(4, parametroBusqueda);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("primer_nombre"),
                        rs.getString("segundo_nombre"),
                        rs.getString("apellido_paterno"),
                        rs.getString("apellido_materno"),
                        rs.getString("telefono_personal"),
                        rs.getString("telefono_emergencia"),
                        rs.getString("rol"),
                        rs.getString("estado_capacitacion"),
                        rs.getString("email"),
                        rs.getString("contrasena")
                    );
                    usuarios.add(usuario);
                }
            }
        }
        if (connection != null) connection.close();
        return usuarios;
    }
    
    public List<Usuario> buscarUsuariosPorRol(String rol) throws SQLException {
    String query = "SELECT * FROM usuarios WHERE rol = ?";
    List<Usuario> usuarios = new ArrayList<>();
    
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, rol);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("primer_nombre"),
                    rs.getString("segundo_nombre"),
                    rs.getString("apellido_paterno"),
                    rs.getString("apellido_materno"),
                    rs.getString("telefono_personal"),
                    rs.getString("telefono_emergencia"),
                    rs.getString("rol"),
                    rs.getString("estado_capacitacion"),
                    rs.getString("email"),
                    rs.getString("contrasena")
                );
                usuarios.add(usuario);
            }
        }
    }
    if (connection != null) connection.close();
    return usuarios;
}
    
    public PerfilUsuarios verificarCredenciales(String email, String contrasena) throws SQLException {
     String query = "SELECT * FROM perfilesusuarios WHERE email = ? AND contrasena = ?";
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        stmt = connection.prepareStatement(query);
        stmt.setString(1, email);
        stmt.setString(2, contrasena);
        rs = stmt.executeQuery();

        if (rs.next()) {
            return new PerfilUsuarios(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("segundo_nombre"),
                rs.getString("apellido_paterno"),
                rs.getString("apellido_materno"),
                rs.getString("dni"),
                rs.getString("perfil_rol"),
                rs.getString("email"),
                rs.getString("contrasena")
            );
        } else {
            return null;
        }
    } finally {
        // Cerrar ResultSet, Statement y Connection
        if (rs != null) rs.close();
        if (connection != null) connection.close(); // Cerramos la conexión
    }
}
}
