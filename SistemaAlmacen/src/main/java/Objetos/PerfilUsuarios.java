/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author ACER
 */
public class PerfilUsuarios {
    
    // Campos que representan las columnas de la tabla PerfilesUsuarios
    private int id;                     // ID autoincremental
    private String nombre;              // Primer nombre
    private String segundoNombre;       // Segundo nombre
    private String apellidoPaterno;     // Apellido paterno
    private String apellidoMaterno;     // Apellido materno
    private String dni;                 // DNI
    private String perfilRol;           // Perfil para roles (Administrador, Seguridad, Almacenero, etc.)
    private String email;               // Email
    private String contrasena;          // Contraseña

    // Aquí puedes agregar tus getters, setters y constructores

    public PerfilUsuarios(int id, String nombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, String dni, String perfilRol, String email, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.dni = dni;
        this.perfilRol = perfilRol;
        this.email = email;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
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

    public String getDni() {
        return dni;
    }

    public String getPerfilRol() {
        return perfilRol;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setPerfilRol(String perfilRol) {
        this.perfilRol = perfilRol;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
    
}
