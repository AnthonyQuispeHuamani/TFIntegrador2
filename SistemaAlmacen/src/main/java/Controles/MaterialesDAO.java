/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Objetos.Material;
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
public class MaterialesDAO {
    private Connection connection;

    public MaterialesDAO(Connection connection) {
        this.connection = connection;
    }

    // Crear un nuevo material
    public void addMaterial(Material material) throws SQLException {
            String query = "INSERT INTO materiales (nombre_material, categoria_material, descripcion, unidades, unidad_medida, ubicacion_almacen, fecha_compra, precio_unitario, precio_total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, material.getNombreMaterial());
            stmt.setString(2, material.getCategoria());
            stmt.setString(3, material.getDescripcion());
            stmt.setFloat(4, material.getUnidades());
            stmt.setString(5, material.getUnidadMedida());
            stmt.setString(6, material.getUbicacion());
            stmt.setString(7, material.getFechaCompra()); // Fecha de compra en formato `String`
            stmt.setDouble(8, material.getPrecioUnitario());
            stmt.setDouble(9, material.getPrecioTotal());

            stmt.executeUpdate();
            System.out.println("Material registrado exitosamente.");
        }
        if (connection != null) connection.close();
    }

    // Leer un material por su ID
        public Material getMaterialById(int idMaterial) throws SQLException {
        String query = "SELECT * FROM materiales WHERE id_material = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, idMaterial);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Material(
                    rs.getInt("idMaterial"),
                    rs.getString("nombre_material"),
                    rs.getString("categoria_material"),
                    rs.getString("descripcion"),
                    rs.getInt("unidades"),
                    rs.getString("unidad_medida"),
                    rs.getString("ubicacion_almacen"),
                    rs.getString("fecha_compra"),
                    rs.getDouble("precio_unitario"),
                    rs.getDouble("precio_total")
                );
            } else {
                return null;
            }
        } finally {
            // Cerrar el ResultSet, Statement y Connection
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();


    if (connection != null) connection.close(); // ¡Cerrar la conexión aquí!
        }
    }

    // Actualizar un material
    public void updateMaterial(Material material) throws SQLException {
        String query = "UPDATE materiales SET nombre_material = ?, categoria_material = ?, descripcion = ?, unidades = ?, unidad_medida = ?, ubicacion_almacen = ?, fecha_compra = ?, precio_unitario = ?, precio_total = ? WHERE id_material = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, material.getNombreMaterial());
        stmt.setString(2, material.getCategoria());
        stmt.setString(3, material.getDescripcion());
        stmt.setFloat(4, material.getUnidades());
        stmt.setString(5, material.getUnidadMedida());
        stmt.setString(6, material.getUbicacion());
        stmt.setString(7, material.getFechaCompra());
        stmt.setDouble(8, material.getPrecioUnitario());
        stmt.setDouble(9, material.getPrecioTotal());
        stmt.setInt(10, material.getIdMaterial());  // Usar el ID del material para identificar el registro
        stmt.executeUpdate();
        System.out.println("Material actualizado exitosamente.");
    }
    if (connection != null) connection.close();
    }

    // Eliminar un material
    public void deleteMaterial(int idMaterial) throws SQLException {
        String query = "DELETE FROM materiales WHERE id_material = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idMaterial);
            stmt.executeUpdate();
            System.out.println("Material eliminado exitosamente.");
        }
        if (connection != null) connection.close();
    }

    // Listar todos los materiales
    public List<Material> getAllMateriales() throws SQLException {
        String query = "SELECT * FROM materiales";
        List<Material> materiales = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Material material = new Material(
                    rs.getInt("id_material"),
                    rs.getString("nombre_material"),
                    rs.getString("categoria_material"),
                    rs.getString("descripcion"),
                    rs.getInt("unidades"),
                    rs.getString("unidad_medida"),
                    rs.getString("ubicacion_almacen"),
                    rs.getString("fecha_compra"),
                    rs.getDouble("precio_unitario"),
                    rs.getDouble("precio_total")
                    
                );
                materiales.add(material);
            }
        }
        if (connection != null) connection.close();
        return materiales;
    }
}
