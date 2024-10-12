/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author ACER
 */
public class Usuario {
    private int idUsuario;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefonoPersonal;
    private String telefonoEmergencia;
    private String rol;
    private String estadoCapacitacion;
    private String email;         // Nuevo campo
    private String contrasena;     // Nuevo campo

    public Usuario() {
    }

    

    public Usuario(int idUsuario, String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, String telefonoPersonal, String telefonoEmergencia, String rol, String estadoCapacitacion, String email, String contrasena) {
        this.idUsuario = idUsuario;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefonoPersonal = telefonoPersonal;
        this.telefonoEmergencia = telefonoEmergencia;
        this.rol = rol;
        this.estadoCapacitacion = estadoCapacitacion;
        this.email = email;
        this.contrasena = contrasena;
    }
    

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public String getRol() {
        return rol;
    }

    public String getEstadoCapacitacion() {
        return estadoCapacitacion;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setEstadoCapacitacion(String estadoCapacitacion) {
        this.estadoCapacitacion = estadoCapacitacion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
