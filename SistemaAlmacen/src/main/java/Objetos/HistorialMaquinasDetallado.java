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
public class HistorialMaquinasDetallado {
    private int idHistorial;
    private int idMaquina;
    private Date fechaMovimiento;
    private int idUsuario;
    private String estadoHistorial;
    private String observacion;

    // Atributos adicionales para la consulta detallada
    private String nombreTrabajador;
    private String rol;
    private String capacitacion;
    private String maquinaAsignada;
    private String numeroSerie;
    
    // Constructor para consulta detallada
    public HistorialMaquinasDetallado(
            int idHistorial,
            int idMaquina,
            Date fechaMovimiento,
            int idUsuario,
            String estadoHistorial,
            String observacion,
            String nombreTrabajador,
            String rol,
            String capacitacion,
            String maquinaAsignada,
            String numeroSerie) {
        
        this.idHistorial = idHistorial;
        this.idMaquina = idMaquina;
        this.fechaMovimiento = fechaMovimiento;
        this.idUsuario = idUsuario;
        this.estadoHistorial = estadoHistorial;
        this.observacion = observacion;
        this.nombreTrabajador = nombreTrabajador;
        this.rol = rol;
        this.capacitacion = capacitacion;
        this.maquinaAsignada = maquinaAsignada;
        this.numeroSerie = numeroSerie;
    }
    
    // Getters y setters para todos los atributos

    // Getters y Setters para atributos existentes
    public int getIdHistorial() { return idHistorial; }
    public void setIdHistorial(int idHistorial) { this.idHistorial = idHistorial; }
    public int getIdMaquina() { return idMaquina; }
    public void setIdMaquina(int idMaquina) { this.idMaquina = idMaquina; }
    public Date getFechaMovimiento() { return fechaMovimiento; }
    public void setFechaMovimiento(Date fechaMovimiento) { this.fechaMovimiento = fechaMovimiento; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getEstadoHistorial() { return estadoHistorial; }
    public void setEstadoHistorial(String estadoHistorial) { this.estadoHistorial = estadoHistorial; }
    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }

    // Getters y Setters para los nuevos atributos
    public String getNombreTrabajador() { return nombreTrabajador; }
    public void setNombreTrabajador(String nombreTrabajador) { this.nombreTrabajador = nombreTrabajador; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public String getCapacitacion() { return capacitacion; }
    public void setCapacitacion(String capacitacion) { this.capacitacion = capacitacion; }
    public String getMaquinaAsignada() { return maquinaAsignada; }
    public void setMaquinaAsignada(String maquinaAsignada) { this.maquinaAsignada = maquinaAsignada; }
    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }
}
