/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author ACER
 */
public class HistorialMaquinas {
    private int idHistorial;
    private int idMaquina;
    private java.util.Date fechaMovimiento;
    private int idUsuario;
    private String estado;
    private String observacion;

    // Constructor completo
    public HistorialMaquinas(int idHistorial, int idMaquina, java.util.Date fechaMovimiento, int idUsuario, String estado, String observacion) {
        this.idHistorial = idHistorial;
        this.idMaquina = idMaquina;
        this.fechaMovimiento = fechaMovimiento;
        this.idUsuario = idUsuario;
        this.estado = estado;
        this.observacion = observacion;
    }

    // Constructor vacío
    public HistorialMaquinas() {
    }

    // Getters y Setters
    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public java.util.Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(java.util.Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
