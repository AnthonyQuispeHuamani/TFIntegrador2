/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Objetos.DevolucionMaterial;
import Objetos.DevolucionMaterialDetallado;
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
public class DevolucionMaterialDAO {
    private Connection connection;

    public DevolucionMaterialDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertarDevolucionMaterial(DevolucionMaterial devolucion) throws SQLException {
        String query = "INSERT INTO devolucionmaterial (id_material, id_usuario, fecha_devolucion, cantidad_devolucion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, devolucion.getIdMaterial());
            stmt.setInt(2, devolucion.getIdUsuario());
            stmt.setDate(3, new java.sql.Date(devolucion.getFechaDevolucion().getTime()));
            stmt.setFloat(4, devolucion.getCantidadDevolucion());
            stmt.executeUpdate();
            
            if (connection != null) connection.close();
        }
    }
    public List<DevolucionMaterialDetallado> getAllDevolucionesDetalladas() throws SQLException {
    String query = "SELECT " +
                   "d.id_devolucion_material, " +
                   "u.rol, " +
                   "CONCAT(COALESCE(u.primer_nombre, ''), ' ', COALESCE(u.segundo_nombre, ''), ' ', " +
                   "COALESCE(u.apellido_paterno, ''), ' ', COALESCE(u.apellido_materno, '')) AS nombre_trabajador, " +
                   "m.categoria_material AS area_categoria, " +
                   "d.cantidad_devolucion AS unidades, " +
                   "m.nombre_material AS material, " +
                   "m.unidad_medida AS unidad_medida " +
                   "FROM devolucionmaterial d " +
                   "INNER JOIN usuarios u ON d.id_usuario = u.id_usuario " +
                   "INNER JOIN materiales m ON d.id_material = m.id_material";

    List<DevolucionMaterialDetallado> devolucionesDetalladasList = new ArrayList<>();
    try (PreparedStatement stmt = connection.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            DevolucionMaterialDetallado devolucion = new DevolucionMaterialDetallado(
                rs.getInt("id_devolucion_material"),
                rs.getString("rol"),
                rs.getString("nombre_trabajador"),
                rs.getString("area_categoria"),
                rs.getFloat("unidades"),
                rs.getString("material"),
                rs.getString("unidad_medida")
            );
            devolucionesDetalladasList.add(devolucion);
        }
        if (connection != null) connection.close();
    }
    return devolucionesDetalladasList;
    
}

}
