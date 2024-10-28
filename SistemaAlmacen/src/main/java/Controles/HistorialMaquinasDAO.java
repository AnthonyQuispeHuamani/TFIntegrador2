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

    public void agregarHistorialMaquina(int idMaquina, int idUsuario, Date fechaMovimiento, String estado, String observacion) throws SQLException {
        String query = "INSERT INTO historialmaquinas (id_maquina, fecha_movimiento, id_usuario, Estado, Observacion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idMaquina);
            stmt.setDate(2, new java.sql.Date(fechaMovimiento.getTime()));
            stmt.setInt(3, idUsuario);
            stmt.setString(4, estado);
            stmt.setString(5, observacion);
            stmt.executeUpdate();
        }
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
    }
    return historialCompletoList;
}
public void updateEstadoHistorial(int idHistorial, String nuevoEstado) throws SQLException {
    String query = "UPDATE historialmaquinas SET Estado = ? WHERE id_historial = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, nuevoEstado);
        stmt.setInt(2, idHistorial);
        stmt.executeUpdate();
    }
}

}
