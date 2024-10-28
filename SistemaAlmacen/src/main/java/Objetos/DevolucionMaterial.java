/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.sql.Date;

/**
 *
 * @author ACER
 */
public class DevolucionMaterial {
    private int idDevolucionMaterial;
    private int idMaterial;
    private int idUsuario;
    private Date fechaDevolucion;
    private float cantidadDevolucion;

    // Constructor
    public DevolucionMaterial(int idMaterial, int idUsuario, Date fechaDevolucion, float cantidadDevolucion) {
        this.idMaterial = idMaterial;
        this.idUsuario = idUsuario;
        this.fechaDevolucion = fechaDevolucion;
        this.cantidadDevolucion = cantidadDevolucion;
    }

    // Getters y Setters
    public int getIdDevolucionMaterial() {
        return idDevolucionMaterial;
    }

    public void setIdDevolucionMaterial(int idDevolucionMaterial) {
        this.idDevolucionMaterial = idDevolucionMaterial;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public float getCantidadDevolucion() {
        return cantidadDevolucion;
    }

    public void setCantidadDevolucion(float cantidadDevolucion) {
        this.cantidadDevolucion = cantidadDevolucion;
    }
}
