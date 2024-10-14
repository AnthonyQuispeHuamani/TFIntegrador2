/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vistas;

import Controles.MaterialesDAO;
import Controles.UsuariosDAO;
import Objetos.Usuario;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author ACER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear la conexión a la base de datos
        Connection connection = Conexion.getConnection(); // Asegúrate de implementar este método
        UsuariosDAO usuariosDAO = new UsuariosDAO(connection);

        // Crear el JFrame y mostrar el panel de inicio
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1120, 752);
        //frame.setContentPane(new Inicio(usuariosDAO)); // Muestra el JPanel de Inicio
        frame.setContentPane(new Panel()); // Muestra el JPanel de Inicio
        frame.setVisible(true);
    }
}
