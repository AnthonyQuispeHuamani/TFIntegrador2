/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recurso;

import java.util.ResourceBundle;

/**
 *
 * @author ACER
 */
public class getconfiguracion {
    public static String getPropiedad(String clave){
        ResourceBundle recursoBundle = ResourceBundle.getBundle("recursos.configuracionDB");
        return recursoBundle.getString(clave);
    }
}
