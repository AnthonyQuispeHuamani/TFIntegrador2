/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Objetos.HistorialMaquinas;
import Objetos.HistorialMaquinasDetallado;
import Objetos.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class HistorialMaquinasDAO {
    private Connection connection;

    public HistorialMaquinasDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarHistorialMaquina(int idMaquina, int idUsuario, Date fechaMovimiento, String estado, String observacion, Integer idFoto) throws SQLException {
    // Verificar si la situación de la máquina es 'Entregado'
    if (!verificarSituacionMaquina(idMaquina)) {
        throw new SQLException("La máquina no puede ser asignada porque no ha sido entregada.");
    }

    // Si no se seleccionó una foto, mostrar mensaje de advertencia
    if (idFoto == null) {
        throw new SQLException("No se seleccionó una imagen para guardar.");
    }

    String query = "INSERT INTO historialmaquinas (id_maquina, fecha_movimiento, id_usuario, Estado, Observacion, id_foto) VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, idMaquina);
        stmt.setDate(2, new java.sql.Date(fechaMovimiento.getTime()));
        stmt.setInt(3, idUsuario);
        stmt.setString(4, estado);
        stmt.setString(5, observacion);
        stmt.setInt(6, idFoto);
        stmt.executeUpdate();
        if (connection != null) connection.close();
    }
}
    
    public void actualizarSituacionMaquina(int idMaquina) throws SQLException {
    String query = "UPDATE maquinas SET situacion = 'Entregado' WHERE id_maquina = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idMaquina);
            stmt.executeUpdate();
            
            if (connection != null) connection.close();
        }
    }
    
    public void actualizarSituacionMaquinaNOENTREGADA(int idMaquina) throws SQLException {
    String query = "UPDATE maquinas SET situacion = 'No entregado' WHERE id_maquina = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idMaquina);
            stmt.executeUpdate();
            
            if (connection != null) connection.close();
        }
    }
    
    public boolean verificarSituacionMaquina(int idMaquina) throws SQLException {
    String query = "SELECT situacion FROM maquinas WHERE id_maquina = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, idMaquina);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String situacion = rs.getString("situacion");
                return "Entregado".equals(situacion);  // Si la situación es 'Entregado', devolver true
            }
        }
        if (connection != null) connection.close();
    }
    return false;  // Si la situación no es 'Entregado', devolver false
}
    
    // Listar todo el historial de máquinas
    public List<HistorialMaquinas> getAllHistorialMaquinas() throws SQLException {
        String query = "SELECT * FROM historialmaquinas";
        List<HistorialMaquinas> historialMaquinasList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                HistorialMaquinas historial = new HistorialMaquinas(
                    rs.getInt("id_historial"),             // ID del historial
                    rs.getInt("id_maquina"),               // ID de la máquina
                    rs.getDate("fecha_movimiento"),        // Fecha del movimiento
                    rs.getInt("id_usuario"),               // ID del usuario
                    rs.getString("Estado"),                // Estado (Entregado, No entregado, etc.)
                    rs.getString("Observacion")            // Observación
                );
                historialMaquinasList.add(historial);
            }
            if (connection != null) connection.close();
        }
        return historialMaquinasList;
    }
    public List<HistorialMaquinasDetallado> getAllHistorialMaquinasCompleto() throws SQLException {
    String query = "SELECT " +
                   "h.id_historial, " +
                   "h.id_maquina, " + // Agregando el ID de la máquina
                   "h.fecha_movimiento, " + // Asegúrate de que este campo esté en la tabla
                   "h.id_usuario, " + // Agregando el ID del usuario
                   "u.primer_nombre AS nombre_trabajador, " +
                   "u.rol, " +
                   "u.estado_capacitacion AS capacitacion, " +
                   "m.nombre_herramienta AS maquina_asignada, " +
                   "m.numero_serie, " +
                   "h.Estado AS estado_historial " +
                   "FROM historialmaquinas h " +
                   "INNER JOIN usuarios u ON h.id_usuario = u.id_usuario " +
                   "INNER JOIN maquinas m ON h.id_maquina = m.id_maquina";

    List<HistorialMaquinasDetallado> historialCompletoList = new ArrayList<>();
    try (PreparedStatement stmt = connection.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            HistorialMaquinasDetallado historial = new HistorialMaquinasDetallado(
                    rs.getInt("id_historial"),
                    rs.getInt("id_maquina"),
                    rs.getDate("fecha_movimiento"), // Asegúrate de que el campo esté en la tabla
                    rs.getInt("id_usuario"),
                    rs.getString("estado_historial"),
                    null, // Puedes agregar observaciones si tienes el campo
                    rs.getString("nombre_trabajador"),
                    rs.getString("rol"),
                    rs.getString("capacitacion"),
                    rs.getString("maquina_asignada"),
                    rs.getString(
           
"numero_serie")
            );
            historialCompletoList.add(historial);
        }
        if (connection != null) connection.close();
    }
    return historialCompletoList;
}
public void updateEstadoHistorial(int idHistorial, String nuevoEstado) throws SQLException {
    String query = "UPDATE historialmaquinas SET estado = ? WHERE id_historial = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, nuevoEstado);
        stmt.setInt(2, idHistorial);
        stmt.executeUpdate();
        if (connection != null) connection.close();
    }
}

}
