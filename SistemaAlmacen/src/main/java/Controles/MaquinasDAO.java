/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Objetos.Maquina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class MaquinasDAO {

    public static void addMaquina(Vistas.Maquinas nuevaMaquina) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Connection connection;

    public MaquinasDAO(Connection connection) {
        this.connection = connection;
    }

    // Crear una nueva máquina
public void addMaquina(Maquina maquina) throws SQLException {
    String query = "INSERT INTO maquinas (nombre_herramienta, marca, modelo, numero_serie, estado_herramienta, ubicacion, fecha_entrada, foto_recognicion, situacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {

        // Establecer los valores de los campos
        stmt.setString(1, maquina.getNombreHerramienta());
        stmt.setString(2, maquina.getMarca());
        stmt.setString(3, maquina.getModelo());
        stmt.setString(4, maquina.getNumeroSerie());
        stmt.setString(5, maquina.getEstadoHerramienta());
        stmt.setString(6, maquina.getUbicacion());

        // Convertir la fecha de LocalDate a java.sql.Date
        stmt.setDate(7, java.sql.Date.valueOf(maquina.getFechaEntrada())); // Ajustar si es LocalDate

        // Insertar foto como bytes (por ahora puedes usar un array vacío o algún dato por defecto)
        stmt.setBytes(8, maquina.getFotoRecognicion());

        // Establecer el valor del nuevo campo situacion
        stmt.setString(9, maquina.getSituacion());

        // Ejecutar la consulta
        stmt.executeUpdate();
        System.out.println("Máquina agregada exitosamente.");
    }
}

    // Leer una máquina por su ID
public Maquina getMaquinaById(int idMaquina) throws SQLException {
    String query = "SELECT * FROM maquinas WHERE id_maquina = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, idMaquina);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Maquina(
                rs.getInt("id_maquina"),
                rs.getString("nombre_herramienta"),
                rs.getString("marca"),
                rs.getString("modelo"),
                rs.getString("numero_serie"),
                rs.getString("estado_herramienta"),
                rs.getString("ubicacion"),
                rs.getString("fecha_entrada"),
                rs.getBytes("foto_recognicion"),
                rs.getString("situacion") // Nuevo campo
            );
        } else {
            return null;
        }
    }
}

    // Actualizar una máquina
public void updateMaquina(Maquina maquina) throws SQLException {
    String query = "UPDATE maquinas SET nombre_herramienta = ?, marca = ?, modelo = ?, numero_serie = ?, estado_herramienta = ?, ubicacion = ?, fecha_entrada = ?, foto_recognicion = ?, situacion = ? WHERE id_maquina = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, maquina.getNombreHerramienta());
        stmt.setString(2, maquina.getMarca());
        stmt.setString(3, maquina.getModelo());
        stmt.setString(4, maquina.getNumeroSerie());
        stmt.setString(5, maquina.getEstadoHerramienta());
        stmt.setString(6, maquina.getUbicacion());
        stmt.setString(7, maquina.getFechaEntrada());
        stmt.setBytes(8, maquina.getFotoRecognicion());
        stmt.setString(9, maquina.getSituacion()); // Nuevo campo agregado
        stmt.setInt(10, maquina.getIdMaquina());
        stmt.executeUpdate();
        if (connection != null) connection.close();
    }
}

    // Eliminar una máquina
    public void deleteMaquina(int idMaquina) throws SQLException {
        String query = "DELETE FROM maquinas WHERE id_maquina = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idMaquina);
            stmt.executeUpdate();
            System.out.println("Máquina eliminada exitosamente.");
            if (connection != null) connection.close();
        }
    }

    // Listar todas las máquinas
public List<Maquina> getAllMaquinas() throws SQLException {
    String query = "SELECT * FROM maquinas";
    List<Maquina> maquinas = new ArrayList<>();
    try (PreparedStatement stmt = connection.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Maquina maquina = new Maquina(
                rs.getInt("id_maquina"),
                rs.getString("nombre_herramienta"),
                rs.getString("marca"),
                rs.getString("modelo"),
                rs.getString("numero_serie"),
                rs.getString("estado_herramienta"),
                rs.getString("ubicacion"),
                rs.getString("fecha_entrada"),
                rs.getBytes("foto_recognicion"),
                rs.getString("situacion") // Se agregó el nuevo campo
            );
            maquinas.add(maquina);
        }
        if (connection != null) connection.close();
    }
    return maquinas;
}

}
