/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author ACER
 */
public class Maquina {
    private int idMaquina;
    private String nombreHerramienta;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private String estadoHerramienta;
    private String ubicacion;
    private String fechaEntrada;
    private byte[] fotoRecognicion;
    private String situacion; // Nueva columna

    // Constructor vacío
    public Maquina() {
    }

    // Constructor con todos los campos
    public Maquina(int idMaquina, String nombreHerramienta, String marca, String modelo, String numeroSerie, String estadoHerramienta, String ubicacion, String fechaEntrada, byte[] fotoRecognicion, String situacion) {
        this.idMaquina = idMaquina;
        this.nombreHerramienta = nombreHerramienta;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.estadoHerramienta = estadoHerramienta;
        this.ubicacion = ubicacion;
        this.fechaEntrada = fechaEntrada;
        this.fotoRecognicion = fotoRecognicion;
        this.situacion = situacion;
    }

    // Getters y setters para todos los campos
    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getEstadoHerramienta() {
        return estadoHerramienta;
    }

    public void setEstadoHerramienta(String estadoHerramienta) {
        this.estadoHerramienta = estadoHerramienta;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public byte[] getFotoRecognicion() {
        return fotoRecognicion;
    }

    public void setFotoRecognicion(byte[] fotoRecognicion) {
        this.fotoRecognicion = fotoRecognicion;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    
}
