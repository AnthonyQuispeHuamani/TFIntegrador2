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
    

    public Maquina() {
        
    }
    public Maquina(int idMaquina, String nombreHerramienta, String marca, String modelo, String numeroSerie, String estadoHerramienta, String ubicacion, String fechaEntrada,byte[] fotoRecognicion) {
        this.idMaquina = idMaquina;
        this.nombreHerramienta = nombreHerramienta;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.estadoHerramienta = estadoHerramienta;
        this.ubicacion = ubicacion;
        this.fechaEntrada = fechaEntrada;
        this.fotoRecognicion = fotoRecognicion;
    }

    public byte[] getFotoRecognicion() {
        return fotoRecognicion;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getEstadoHerramienta() {
        return estadoHerramienta;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setEstadoHerramienta(String estadoHerramienta) {
        this.estadoHerramienta = estadoHerramienta;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFotoRecognicion(byte[] fotoRecognicion) {
        this.fotoRecognicion = fotoRecognicion;
    }
    
}
