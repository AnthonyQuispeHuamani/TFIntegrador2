/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controles.MaterialesDAO;
import Controles.UsuariosDAO;
import Objetos.Material;
import Recurso.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Materiales extends javax.swing.JPanel {

    
    

    
    
    public Materiales() {
        initComponents();
        cargarMateriales();
        mostrarFechaActual();
        
            // Detectar la selección de filas en la tabla
    jTableMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int selectedRow = jTableMaterial.getSelectedRow(); // Obtener la fila seleccionada
            if (selectedRow != -1) { // Verificar que se haya seleccionado una fila
                // Obtener el ID del material desde la primera columna de la fila seleccionada
                int idMaterial = (int) jTableMaterial.getValueAt(selectedRow, 0);
                // Almacenar el idMaterial en una variable global o mostrar en el JTextField
                idMateriales.setText(String.valueOf(idMaterial)); // Mostrar en el JTextField de ID (si tienes uno)
                

                // Rellenar los campos con los datos del material seleccionado
                jTextFieldNombre.setText(jTableMaterial.getValueAt(selectedRow, 1).toString());
                jTextFieldCategoria.setText(jTableMaterial.getValueAt(selectedRow, 2).toString());
                jTextAreaDescripcion.setText(jTableMaterial.getValueAt(selectedRow, 3).toString());
                Unidades.setText(jTableMaterial.getValueAt(selectedRow, 4).toString());
                UnidadesMedida.setText(jTableMaterial.getValueAt(selectedRow, 5).toString());
                jTextFieldUbiAlmacen.setText(jTableMaterial.getValueAt(selectedRow, 6).toString());
                jLabelFecha.setText(jTableMaterial.getValueAt(selectedRow, 7).toString());  // Fecha
                jTextFieldPrecioUNI.setText(jTableMaterial.getValueAt(selectedRow, 8).toString());
                PrecioTotal.setText(jTableMaterial.getValueAt(selectedRow, 9).toString());
            }
        }
    });

    // Agregar un ListSelectionListener para detectar la selección de filas en la tabla
    jTableMaterial.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent event) {
            // Verificar que no se esté actualizando mientras se selecciona
            if (!event.getValueIsAdjusting()) {
                // Obtener la fila seleccionada
                int selectedRow = jTableMaterial.getSelectedRow();

                // Verificar que hay una fila seleccionada
                if (selectedRow != -1) {
                    // Obtener los datos de la fila seleccionada y rellenar los campos
                    idMateriales.setText(jTableMaterial.getValueAt(selectedRow, 0).toString());
                    jTextFieldNombre.setText(jTableMaterial.getValueAt(selectedRow, 1).toString());
                    jTextFieldCategoria.setText(jTableMaterial.getValueAt(selectedRow, 2).toString());
                    jTextAreaDescripcion.setText(jTableMaterial.getValueAt(selectedRow, 3).toString());
                    Unidades.setText(jTableMaterial.getValueAt(selectedRow, 4).toString());
                    UnidadesMedida.setText(jTableMaterial.getValueAt(selectedRow, 5).toString());
                    jTextFieldUbiAlmacen.setText(jTableMaterial.getValueAt(selectedRow, 6).toString());
                    jLabelFecha.setText(jTableMaterial.getValueAt(selectedRow, 7).toString());
                    jTextFieldPrecioUNI.setText(jTableMaterial.getValueAt(selectedRow, 8).toString());
                    PrecioTotal.setText(jTableMaterial.getValueAt(selectedRow, 9).toString());
                    
                    
                }
            }
        }
    });
        
    }
        
    
    
    

    private void mostrarFechaActual() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Formatear la fecha (opcional, dependiendo del formato que desees)
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        String fechaFormateada = fechaActual.format(formatoFecha);
        // Mostrar la fecha en el JLabel
        jLabelFecha.setText(fechaFormateada);
        
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
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaterial = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCategoria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Unidades = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonEDITAR = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        idMateriales = new javax.swing.JLabel();
        jTextFieldUbiAlmacen = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldPrecioUNI = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        UnidadesMedida = new javax.swing.JTextField();
        PrecioTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BOTONPanel = new javax.swing.JButton();
        BOTONUsuarios = new javax.swing.JButton();
        BOTOONInventario = new javax.swing.JButton();
        BOTONControlHerramientas = new javax.swing.JButton();
        BOTONMAQUINAS = new javax.swing.JButton();
        BOTONInformes = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jInternalFrame1.setVisible(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Buscar");

        jButton4.setText("Buscar Fecha");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Desde");

        jLabel11.setText("Hasta");

        jTableMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Categoria", "Descripcion", "Unidades", "UNI Medida", "Ubicacion Almacen", "Fecha Compra", "Precio Unitario", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(jTableMaterial);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registro de Material");

        jLabel4.setText("Nombre");

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoria");

        jLabel6.setText("Descripcion");

        jLabel7.setText("Unidades");

        jLabel8.setText("Ubicacion Almacen");

        jButtonEDITAR.setText("Editar");
        jButtonEDITAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEDITARMouseClicked(evt);
            }
        });

        jButton6.setText("Eliminar");

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGuardarMouseClicked(evt);
            }
        });
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jLabel9.setText("ID Material");

        idMateriales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idMateriales.setText("0");

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDescripcion);

        jLabel10.setText("Fecha Recepcion");

        jLabelFecha.setText("--/--/--");

        jLabel17.setText("Precio Unitario");

        jLabel18.setText("Precio Total");

        jLabel12.setText("Unidad Medida");

        PrecioTotal.setText("Precio");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldNombre)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldCategoria)
                            .addComponent(jLabel6)
                            .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButtonEDITAR, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(Unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(UnidadesMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jTextFieldUbiAlmacen)
                            .addComponent(jTextFieldPrecioUNI)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(PrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(129, Short.MAX_VALUE)
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
                    .addComponent(jLabel9)
                    .addComponent(idMateriales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Unidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UnidadesMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUbiAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFecha)
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPrecioUNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(PrecioTotal))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEDITAR)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(350, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(370, Short.MAX_VALUE)))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        BOTONPanel.setText("PANEL");
        BOTONPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTONPanelMouseClicked(evt);
            }
        });
        BOTONPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTONPanelActionPerformed(evt);
            }
        });

        BOTONUsuarios.setText("USUARIOS");
        BOTONUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTONUsuariosMouseClicked(evt);
            }
        });

        BOTOONInventario.setText("INVENTARIO");
        BOTOONInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTOONInventarioMouseClicked(evt);
            }
        });

        BOTONControlHerramientas.setText("CONTROL HERRAMIENTAS");
        BOTONControlHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTONControlHerramientasMouseClicked(evt);
            }
        });

        BOTONMAQUINAS.setText("MÁQUINAS");
        BOTONMAQUINAS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTONMAQUINASMouseClicked(evt);
            }
        });

        BOTONInformes.setText("INFORMES");
        BOTONInformes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOTONInformesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BOTONPanel)
                .addGap(18, 18, 18)
                .addComponent(BOTONUsuarios)
                .addGap(18, 18, 18)
                .addComponent(BOTOONInventario)
                .addGap(18, 18, 18)
                .addComponent(BOTONMAQUINAS)
                .addGap(18, 18, 18)
                .addComponent(BOTONInformes)
                .addGap(18, 18, 18)
                .addComponent(BOTONControlHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BOTONPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(BOTONUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BOTOONInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BOTONControlHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BOTONInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BOTONMAQUINAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BOTONPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTONPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BOTONPanelActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGuardarMouseClicked
             try {

                    // Obtener la conexión a la base de datos
                    Connection connection = Conexion.getConnection();

                    // Crear una instancia de MaterialesDAO con la conexión
                    MaterialesDAO materialesDAO = new MaterialesDAO(connection);

                    // Obtener los valores de los campos
                    String nombreMaterial = jTextFieldNombre.getText();
                    String categoria = jTextFieldCategoria.getText();
                    String descripcion = jTextAreaDescripcion.getText();
                    float unidades = Float.parseFloat(Unidades.getText());
                    String unidadMedida = UnidadesMedida.getText();
                    String ubicacion = jTextFieldUbiAlmacen.getText();

                    // Obtener la fecha actual usando LocalDate
                    LocalDate fechaCompra = LocalDate.now();  
                    String fechaCompraString = fechaCompra.toString();  // Convertir la fecha a String en formato 'yyyy-MM-dd'

                    double precioUnitario = Double.parseDouble(jTextFieldPrecioUNI.getText());

                    // Calcular el precio total multiplicando las unidades por el precio unitario
                    double precioTotal = unidades * precioUnitario;

                    // Mostrar el precio total de forma inmediata en el JTextField correspondiente
                    PrecioTotal.setText(String.valueOf(precioTotal));

                    // Crear un objeto Material
                    Material nuevoMaterial = new Material(
                        0,
                        nombreMaterial,
                        categoria,
                        descripcion, 
                        (int) unidades,
                        unidadMedida,
                        ubicacion,
                        fechaCompraString,
                        precioUnitario,
                        precioTotal
                    );

                    // Llamar al DAO para guardar el material
                    materialesDAO.addMaterial(nuevoMaterial);

                    JOptionPane.showMessageDialog(this, "Material registrado exitosamente.");

                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al guardar el material: " + e.getMessage());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Error en el formato de unidades o precio.");
                }

    }//GEN-LAST:event_jButtonGuardarMouseClicked

    private void BOTONPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTONPanelMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
                frame.setContentPane(new Panel()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BOTONPanelMouseClicked

    private void BOTONUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTONUsuariosMouseClicked
         JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BOTONUsuariosMouseClicked

    private void BOTOONInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTOONInventarioMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BOTOONInventarioMouseClicked

    private void BOTONMAQUINASMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTONMAQUINASMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BOTONMAQUINASMouseClicked

    private void BOTONInformesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTONInformesMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Materiales()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_BOTONInformesMouseClicked

    private void BOTONControlHerramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOTONControlHerramientasMouseClicked
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
    }//GEN-LAST:event_BOTONControlHerramientasMouseClicked

    private void jButtonEDITARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEDITARMouseClicked
        
               try {
        // Obtener la conexión a la base de datos
        Connection connection = Conexion.getConnection();
        MaterialesDAO materialesDAO = new MaterialesDAO(connection);

        // Obtener los valores editados de los campos
        String nombreMaterial = jTextFieldNombre.getText();
        String categoria = jTextFieldCategoria.getText();
        String descripcion = jTextAreaDescripcion.getText();
        float unidades = Float.parseFloat(Unidades.getText());
        String unidadMedida = UnidadesMedida.getText();
        String ubicacion = jTextFieldUbiAlmacen.getText();
        
                // Obtener la fecha actual usando LocalDate
                LocalDate fechaCompra = LocalDate.now();  
                
        
        
        double precioUnitario = Double.parseDouble(jTextFieldPrecioUNI.getText());
        double precioTotal = precioUnitario * unidades;  // Calcular el precio total

        // Obtener el ID del usuario seleccionado en la tabla
            int selectedRow = jTableMaterial.getSelectedRow();
            
            if (selectedRow != -1) {
                int idMaterial = Integer.parseInt(jTableMaterial.getValueAt(selectedRow, 0).toString());
                Material materialEditado = new Material(
                idMaterial, // ID del material seleccionado
                nombreMaterial,
                categoria,
                descripcion, (int) unidades,
                unidadMedida,
                ubicacion,
                fechaCompra.toString(), // Convertir fecha a String // Convertir la fecha a String en formato 'yyyy-MM-dd'
                precioUnitario,
                precioTotal
        );

                
        // Actualizar el usuario en la base de datos
        MaterialesDAO MaterialDAO = new MaterialesDAO(Conexion.getConnection());
        materialesDAO.updateMaterial(materialEditado);
         
        JOptionPane.showMessageDialog(this, "Material actualizado exitosamente.");
        
        // Recargar la tabla para mostrar los cambios
        cargarMateriales();
    } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario en la tabla.");
            }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error en el formato de unidades o precio.");
    }   catch (SQLException ex) {
            Logger.getLogger(Materiales.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        
    }//GEN-LAST:event_jButtonEDITARMouseClicked
private void cargarMateriales() {
    try {
        // Crear una instancia de MaterialDAO
        MaterialesDAO materialDAO = new MaterialesDAO(Conexion.getConnection());

        // Obtener todos los materiales de la base de datos
        List<Material> materiales = materialDAO.getAllMateriales();

        // Llenar la tabla con los materiales
        DefaultTableModel model = (DefaultTableModel) jTableMaterial.getModel();
        model.setRowCount(0);  // Limpiar la tabla antes de agregar los materiales

        for (Material material : materiales) {
            Object[] rowData = {
                material.getIdMaterial(),
                material.getNombreMaterial(),
                material.getCategoria(),
                material.getDescripcion(),
                material.getUnidades(),
                material.getUnidadMedida(),
                material.getUbicacion(),
                material.getFechaCompra(),
                material.getPrecioUnitario(),
                material.getPrecioTotal()
            };
            model.addRow(rowData);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar materiales: -- " + e.getMessage());
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BOTONControlHerramientas;
    private javax.swing.JButton BOTONInformes;
    private javax.swing.JButton BOTONMAQUINAS;
    private javax.swing.JButton BOTONPanel;
    private javax.swing.JButton BOTONUsuarios;
    private javax.swing.JButton BOTOONInventario;
    private javax.swing.JLabel PrecioTotal;
    private javax.swing.JTextField Unidades;
    private javax.swing.JTextField UnidadesMedida;
    private javax.swing.JLabel idMateriales;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonEDITAR;
    private javax.swing.JButton jButtonGuardar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMaterial;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecioUNI;
    private javax.swing.JTextField jTextFieldUbiAlmacen;
    // End of variables declaration//GEN-END:variables

    public String getNombreMaterial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
