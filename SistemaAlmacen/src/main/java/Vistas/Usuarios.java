/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controles.UsuariosDAO;
import Objetos.Usuario;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Usuarios extends javax.swing.JPanel {

    /**
     * Creates new form Usuarios
     */
    
    
    private UsuariosDAO usuariosDAO;  // Instancia de UsuariosDAO
    
    public Usuarios() {
        
       
       this.usuariosDAO = usuariosDAO; // Inicializa el DAO
      
        initComponents();
        cargarOpcionesComboBox();
        cargarUsuarios();
        
        jComboBoxBRol.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBoxBRolActionPerformed(evt);
            }
        });
        
                TablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = TablaUsuarios.getSelectedRow(); // Obtener la fila seleccionada
                if (selectedRow != -1) { // Verificar que se haya seleccionado una fila
                    // Obtener el ID del usuario desde la primera columna de la fila seleccionada (o la columna correspondiente al ID)
                    int idUsuario = (int) TablaUsuarios.getValueAt(selectedRow, 0); 
                    // Almacenar el idUsuario en una variable global o usarlo directamente al eliminar
                    IDUsuario.setText(String.valueOf(idUsuario)); // Mostrar en el JTextField, opcional
                }
            }
        });
        
        
        // Agregar un ListSelectionListener para detectar la selección de filas en la tabla
        TablaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Verificar que no se esté actualizando mientras se selecciona
                if (!event.getValueIsAdjusting()) {
                    // Obtener la fila seleccionada
                    int selectedRow = TablaUsuarios.getSelectedRow();

                    // Verificar que hay una fila seleccionada
                    if (selectedRow != -1) {
                        // Obtener los datos de la fila seleccionada y rellenar los campos
                        IDUsuario.setText(TablaUsuarios.getValueAt(selectedRow, 0).toString());
                        jTextFieldNombre.setText(TablaUsuarios.getValueAt(selectedRow, 1).toString());
                        jTextFieldSegundoNombre.setText(TablaUsuarios.getValueAt(selectedRow, 2).toString());
                        jTextFieldApellidoPaterno.setText(TablaUsuarios.getValueAt(selectedRow, 3).toString());
                        jTextFieldApellidoMaterno.setText(TablaUsuarios.getValueAt(selectedRow, 4).toString());
                        jTextFieldTelefono.setText(TablaUsuarios.getValueAt(selectedRow, 5).toString());
                        jTextFieldTelefonoEmergencia.setText(TablaUsuarios.getValueAt(selectedRow, 6).toString());
                        jComboBoxTipodeROL.setSelectedItem(TablaUsuarios.getValueAt(selectedRow, 7).toString());
                        jComboBoxEstadodeAutorizacion.setSelectedItem(TablaUsuarios.getValueAt(selectedRow, 8).toString());
                        jTextFieldEmail.setText(TablaUsuarios.getValueAt(selectedRow, 9).toString());
                        jTextFieldCodigo.setText(TablaUsuarios.getValueAt(selectedRow, 10).toString());
                        
                    }
                }
            }
        });
        
        
        
    }
    
    
    private void cargarOpcionesComboBox() {
        // Agregar las opciones a jComboBoxTipodeROL
        jComboBoxTipodeROL.addItem("Peón");
        jComboBoxTipodeROL.addItem("Oficial");
        jComboBoxTipodeROL.addItem("Maestro");
        jComboBoxTipodeROL.addItem("Técnico");
        jComboBoxTipodeROL.addItem("Ingeniero");

        // Agregar las opciones a jComboBoxEstadodeAutorizacion
        jComboBoxEstadodeAutorizacion.addItem("Capacitado");
        jComboBoxEstadodeAutorizacion.addItem("No capacitado");
        
        jComboBoxBRol.addItem("Peón");
        jComboBoxBRol.addItem("Oficial");
        jComboBoxBRol.addItem("Maestro");
        jComboBoxBRol.addItem("Técnico");
        jComboBoxBRol.addItem("Ingeniero");

        // Agregar las opciones a jComboBoxEstadodeAutorizacion
        jComboBoxBEstado.addItem("Capacitado");
        jComboBoxBEstado.addItem("No capacitado");
        
    } 
    private void limpiarCampos() {
    IDUsuario.setText("0");
    jTextFieldNombre.setText("");
    jTextFieldSegundoNombre.setText("");
    jTextFieldApellidoPaterno.setText("");
    jTextFieldApellidoMaterno.setText("");
    jTextFieldTelefono.setText("");
    jTextFieldTelefonoEmergencia.setText("");
    jTextFieldEmail.setText("");
    jTextFieldCodigo.setText("");
    
    // Resetear los ComboBox a su primer elemento (opcional)
    jComboBoxTipodeROL.setSelectedIndex(0);
    jComboBoxEstadodeAutorizacion.setSelectedIndex(0);
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        BotonPANEL = new javax.swing.JButton();
        BotonHerramientas = new javax.swing.JButton();
        BotonMaterial = new javax.swing.JButton();
        BotonAlmacen = new javax.swing.JButton();
        BotonInformes = new javax.swing.JButton();
        BotonControlHerramientas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        JtextFielBusquedaUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonBusqueda = new javax.swing.JButton();
        jComboBoxBRol = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxBEstado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        jButtonActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldTelefonoEmergencia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxEstadodeAutorizacion = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxTipodeROL = new javax.swing.JComboBox<>();
        jButtonEDITAR = new javax.swing.JButton();
        EliminarUsuario = new javax.swing.JButton();
        jButtonGUARDAR = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldSegundoNombre = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jButtonGUARDAR1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        IDUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setPreferredSize(new java.awt.Dimension(1080, 750));

        jInternalFrame1.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        BotonPANEL.setText("PANEL");
        BotonPANEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonPANELMouseClicked(evt);
            }
        });

        BotonHerramientas.setText("MÁQUINAS");
        BotonHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonHerramientasMouseClicked(evt);
            }
        });

        BotonMaterial.setText("MATERIALES");
        BotonMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonMaterialMouseClicked(evt);
            }
        });

        BotonAlmacen.setText("INVENTARIO");
        BotonAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonAlmacenMouseClicked(evt);
            }
        });

        BotonInformes.setText("INFORMES");
        BotonInformes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonInformesMouseClicked(evt);
            }
        });

        BotonControlHerramientas.setText("CONTROL HERRAMIENTAS");
        BotonControlHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonControlHerramientasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonPANEL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonAlmacen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonHerramientas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonControlHerramientas)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonControlHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Buscar");

        jButtonBusqueda.setText("Buscar Usuario");
        jButtonBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBusquedaMouseClicked(evt);
            }
        });
        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });

        jComboBoxBRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBRolActionPerformed(evt);
            }
        });

        jLabel12.setText("ROL:");

        jLabel13.setText("Estado");

        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Segundo Nombre", "Apellido Paterno", "Apellido Materno", "Teléfono Personal", "Teléfono Emergencia", "Rol", "Capacitación", "Email", "DNI"
            }
        ));
        jScrollPane1.setViewportView(TablaUsuarios);

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonActualizarMouseClicked(evt);
            }
        });
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxBRol, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtextFielBusquedaUsuario)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtextFielBusquedaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonBusqueda)
                        .addComponent(jButtonActualizar))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxBRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jComboBoxBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("REGISTRO DE USUARIOS");

        jLabel4.setText("Nombre");

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabel5.setText("Segundo Nombre");

        jLabel6.setText("Apellido Materno");

        jTextFieldApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoMaternoActionPerformed(evt);
            }
        });

        jLabel7.setText("Telefono Personal");

        jLabel8.setText("Telefono de emergencia");

        jLabel9.setText("Estado de Autorización");

        jLabel10.setText("ROL");

        jButtonEDITAR.setText("Editar");
        jButtonEDITAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEDITARMouseClicked(evt);
            }
        });

        EliminarUsuario.setText("Eliminar");
        EliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarUsuarioMouseClicked(evt);
            }
        });

        jButtonGUARDAR.setText("Guardar");
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

        jLabel14.setText("Apellido Paterno");

        jLabel16.setText("Email");

        jLabel17.setText("DNI");

        jButtonGUARDAR1.setText("Limpiar");
        jButtonGUARDAR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGUARDAR1MouseClicked(evt);
            }
        });
        jButtonGUARDAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGUARDAR1ActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Usuario");

        IDUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IDUsuario.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(68, 68, 68))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(186, 186, 186))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldSegundoNombre)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jTextFieldApellidoPaterno)
                            .addComponent(jTextFieldApellidoMaterno)
                            .addComponent(jTextFieldTelefono)
                            .addComponent(jTextFieldTelefonoEmergencia)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldCodigo)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxEstadodeAutorizacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxTipodeROL, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButtonGUARDAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(EliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonGUARDAR1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel17))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(127, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(IDUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTelefonoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstadodeAutorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipodeROL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EliminarUsuario)
                    .addComponent(jButtonEDITAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGUARDAR1)
                .addGap(10, 10, 10)
                .addComponent(jButtonGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(301, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(321, Short.MAX_VALUE)))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoMaternoActionPerformed

    private void jButtonGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGUARDARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGUARDARActionPerformed

    private void jButtonGUARDARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGUARDARMouseClicked
        
        try {
        // Obtener la conexión a la base de datos
        Connection connection = Conexion.getConnection();
        
        // Crear una instancia de UsuariosDAO con la conexión
        UsuariosDAO usuariosDAO = new UsuariosDAO(connection);
        
        // Obtener los valores de los campos
        String primerNombre = jTextFieldNombre.getText();
        String segundoNombre = jTextFieldSegundoNombre.getText();
        String apellidoPaterno = jTextFieldApellidoPaterno.getText();
        String apellidoMaterno = jTextFieldApellidoMaterno.getText();
        String telefonoPersonal = jTextFieldTelefono.getText();
        String telefonoEmergencia = jTextFieldTelefonoEmergencia.getText();
       
        // Obtener el rol seleccionado del ComboBox
        String rol = (String) jComboBoxTipodeROL.getSelectedItem();     

        // Obtener el estado de autorización del ComboBox
        String estadoAutorizacion = (String) jComboBoxEstadodeAutorizacion.getSelectedItem();
        
        // Obtener el email y la contraseña
        String email = jTextFieldEmail.getText();
        String contrasena = jTextFieldCodigo.getText();
        
        // Crear un nuevo objeto Usuario con los valores obtenidos
        Usuario nuevoUsuario = new Usuario(
            0,  // El ID no es necesario porque es autoincremental en la base de datos
            primerNombre,
            segundoNombre,
            apellidoPaterno,
            apellidoMaterno,
            telefonoPersonal,
            telefonoEmergencia,
            rol,
            estadoAutorizacion,
            email,
            contrasena
        );
        
        // Guardar el nuevo usuario en la base de datos
        usuariosDAO.addUsuario(nuevoUsuario);
        
        JOptionPane.showMessageDialog(this, "Usuario agregado exitosamente, Limpiando CAMPOS");
        
            limpiarCampos();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al agregar el usuario: " + e.getMessage());
    }
        
        
    }//GEN-LAST:event_jButtonGUARDARMouseClicked

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBusquedaActionPerformed

    private void jButtonBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBusquedaMouseClicked
        
            try {
            // Obtener el texto de búsqueda del JTextField
            String textoBusqueda = JtextFielBusquedaUsuario.getText();

            // Crear una instancia de UsuariosDAO
            UsuariosDAO usuariosDAO = new UsuariosDAO(Conexion.getConnection());

            // Buscar usuarios con el texto ingresado
            List<Usuario> usuariosEncontrados = usuariosDAO.buscarUsuarios(textoBusqueda);

            // Llenar la tabla con los resultados
            DefaultTableModel model = (DefaultTableModel) TablaUsuarios.getModel();
            model.setRowCount(0);  // Limpiar la tabla antes de agregar los nuevos resultados
            
            
            System.out.println("Usuarios encontrados: " + usuariosEncontrados.size());
            System.out.println("Texto de búsqueda: " + textoBusqueda);

            // Agregar cada usuario encontrado a la tabla
            for (Usuario usuario : usuariosEncontrados) {
                Object[] rowData = {
                    usuario.getIdUsuario(),
                    usuario.getPrimerNombre(),
                    usuario.getSegundoNombre(),
                    usuario.getApellidoPaterno(),
                    usuario.getApellidoMaterno(),
                    usuario.getTelefonoPersonal(),
                    usuario.getTelefonoEmergencia(),
                    usuario.getRol(),
                    usuario.getEstadoCapacitacion(),
                    usuario.getEmail(),
                    usuario.getContrasena(),
                    
                };
                model.addRow(rowData);
            }

            // Mostrar un mensaje si no se encontraron resultados
            if (usuariosEncontrados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron usuarios con ese nombre.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar usuarios: " + e.getMessage());
        }
        
        
        
    }//GEN-LAST:event_jButtonBusquedaMouseClicked

    private void jButtonActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonActualizarMouseClicked
        
        cargarUsuarios();
        
        
    }//GEN-LAST:event_jButtonActualizarMouseClicked

    
    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jComboBoxBRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBRolActionPerformed
        
            try {
            // Obtener el rol seleccionado
            String rolSeleccionado = (String) jComboBoxBRol.getSelectedItem();

            // Crear una instancia de UsuariosDAO
            UsuariosDAO usuariosDAO = new UsuariosDAO(Conexion.getConnection());

            // Buscar usuarios con el rol seleccionado
            List<Usuario> usuariosEncontrados = usuariosDAO.buscarUsuariosPorRol(rolSeleccionado);

            // Llenar la tabla con los resultados
            DefaultTableModel model = (DefaultTableModel) TablaUsuarios.getModel();
            model.setRowCount(0);  // Limpiar la tabla antes de agregar los nuevos resultados

            // Agregar cada usuario encontrado a la tabla
            for (Usuario usuario : usuariosEncontrados) {
                Object[] rowData = {
                        usuario.getIdUsuario(),
                        usuario.getPrimerNombre(),
                        usuario.getSegundoNombre(),
                        usuario.getApellidoPaterno(),
                        usuario.getApellidoMaterno(),
                        usuario.getTelefonoPersonal(),
                        usuario.getTelefonoEmergencia(),
                        usuario.getRol(),
                        usuario.getEstadoCapacitacion(),
                        usuario.getEmail(),
                        usuario.getContrasena(),
                };
                model.addRow(rowData);
            }

            // Mostrar un mensaje si no se encontraron resultados
            if (usuariosEncontrados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron usuarios con ese rol.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar usuarios: " + e.getMessage());
        }
        
    }//GEN-LAST:event_jComboBoxBRolActionPerformed

    private void jButtonGUARDAR1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGUARDAR1MouseClicked
        limpiarCampos();
    }//GEN-LAST:event_jButtonGUARDAR1MouseClicked

    private void jButtonGUARDAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGUARDAR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGUARDAR1ActionPerformed

    private void jButtonEDITARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEDITARMouseClicked
        
            try {
            // Obtener los valores de los campos
            String primerNombre = jTextFieldNombre.getText();
            String segundoNombre = jTextFieldSegundoNombre.getText();
            String apellidoPaterno = jTextFieldApellidoPaterno.getText();
            String apellidoMaterno = jTextFieldApellidoMaterno.getText();
            String telefonoPersonal = jTextFieldTelefono.getText();
            String telefonoEmergencia = jTextFieldTelefonoEmergencia.getText();
            String rol = (String) jComboBoxTipodeROL.getSelectedItem();
            String estadoAutorizacion = (String) jComboBoxEstadodeAutorizacion.getSelectedItem();
            String email = jTextFieldEmail.getText();
            String contrasena = jTextFieldCodigo.getText();

            // Obtener el ID del usuario seleccionado en la tabla
            int selectedRow = TablaUsuarios.getSelectedRow();
            if (selectedRow != -1) {
                int idUsuario = Integer.parseInt(TablaUsuarios.getValueAt(selectedRow, 0).toString());

                // Crear un objeto Usuario con los valores actualizados
                Usuario usuarioActualizado = new Usuario(
                    idUsuario,        // El ID del usuario que queremos modificar
                    primerNombre,
                    segundoNombre,
                    apellidoPaterno,
                    apellidoMaterno,
                    telefonoPersonal,
                    telefonoEmergencia,
                    rol,
                    estadoAutorizacion,
                    email,
                    contrasena
                );

                // Actualizar el usuario en la base de datos
                UsuariosDAO usuariosDAO = new UsuariosDAO(Conexion.getConnection());
                usuariosDAO.updateUsuario(usuarioActualizado);

                JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente");

                // Opcional: Volver a cargar los datos de la tabla si es necesario
                cargarUsuarios();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario en la tabla.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar el usuario: " + e.getMessage());
        }
        
    }//GEN-LAST:event_jButtonEDITARMouseClicked

    private void BotonPANELMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonPANELMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
                frame.setContentPane(new Panel()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BotonPANELMouseClicked

    private void BotonHerramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonHerramientasMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BotonHerramientasMouseClicked

    private void BotonMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonMaterialMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            frame.setContentPane(new Materiales()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BotonMaterialMouseClicked

    private void BotonAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAlmacenMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BotonAlmacenMouseClicked

    private void EliminarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarUsuarioMouseClicked
        
            try {
            // Obtener el idUsuario desde el JTextField (o directamente desde la fila seleccionada de la tabla)
            int selectedRow = TablaUsuarios.getSelectedRow();

            // Validar si se ha seleccionado una fila
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Por favor selecciona un usuario.");
                return;
            }

            // Obtener el ID del usuario desde la tabla (suponiendo que está en la primera columna, ajusta si es necesario)
            int idUsuario = (int) TablaUsuarios.getValueAt(selectedRow, 0);

            // Confirmación antes de eliminar
            int confirm = JOptionPane.showConfirmDialog(null, 
                "¿Estás seguro de que deseas eliminar este usuario? \n" 
                        + TablaUsuarios.getValueAt(selectedRow, 1)+ " " 
                        + TablaUsuarios.getValueAt(selectedRow, 2)+ " " 
                        + TablaUsuarios.getValueAt(selectedRow, 3) 
                    
                    
                    , "Confirmar eliminación", 
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // Llamar a la función deleteUsuario en UsuariosDAO
                UsuariosDAO usuariosDAO = new UsuariosDAO(Conexion.getConnection());
                usuariosDAO.deleteUsuario(idUsuario);

                // Refrescar la tabla después de la eliminación (opcional)
                cargarUsuarios();

                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona un usuario válido.");
        }

        
        
        
        
    }//GEN-LAST:event_EliminarUsuarioMouseClicked

    private void BotonInformesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonInformesMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BotonInformesMouseClicked

    private void BotonControlHerramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonControlHerramientasMouseClicked
         JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            frame.setContentPane(new ControlHerramientas()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BotonControlHerramientasMouseClicked
      
    
    private void cargarUsuarios() {
            try {
                // Crear una instancia de UsuariosDAO
                UsuariosDAO usuariosDAO = new UsuariosDAO(Conexion.getConnection());

                // Obtener todos los usuarios de la base de datos
                List<Usuario> usuarios = usuariosDAO.getAllUsuarios();

                // Llenar la tabla con los usuarios
                DefaultTableModel model = (DefaultTableModel) TablaUsuarios.getModel();
                model.setRowCount(0);  // Limpiar la tabla antes de agregar los usuarios

                for (Usuario usuario : usuarios) {
                    Object[] rowData = {
                        usuario.getIdUsuario(),
                        usuario.getPrimerNombre(),
                        usuario.getSegundoNombre(),
                        usuario.getApellidoPaterno(),
                        usuario.getApellidoMaterno(),
                        usuario.getTelefonoPersonal(),
                        usuario.getTelefonoEmergencia(),
                        usuario.getRol(),
                        usuario.getEstadoCapacitacion(),
                        usuario.getEmail(),
                        usuario.getContrasena(),
                        
                        
                    };
                    model.addRow(rowData);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + e.getMessage());
            }
            
            
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAlmacen;
    private javax.swing.JButton BotonControlHerramientas;
    private javax.swing.JButton BotonHerramientas;
    private javax.swing.JButton BotonInformes;
    private javax.swing.JButton BotonMaterial;
    private javax.swing.JButton BotonPANEL;
    private javax.swing.JButton EliminarUsuario;
    private javax.swing.JLabel IDUsuario;
    private javax.swing.JTextField JtextFielBusquedaUsuario;
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonEDITAR;
    private javax.swing.JButton jButtonGUARDAR;
    private javax.swing.JButton jButtonGUARDAR1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JComboBox<String> jComboBoxBEstado;
    private javax.swing.JComboBox<String> jComboBoxBRol;
    private javax.swing.JComboBox<String> jComboBoxEstadodeAutorizacion;
    private javax.swing.JComboBox<String> jComboBoxTipodeROL;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldApellidoMaterno;
    private javax.swing.JTextField jTextFieldApellidoPaterno;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldSegundoNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextFieldTelefonoEmergencia;
    // End of variables declaration//GEN-END:variables
}
