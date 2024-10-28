/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author ACER
 */
public class DevolucionMaterialDetallado {
    private int idDevolucionMaterial;
    private String rol;
    private String nombreTrabajador;
    private String areaCategoria;
    private float unidades;
    private String material;
    private String unidadMedida;

    // Constructor, getters y setters

    public DevolucionMaterialDetallado(int idDevolucionMaterial, String rol, String nombreTrabajador,
                                        String areaCategoria, float unidades, String material,
                                        String unidadMedida) {
        this.idDevolucionMaterial = idDevolucionMaterial;
        this.rol = rol;
        this.nombreTrabajador = nombreTrabajador;
        this.areaCategoria = areaCategoria;
        this.unidades = unidades;
        this.material = material;
        this.unidadMedida = unidadMedida;
    }

    // Getters y setters omitidos para brevedad

    public int getIdDevolucionMaterial() {
        return idDevolucionMaterial;
    }

    public String getRol() {
        return rol;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public String getAreaCategoria() {
        return areaCategoria;
    }

    public float getUnidades() {
        return unidades;
    }

    public String getMaterial() {
        return material;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setIdDevolucionMaterial(int idDevolucionMaterial) {
        this.idDevolucionMaterial = idDevolucionMaterial;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public void setAreaCategoria(String areaCategoria) {
        this.areaCategoria = areaCategoria;
    }

    public void setUnidades(float unidades) {
        this.unidades = unidades;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
}
