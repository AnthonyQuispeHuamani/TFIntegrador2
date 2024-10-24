/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ACER
 */
public class Inventario extends javax.swing.JPanel {

    /**
     * Creates new form Inventario
     */
    public Inventario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btn_usuarios = new javax.swing.JButton();
        btn_materiales = new javax.swing.JButton();
        btn_maquinas = new javax.swing.JButton();
        btn_controlHerramientas = new javax.swing.JButton();
        btn_informes = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1080, 750));

        jInternalFrame1.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("PANEL");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_usuarios.setText("USUARIOS");
        btn_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_usuariosMouseClicked(evt);
            }
        });

        btn_materiales.setText("MATERIALES");
        btn_materiales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_materialesMouseClicked(evt);
            }
        });

        btn_maquinas.setText("MÁQUINAS");
        btn_maquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_maquinasMouseClicked(evt);
            }
        });

        btn_controlHerramientas.setText("CONTROL HERRAMIENTAS");
        btn_controlHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_controlHerramientasMouseClicked(evt);
            }
        });

        btn_informes.setText("INFORMES");
        btn_informes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_informesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btn_usuarios)
                .addGap(18, 18, 18)
                .addComponent(btn_maquinas)
                .addGap(18, 18, 18)
                .addComponent(btn_materiales)
                .addGap(18, 18, 18)
                .addComponent(btn_informes)
                .addGap(18, 18, 18)
                .addComponent(btn_controlHerramientas)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btn_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_maquinas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_materiales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_informes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_controlHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
                frame.setContentPane(new Panel()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_jButton1MouseClicked

    private void btn_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usuariosMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Materiales()); // Cambiar al nuevo panel
            frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            //frame.setContentPane(new ControlHerramientas()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz    
    }//GEN-LAST:event_btn_usuariosMouseClicked

    private void btn_maquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maquinasMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Materiales()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            //frame.setContentPane(new ControlHerramientas()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz   
    }//GEN-LAST:event_btn_maquinasMouseClicked

    private void btn_materialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_materialesMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            frame.setContentPane(new Materiales()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            //frame.setContentPane(new ControlHerramientas()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz   
    }//GEN-LAST:event_btn_materialesMouseClicked

    private void btn_informesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_informesMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Materiales()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            //frame.setContentPane(new ControlHerramientas()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz   
    }//GEN-LAST:event_btn_informesMouseClicked

    private void btn_controlHerramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_controlHerramientasMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Materiales()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            frame.setContentPane(new ControlHerramientas()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz   
    }//GEN-LAST:event_btn_controlHerramientasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_controlHerramientas;
    private javax.swing.JButton btn_informes;
    private javax.swing.JButton btn_maquinas;
    private javax.swing.JButton btn_materiales;
    private javax.swing.JButton btn_usuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
