/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controles.UsuariosDAO;
import Recurso.Conexion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.sql.Connection;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author ACER
 */
public class SeleccionDB extends javax.swing.JPanel {

    /**
     * Creates new form Seleccion_DB
     */
    public SeleccionDB() {
        initComponents();
        System.out.println("Cargar configuracion");
        cargarConfiguracion();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldURL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPASSWORD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldUSER = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonGUARDAR = new javax.swing.JButton();
        jButtonTESTCONEXION = new javax.swing.JButton();
        jTextFieldSOCKET = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButtonCONECTAR = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SELECCION DE BASE DE DATOS FTP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setText("- Para la coneccion a la base de datos, verifique la existencia de esta en CleverCloud");

        jLabel4.setText("- En el caso de que no se creó la base de datos, o se creara una nueva base de datos, para un ");

        jLabel5.setText("  nuevo almacen, de una nueva obra, por favor, configure y contruya la");

        jLabel6.setText("  nueva base de datos en CleverCloud, consulte la Documentacion, \"Manual de Usuario-Instalación\"");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jLabel3.setText("En el caso de que si exista, llene los campos proporcionados por CleverCloud");

        jLabel7.setText("Conección URI:");

        jLabel8.setText("USER:");

        jLabel9.setText("PASSWORD:");

        jLabel10.setText("EJEMPLO: jdbc:mysql://bjhuu74zbybbjwwselst-mysql.services.clever-cloud.com:3306/bjhuu74zbybbjwwselst");

        jLabel11.setText("EJEMPLO: udcje5c434qob2xl");

        jLabel12.setText("EJEMPLO: 5xX7Bx8BImPoOM5h1Zen");

        jButtonGUARDAR.setText("GUARDAR NUEVA BASE DE DATOS");
        jButtonGUARDAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGUARDARMouseClicked(evt);
            }
        });
        jButtonGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGUARDARActionPerformed(evt);
            }
        });

        jButtonTESTCONEXION.setText("TEST CONECCION");
        jButtonTESTCONEXION.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonTESTCONEXIONMouseClicked(evt);
            }
        });

        jLabel13.setText("Puerto Socket:");

        jLabel14.setText("EJEMPLO: 65432");

        jButtonCONECTAR.setText("INGRESAR");
        jButtonCONECTAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCONECTARMouseClicked(evt);
            }
        });
        jButtonCONECTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCONECTARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel10))))
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButtonTESTCONEXION, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonGUARDAR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCONECTAR)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(68, 68, 68)
                                    .addComponent(jTextFieldUSER, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(jTextFieldSOCKET, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 121, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(3, 3, 3)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldUSER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldSOCKET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTESTCONEXION, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCONECTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGUARDARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGUARDARActionPerformed

    private void jButtonGUARDARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGUARDARMouseClicked
        if (!validarCampos()) {
            return; // Detiene el proceso si los campos no son válidos
        }
        
        Properties props = new Properties();
            props.setProperty("URL", jTextFieldURL.getText().trim());
            props.setProperty("USER", jTextFieldUSER.getText().trim());
            props.setProperty("PASSWORD", jTextFieldPASSWORD.getText().trim());
            props.setProperty("SOCKET", jTextFieldSOCKET.getText().trim());

            try (FileOutputStream out = new FileOutputStream("configuracionDB.properties")) {
                props.store(out, "Configuración de conexión a la base de datos");
                javax.swing.JOptionPane.showMessageDialog(this, "Configuración guardada exitosamente", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                cargarConfiguracion(); // Recarga los valores desde el archivo
            } catch (IOException e) {
                e.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo guardar la configuración", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        
        
    }//GEN-LAST:event_jButtonGUARDARMouseClicked

    private void jButtonTESTCONEXIONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTESTCONEXIONMouseClicked
        // Obtener valores de los campos de texto
    String url = jTextFieldURL.getText().trim();
    String user = jTextFieldUSER.getText().trim();
    String password = jTextFieldPASSWORD.getText().trim();

    // Intentar la conexión
    try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, user, password)) {
        // Si la conexión es exitosa
        JOptionPane.showMessageDialog(this, "Conexión exitosa a la base de datos.", 
            "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (java.sql.SQLException e) {
        // Si ocurre un error
        JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos:\n" + e.getMessage(), 
            "Error de conexión", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_jButtonTESTCONEXIONMouseClicked

    private void jButtonCONECTARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCONECTARMouseClicked
        // Crear la conexión a la base de datos
        Connection connection = Conexion.getConnection(); // Asegúrate de implementar este método
        UsuariosDAO usuariosDAO = new UsuariosDAO(connection);

        // Crear el JFrame y mostrar el panel de inicio
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1120, 752);
        frame.setContentPane(new Inicio(usuariosDAO)); // Muestra el JPanel de Inicio
        //frame.setContentPane(new SeleccionDB()); // Muestra el JPanel de Inicio
        //frame.setContentPane(new Panel()); // Muestra el JPanel de Inicio
        frame.setVisible(true);
    }//GEN-LAST:event_jButtonCONECTARMouseClicked

    private void jButtonCONECTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCONECTARActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Herramientas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inicio()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz 
    }//GEN-LAST:event_jButtonCONECTARActionPerformed
    
    public void cargarConfiguracion() {
        Properties props = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("recursos/configuracionDB.properties")) {
            if (in == null) {
                throw new FileNotFoundException("Archivo 'configuracionDB.properties' no encontrado en recursos.");
            }
            props.load(in);
            jTextFieldURL.setText(props.getProperty("URL", ""));
            jTextFieldUSER.setText(props.getProperty("USER", ""));
            jTextFieldPASSWORD.setText(props.getProperty("PASSWORD", ""));
            jTextFieldSOCKET.setText(props.getProperty("SOCKET", ""));
        } catch (IOException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo cargar la configuración", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validarCampos() {
    if (jTextFieldURL.getText().trim().isEmpty() ||
        jTextFieldUSER.getText().trim().isEmpty() ||
        jTextFieldPASSWORD.getText().trim().isEmpty() ||
        jTextFieldSOCKET.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
        return false;
    }

    try {
        Integer.parseInt(jTextFieldSOCKET.getText().trim()); // Verifica que el puerto sea un número
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "El puerto debe ser un número", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
        return false;
    }
    return true;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCONECTAR;
    private javax.swing.JButton jButtonGUARDAR;
    private javax.swing.JButton jButtonTESTCONEXION;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldPASSWORD;
    private javax.swing.JTextField jTextFieldSOCKET;
    private javax.swing.JTextField jTextFieldURL;
    private javax.swing.JTextField jTextFieldUSER;
    // End of variables declaration//GEN-END:variables
}
