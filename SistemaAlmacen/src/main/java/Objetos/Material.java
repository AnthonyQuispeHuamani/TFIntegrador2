/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author ACER
 */
public class Material {
    private int idMaterial;
    private String nombreMaterial;
    private String categoria;
    private String descripcion;
    private int unidades;
    private String unidadMedida;
    private String ubicacion;
    private String fechaCompra;
    private double precioUnitario;
    private double precioTotal;

    public Material(int idMaterial, String nombreMaterial, String categoria, String descripcion, int unidades, String unidadMedida, String ubicacion, String fechaCompra, double precioUnitario, double precioTotal) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.unidadMedida = unidadMedida;
        this.ubicacion = ubicacion;
        this.fechaCompra = fechaCompra;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    
    
    
    

    public Material(){
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getUnidades() {
        return unidades;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

   

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    
    
}
