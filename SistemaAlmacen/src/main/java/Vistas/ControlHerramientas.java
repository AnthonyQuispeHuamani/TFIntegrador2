/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controles.HistorialMaquinasDAO;
import Controles.MaquinasDAO;
import Controles.UsuariosDAO;
import Objetos.HistorialMaquinas;
import Objetos.HistorialMaquinasDetallado;
import Objetos.Maquina;
import Objetos.Usuario;
import Recurso.Conexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeric
 */
public class ControlHerramientas extends javax.swing.JPanel {

    /**
     * Creates new form ControlHerramientas
     */
    
    int Usuario;
    
    public ControlHerramientas() {
        initComponents();
        
        

        // Texto inicial
        jLabelMensaje.setText("Esperando mensaje...");
        jLabelMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensaje.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        
        
        
        cargarUsuarios();
        cargarMaquinas();
        cargarHistorialMaquinas();
        mostrarFechaActual();
        // Iniciar la escucha para mensajes desde Python
        iniciarRecepcionMensajes();
        
        
        
                jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTableUsuarios.getSelectedRow();
                if (selectedRow != -1) {
                    int idUsuario = (int) jTableUsuarios.getValueAt(selectedRow, 0); // Suponiendo que el ID es la primera columna


        String nombreTrabajador = (String) jTableUsuarios.getValueAt(selectedRow, 1); // Nombre completo del trabajador
                    String rol = (String) jTableUsuarios.getValueAt(selectedRow, 2); // Rol

                    // Actualizar los JLabels
                    jLabelTrabajador.setText(nombreTrabajador);
                    jLabelUsuario.setText(String.valueOf(idUsuario));
                    jLabelROL.setText(rol);
                    
                }
            }
        });
/**
     * Creates new form ControlHerramientas
     */
        jTableMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTableMaquinas.getSelectedRow();
                if (selectedRow != -1) {
                    int idMaquina = (int) jTableMaquinas.getValueAt(selectedRow, 0); // Suponiendo que el ID es la primera columna
                    String nombreMaquina = (String) jTableMaquinas.getValueAt(selectedRow, 1); // Nombre de la máquina

                    // Actualizar los JLabels
                    jLabelMaquina.setText(nombreMaquina);
                    jLabelIDMaquina.setText(String.valueOf(idMaquina));
                }
            }
        });
        
        jTableSALIDAENTRADAHERRAMIENTA.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTableSALIDAENTRADAHERRAMIENTA.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Intentar obtener el ID del historial (columna 0)
                int idHistorial = Integer.parseInt(jTableSALIDAENTRADAHERRAMIENTA.getValueAt(selectedRow, 0).toString());

                // Intentar obtener el ID de la máquina (columna 2)
                int idMaquina = Integer.parseInt(jTableSALIDAENTRADAHERRAMIENTA.getValueAt(selectedRow, 1).toString());

                // Guardar los ID en variables de instancia para usarlos más tarde
                int idHistorialSeleccionado = idHistorial;
                int idMaquinaSeleccionado = idMaquina; // Asegúrate de tener una variable idMaquinaSeleccionado definida en tu clase

                // Actualizar el JComboBox con el estado actual
                String estadoActual = (String) jTableSALIDAENTRADAHERRAMIENTA.getValueAt(selectedRow, 6); // Suponiendo que el estado está en la séptima columna
                jComboBoxESTADO2.setSelectedItem(estadoActual); // Cargar el estado actual en el JComboBox
            } catch (NumberFormatException e) {
                // Si ocurre un error en la conversión, mostrar un mensaje
                
                JOptionPane.showMessageDialog(ControlHerramientas.this, "Error al obtener el ID de la máquina o historial. Verifique los datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
});
        
        
    }
    
    
    private void mostrarVentanaEmergente(String mensajeRecibido) {
    try {
        // Convertir el mensaje recibido a un número (ID)
        int idFoto = Integer.parseInt(mensajeRecibido);

        // Usar un JOptionPane para mostrar opciones
        int opcion = javax.swing.JOptionPane.showConfirmDialog(
            this, // Componente padre
            "Se ha recibido una nueva imagen con ID: " + idFoto + ".\n¿Desea visualizarla?", // Mensaje
            "Nueva imagen recibida", // Título del cuadro de diálogo
            javax.swing.JOptionPane.YES_NO_OPTION, // Opciones disponibles (Sí, No)
            javax.swing.JOptionPane.INFORMATION_MESSAGE // Icono
        );

        // Procesar la opción seleccionada
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            System.out.println("El usuario aceptó el mensaje.");

            // Lógica para cargar y mostrar la imagen
            ImageIcon imagen = obtenerImagenDesdeBaseDeDatos(idFoto);
            if (imagen != null) {
                jLabelIMAGENrecibida.setIcon(imagen);
                System.out.println("Imagen mostrada correctamente.");
            } else {
                System.err.println("No se encontró la imagen con ID: " + idFoto);
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "No se pudo cargar la imagen. Por favor, verifica la base de datos.", 
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else if (opcion == javax.swing.JOptionPane.NO_OPTION) {
            System.out.println("El usuario rechazó el mensaje.");
            // Aquí puedes implementar la lógica al rechazar
        } else {
            System.out.println("El usuario cerró la ventana.");
            // Aquí puedes manejar un cierre sin acción
        }
    } catch (NumberFormatException e) {
        System.err.println("El mensaje recibido no es un ID válido: " + mensajeRecibido);
        javax.swing.JOptionPane.showMessageDialog(this, 
            "El mensaje recibido no es un ID válido.", 
            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}
    
    //----------
    
    // Método para conectar al servidor Python y recibir un mensaje
    private void iniciarRecepcionMensajes() {
        // Crear un hilo para manejar la recepción de mensajes sin bloquear la interfaz
        Thread mensajeThread = new Thread(() -> {
            while (true) {
                try {
                    String mensaje = recibirMensajeDesdePython("localhost", 65432);
                    if (!mensaje.isEmpty()) {
                        mostrarMensaje(mensaje);
                    }
                    // Pausa de 1 segundo antes de intentar recibir otro mensaje
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Error en el hilo de recepción: " + e.getMessage());
                }
            }
        });
        mensajeThread.start();
    }

    // Método que establece la conexión al servidor Python y recibe un mensaje
    private String recibirMensajeDesdePython(String host, int port) {
        String mensaje = "";
        try (Socket socket = new Socket(host, port);
             InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            // Leer mensaje del servidorsout    
            mensaje = reader.readLine();
            System.out.println(" MENSAJE : " + mensaje);
            mostrarVentanaEmergente(mensaje);
            
        } catch (IOException e) {
            System.out.println("Error al conectar con el servidor: " + e.getMessage());
        }
        return mensaje;
    }

    // Método para mostrar el mensaje en un JLabel de la interfaz
    private void mostrarMensaje(String mensaje) {
        // Asegurarte de actualizar en el Event Dispatch Thread (EDT)
        javax.swing.SwingUtilities.invokeLater(() -> {
            jLabelMensaje.setText(mensaje); // Actualiza el JLabel con el mensaje recibido
        });
    }
    // ------------
    
    private void mostrarFechaActual() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Formatear la fecha (opcional, dependiendo del formato que desees)
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        String fechaFormateada = fechaActual.format(formatoFecha);
        // Mostrar la fecha en el JLabel
        Fecha.setText(fechaFormateada);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btn_usuarios = new javax.swing.JButton();
        btn_maquinas = new javax.swing.JButton();
        btn_materiales = new javax.swing.JButton();
        btn_informes = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSALIDAENTRADAHERRAMIENTA = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButtonEstado = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMaquinas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabelIMAGENrecibida = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabelMaquina = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelIDMaquina = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        jLabelTrabajador = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabelROL = new javax.swing.JLabel();
        jButtonASIGNAR = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaOBSERVACIONES = new javax.swing.JTextArea();
        jComboBoxESTADO = new javax.swing.JComboBox<>();
        jButtonESTADOHERRAMIENTA = new javax.swing.JButton();
        jComboBoxESTADO2 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabelMensaje = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jInternalFrame1.setVisible(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

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

        btn_maquinas.setText("MÁQUINAS");
        btn_maquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_maquinasMouseClicked(evt);
            }
        });

        btn_materiales.setText("MATERIALES");
        btn_materiales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_materialesMouseClicked(evt);
            }
        });

        btn_informes.setText("INFORMES");
        btn_informes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_informesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_usuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_maquinas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_materiales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_informes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_maquinas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_materiales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_informes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jTextField1.setText("Usuarios");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Buscar");

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "ROL", "Capacitacion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);
        if (jTableUsuarios.getColumnModel().getColumnCount() > 0) {
            jTableUsuarios.getColumnModel().getColumn(0).setMinWidth(20);
            jTableUsuarios.getColumnModel().getColumn(0).setMaxWidth(20);
            jTableUsuarios.getColumnModel().getColumn(1).setResizable(false);
            jTableUsuarios.getColumnModel().getColumn(2).setMinWidth(80);
            jTableUsuarios.getColumnModel().getColumn(2).setMaxWidth(80);
            jTableUsuarios.getColumnModel().getColumn(3).setMinWidth(85);
            jTableUsuarios.getColumnModel().getColumn(3).setMaxWidth(85);
            jTableUsuarios.getColumnModel().getColumn(4).setMinWidth(90);
            jTableUsuarios.getColumnModel().getColumn(4).setMaxWidth(90);
        }

        jTableSALIDAENTRADAHERRAMIENTA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID Maquina", "Nombre Trab.", "ROL", "Capacitación", "Maquina Asig.", "Numero Serie", "Estado"
            }
        ));
        jScrollPane2.setViewportView(jTableSALIDAENTRADAHERRAMIENTA);
        if (jTableSALIDAENTRADAHERRAMIENTA.getColumnModel().getColumnCount() > 0) {
            jTableSALIDAENTRADAHERRAMIENTA.getColumnModel().getColumn(0).setMinWidth(20);
            jTableSALIDAENTRADAHERRAMIENTA.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("INVENTARIO SACADO DE:");

        jButtonEstado.setText("ESTADO");
        jButtonEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEstadoMouseClicked(evt);
            }
        });
        jButtonEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstadoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("EVALUAR HERRAMIENTA");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("USUARIO SELECCIONADO:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("ROL:");

        jTableMaquinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre Hrr.", "Marca", "Numero Serie", "Estado", "Situacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableMaquinas);
        if (jTableMaquinas.getColumnModel().getColumnCount() > 0) {
            jTableMaquinas.getColumnModel().getColumn(0).setMinWidth(20);
            jTableMaquinas.getColumnModel().getColumn(0).setMaxWidth(20);
            jTableMaquinas.getColumnModel().getColumn(1).setResizable(false);
            jTableMaquinas.getColumnModel().getColumn(2).setMinWidth(80);
            jTableMaquinas.getColumnModel().getColumn(2).setMaxWidth(80);
            jTableMaquinas.getColumnModel().getColumn(3).setMinWidth(85);
            jTableMaquinas.getColumnModel().getColumn(3).setMaxWidth(85);
            jTableMaquinas.getColumnModel().getColumn(4).setMinWidth(90);
            jTableMaquinas.getColumnModel().getColumn(4).setMaxWidth(90);
            jTableMaquinas.getColumnModel().getColumn(5).setMinWidth(80);
            jTableMaquinas.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jLabel5.setText("Trabajador");

        jLabelIMAGENrecibida.setBackground(new java.awt.Color(102, 102, 102));
        jLabelIMAGENrecibida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIMAGENrecibida.setText("FOTO");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("MAQUINA SELECCIONADA:");

        jLabelMaquina.setText("Maquina");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("ID:");

        jLabelIDMaquina.setText("ID");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("TRABAJADOR SELECCIONADO:");

        jLabel18.setText("FECHA ASIGNADA:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Obseraciones");

        Fecha.setText("--/--/--");

        jLabelTrabajador.setText("Trabajador");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("ROL:");

        jLabelROL.setText("Rol");

        jButtonASIGNAR.setText("Asignar");
        jButtonASIGNAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonASIGNARMouseClicked(evt);
            }
        });
        jButtonASIGNAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonASIGNARActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("ID:");

        jLabelUsuario.setText("ID");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("SE VA A :");

        jTextAreaOBSERVACIONES.setColumns(20);
        jTextAreaOBSERVACIONES.setRows(5);
        jScrollPane4.setViewportView(jTextAreaOBSERVACIONES);

        jComboBoxESTADO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBoxESTADO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entregar", "Reparar", "Mantenimiento" }));

        jButtonESTADOHERRAMIENTA.setText("ESTADO");
        jButtonESTADOHERRAMIENTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonESTADOHERRAMIENTAMouseClicked(evt);
            }
        });
        jButtonESTADOHERRAMIENTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonESTADOHERRAMIENTAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonASIGNAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addComponent(jComboBoxESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonESTADOHERRAMIENTA))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelROL, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabelMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(17, 17, 17)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIDMaquina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMaquina)
                    .addComponent(jLabel15)
                    .addComponent(jLabelIDMaquina)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabelTrabajador)
                    .addComponent(jLabel24)
                    .addComponent(jLabelUsuario))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabelROL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fecha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBoxESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonESTADOHERRAMIENTA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonASIGNAR, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jComboBoxESTADO2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxESTADO2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entregado", " " }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("RECEPCION MENSAJE");

        jLabelMensaje.setText("...");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("DEVOLUCIÓN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabelIMAGENrecibida, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxESTADO2, 0, 126, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(1163, 1163, 1163)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(66, 66, 66)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBoxESTADO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabelMensaje)
                            .addComponent(jLabel11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelIMAGENrecibida, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel19)
                    .addContainerGap(539, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTROL HERRAMIENTAS \"SALIDA & ENTRADA\"");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jInternalFrame1.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1315, Short.MAX_VALUE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usuariosMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            //frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_btn_usuariosMouseClicked

    private void btn_maquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maquinasMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            System.out.println("Bandera 5");
            frame.setSize(1500, 810);
            frame.setContentPane(new Maquinas()); // Cambiar al nuevo panel
            //frame.setContentPane(new Usuarios()); // Cambiar al nuevo panel
            //frame.setContentPane(new Informes()); // Cambiar al nuevo panel
            //frame.setContentPane(new Inventario()); // Cambiar al nuevo panel
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
            System.out.println("Bandera 5");
            frame.revalidate(); // Actualizar la interfaz
    }//GEN-LAST:event_btn_informesMouseClicked

    private void jButtonEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEstadoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonASIGNARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonASIGNARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonASIGNARActionPerformed

    private void jButtonASIGNARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonASIGNARMouseClicked
            try {
                // Validar que los campos no estén vacíos
                String idMaquinaText = jLabelIDMaquina.getText();
                String idUsuarioText = jLabelUsuario.getText();

                if (idMaquinaText.isEmpty() || idUsuarioText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor seleccione un usuario y una máquina.");
                    return; // Salir si no hay selección
                }

                int idMaquina = Integer.parseInt(idMaquinaText);
                int idUsuario = Integer.parseInt(idUsuarioText);

                // Obtener estado según selección
                String estado = "";
                switch ((String) jComboBoxESTADO.getSelectedItem()) {
                    case "Entregar":
                        estado = "Entregado";
                        break;
                    case "Reparar":
                        estado = "Reparación";
                        break;
                    case "Mantenimiento":
                        estado = "Mantenimiento";
                        break;
                    default:
                        throw new SQLException("Estado no válido.");
                }
System.out.println("   8  ");
                LocalDate fechaCompra = LocalDate.now();
                String fechaCompraString = fechaCompra.toString();  // Convertir la fecha a String en formato 'yyyy-MM-dd'

                Date fechaMovimiento = new Date(System.currentTimeMillis()); // Utiliza la fecha actual en formato SQL

                String observacion = jTextAreaOBSERVACIONES.getText();

                // Obtener el id_foto desde jLabelMensaje
                Integer idFoto = null;
                if (!jLabelMensaje.getText().isEmpty()) {
                    idFoto = Integer.parseInt(jLabelMensaje.getText());
                }

                // Manejar la conexión con try-with-resources
                try (Connection connection = Conexion.getConnection()) {
                    HistorialMaquinasDAO historialDAO = new HistorialMaquinasDAO(connection);
System.out.println("   9  ");
                    // Verificar si la máquina puede ser asignada
                    if (!historialDAO.verificarSituacionMaquina(idMaquina)) {
System.out.println("   9.1  ");
                        JOptionPane.showMessageDialog(this, "La máquina no ha sido entregada. No puede ser asignada.");
                        return; // Salir si la máquina no está entregada
                    }

                    // Guardar el historial
                    historialDAO.agregarHistorialMaquina(idMaquina, idUsuario, fechaMovimiento, estado, observacion, idFoto);

System.out.println("   10  " + idMaquina);
    
                    ESTADOuser(idMaquina);
                    // Actualizar estado de la máquina a 'Entregado'
                    // Actualizar estado de la máquina a 'Entregado'historialDAO.actualizarSituacionMaquinaNOENTREGADA(idMaquina);
System.out.println("   10.1  ");
                    JOptionPane.showMessageDialog(this, "Historial de máquina agregado exitosamente.");
                }
System.out.println("   11  ");
                // Recargar datos
                cargarHistorialMaquinas();
System.out.println("   12  ");
                cargarMaquinas();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("   13 error  ");
                JOptionPane.showMessageDialog(this, "Error al agregar historial !!! :¨v " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una imagen a guardar");
            }
    }//GEN-LAST:event_jButtonASIGNARMouseClicked

    private void jButtonEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEstadoMouseClicked
        
            int row = jTableSALIDAENTRADAHERRAMIENTA.getSelectedRow();
    if (row >= 0) {
        try {
            // Obtener los valores seleccionados
            int idHistorial = Integer.parseInt(jTableSALIDAENTRADAHERRAMIENTA.getValueAt(row, 0).toString()); // Obtener ID del historial
            int idMaquina = Integer.parseInt(jTableSALIDAENTRADAHERRAMIENTA.getValueAt(row, 1).toString()); // Obtener ID de la máquina
            String nuevoEstado = (String) jComboBoxESTADO2.getSelectedItem(); // Obtener nuevo estado del ComboBox

            System.out.println("TRY");
            System.out.println("<<" + idHistorial);
            System.out.println("<<" + idMaquina);
            System.out.println("<<" + nuevoEstado);
            try {
                // Instanciar el DAO para el historial
                HistorialMaquinasDAO historialDAO = new HistorialMaquinasDAO(Conexion.getConnection());
                System.out.println("updateEstadoHistorial");
                // Actualizar el estado del historial
                historialDAO.updateEstadoHistorial(idHistorial, nuevoEstado); 
                System.out.println("actualizarSituacionMaquina");
                // Actualizar la situación de la máquina
                  historialDAO.actualizarSituacionMaquina(idMaquina); 

                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Estado y situación actualizados con éxito.");
                
                // Volver a cargar las tablas
                System.out.println("cargarHistorialMaquinas");
                cargarHistorialMaquinas();
                System.out.println("cargarMaquinas");
                cargarMaquinas(); // Cargar nuevamente la lista de máquinas

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al actualizar el estado: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener los IDs. Verifique los datos en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
        
else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para actualizar.");
    }

        
    }//GEN-LAST:event_jButtonEstadoMouseClicked

    private void jButtonESTADOHERRAMIENTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonESTADOHERRAMIENTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonESTADOHERRAMIENTAActionPerformed

    private void jButtonESTADOHERRAMIENTAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonESTADOHERRAMIENTAMouseClicked
        try {
            // Extraer el ID de la máquina desde el componente que lo contiene
            String idMaquinaText = jLabelIDMaquina.getText();

            // Validar que el ID no esté vacío
            if (idMaquinaText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una máquina.");
                return; // Salir si no se selecciona una máquina
            }

            // Convertir el ID a entero
            int idMaquina = Integer.parseInt(idMaquinaText);

            // Manejar la conexión y actualizar la situación
            try (Connection connection = Conexion.getConnection()) {
                HistorialMaquinasDAO historialDAO = new HistorialMaquinasDAO(connection);

                // Actualizar la situación de la máquina
                historialDAO.actualizarSituacionMaquinaNOENTREGADA(idMaquina);

                // Notificar éxito
                JOptionPane.showMessageDialog(this, "La situación de la máquina ha sido actualizada a 'No entregado'.");
                cargarMaquinas();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar la situación: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID de la máquina no es válido.");
        }
    }//GEN-LAST:event_jButtonESTADOHERRAMIENTAMouseClicked
    private void ESTADOuser(int a) {
        try {
            

            // Manejar la conexión y actualizar la situación
            try (Connection connection = Conexion.getConnection()) {
                HistorialMaquinasDAO historialDAO = new HistorialMaquinasDAO(connection);

                // Actualizar la situación de la máquina
                historialDAO.actualizarSituacionMaquinaNOENTREGADA(a);

                // Notificar éxito
                JOptionPane.showMessageDialog(this, "La situación de la máquina ha sido actualizada a 'No entregado'.");
                cargarMaquinas();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar la situación: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID de la máquina no es válido.");
        }
    }
    
    private void cargarUsuarios() {
        try {
            // Crear una instancia de UsuariosDAO
            UsuariosDAO usuariosDAO = new UsuariosDAO(Conexion.getConnection());

            // Obtener todos los usuarios de la base de datos
            List<Usuario> usuarios = usuariosDAO.getAllUsuarios();

            // Llenar la tabla con los usuarios
            DefaultTableModel model = (DefaultTableModel) jTableUsuarios.getModel();
            model.setRowCount(0);  // Limpiar la tabla antes de agregar los usuarios

            for (Usuario usuario : usuarios) {
                Object[] rowData = {
                    usuario.getIdUsuario(), // ID del usuario
                    usuario.getPrimerNombre() + " " + usuario.getSegundoNombre() + " " +
                    usuario.getApellidoPaterno() + " " + usuario.getApellidoMaterno(), // Nombre completo
                    usuario.getRol(),         // Rol
                    usuario.getEstadoCapacitacion(), // Capacitación
                    usuario.getTelefonoPersonal() // Teléfono
                };
                model.addRow(rowData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + e.getMessage());
        }
    }

    private void cargarMaquinas() {
        try {
            // Obtener la conexión a la base de datos
            Connection connection = Conexion.getConnection();
            MaquinasDAO maquinaDAO = new MaquinasDAO(connection);

    // Obtener todas las máquinas de la base de datos
            List<Maquina> maquinas = maquinaDAO.getAllMaquinas();

            // Llenar la tabla con los datos de las máquinas


        DefaultTableModel model = (DefaultTableModel) jTableMaquinas.getModel();
            model.setRowCount(0);  // Limpiar la tabla antes de agregar las máquinas

            for (Maquina maquina : maquinas) {
                Object[] rowData = {
                    maquina.getIdMaquina(), // ID de la máquina
                    maquina.getNombreHerramienta(),
                    maquina.getMarca(),
                    maquina.getNumeroSerie(),
                    maquina.getEstadoHerramienta(),
                    maquina.getSituacion()
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar las máquinas: " + e.getMessage());
        }
    }
    
    private void cargarHistorialMaquinas() {
        try {
            // Obtener la conexión a la base de datos
            Connection connection = Conexion.getConnection();
            HistorialMaquinasDAO historialDAO = new HistorialMaquinasDAO(connection);

            // Obtener el historial de máquinas completo
            List<HistorialMaquinasDetallado> historialCompleto = historialDAO.getAllHistorialMaquinasCompleto();

            // Llenar la tabla con los datos del historial
            DefaultTableModel model = (DefaultTableModel) jTableSALIDAENTRADAHERRAMIENTA.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar los datos

            for (HistorialMaquinasDetallado historial : historialCompleto) {
                Object[] rowData = {
                    historial.getIdHistorial(),
                    historial.getIdMaquina(),
                    historial.getNombreTrabajador(),
                    historial.getRol(),
                    historial.getCapacitacion(),
                    historial.getMaquinaAsignada(),
                    historial.getNumeroSerie(),
                    historial.getEstadoHistorial()
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "( cargarHistorialMaquinas )Error al cargar el historial de máquinas: " + e.getMessage());
        }
    }
    
    // Método para recibir el mensaje de Python
    private String recibirMensaje() {
        String mensajeRecibido = "";
        try (Socket socket = new Socket("localhost", 65433); // Conectar al servidor Python
             DataInputStream in = new DataInputStream(socket.getInputStream())) {

            // Recibir el mensaje del servidor Python
            mensajeRecibido = in.readUTF();
            System.out.println("Mensaje recibido: " + mensajeRecibido);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mensajeRecibido;
    }
    
/**
     * Creates new form ControlHerramientas
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fecha;
    private javax.swing.JButton btn_informes;
    private javax.swing.JButton btn_maquinas;
    private javax.swing.JButton btn_materiales;
    private javax.swing.JButton btn_usuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonASIGNAR;
    private javax.swing.JButton jButtonESTADOHERRAMIENTA;
    private javax.swing.JButton jButtonEstado;
    private javax.swing.JComboBox<String> jComboBoxESTADO;
    private javax.swing.JComboBox<String> jComboBoxESTADO2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelIDMaquina;
    private javax.swing.JLabel jLabelIMAGENrecibida;
    private javax.swing.JLabel jLabelMaquina;
    private javax.swing.JLabel jLabelMensaje;
    private javax.swing.JLabel jLabelROL;
    private javax.swing.JLabel jLabelTrabajador;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableMaquinas;
    private javax.swing.JTable jTableSALIDAENTRADAHERRAMIENTA;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextArea jTextAreaOBSERVACIONES;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    private ImageIcon obtenerImagenDesdeBaseDeDatos(int idFoto) {
    // Consulta para obtener la imagen desde la base de datos
    String consulta = "SELECT foto_capture FROM fotos_historial WHERE id_foto = ?";

    // Usar la clase Conexion para establecer la conexión
    Connection conexion = null;
    try {
        conexion = Conexion.getConnection();
        if (conexion != null) {
            try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
                // Configurar el parámetro de la consulta
                preparedStatement.setInt(1, idFoto);

                // Ejecutar la consulta
                ResultSet resultSet = preparedStatement.executeQuery();

                // Procesar el resultado
                if (resultSet.next()) {
                    // Obtener los bytes del BLOB
                    byte[] bytesImagen = resultSet.getBytes("foto_capture");

                    // Convertir los bytes en un ImageIcon
                    if (bytesImagen != null && bytesImagen.length > 0) {
                        return new ImageIcon(bytesImagen);
                    }
                }
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al consultar la base de datos: " + e.getMessage());
    } finally {
        // Cerrar la conexión utilizando la clase Conexion
        Conexion.closeConnection(conexion);
    }

    return null; // Retorna null si no se encontró la imagen o hubo un error
}
}
