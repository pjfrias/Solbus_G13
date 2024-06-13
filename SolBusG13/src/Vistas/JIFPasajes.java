package Vistas;

import Conexion.ColectivoData;
import Conexion.HorarioData;
import Conexion.PasajeData;
import Conexion.PasajeroData;
import Conexion.RutaData;
import Entidades.Colectivo;
import Entidades.Horario;
import Entidades.Pasaje;
import Entidades.Pasajero;
import Entidades.Ruta;
import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class JIFPasajes extends javax.swing.JInternalFrame {

    private Pasajero pasajero;
    private PasajeroData pasajeroDat = new PasajeroData();
    private Ruta ruta;
    private RutaData rutaDat = new RutaData();
    private Horario horario;
    private Colectivo colectivo;
    private ColectivoData coleDat = new ColectivoData();
    private Pasaje pasaje;
    private PasajeData pasajeDat = new PasajeData();
    private HorarioData horarioDat = new HorarioData();
    private DefaultTableModel modelo = new DefaultTableModel();
    private Date hoy;
    private int capacidad, lugaresOcupados;
    private ArrayList<Pasaje> pasajes = new ArrayList<>();
    private Double precio = 0d;
        
    
    
    public JIFPasajes() {
        initComponents();
        hoy = Date.valueOf(LocalDate.now());
        jTHoy.setText(Date.valueOf(LocalDate.now()).toString());
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nro Asiento");
        
        jTPasajeros.setModel(modelo);
        cargarRutas();
        cargarHorarios();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPPasajero = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTTelefono = new javax.swing.JTextField();
        jTEmail = new javax.swing.JTextField();
        jBBuscarPasajero = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jCBRuta = new javax.swing.JComboBox<>();
        jTHoy = new javax.swing.JTextField();
        jCBHorarios = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jBVerColectivo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTMatricula = new javax.swing.JTextField();
        jTModelo = new javax.swing.JTextField();
        jTMarca = new javax.swing.JTextField();
        jTCapaciad = new javax.swing.JTextField();
        jTLugaresDisponibles = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPasajeros = new javax.swing.JTable();
        jBNueva = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jCBAsiento = new javax.swing.JComboBox<>();
        jBVerPasajeros = new javax.swing.JButton();
        jTPrecio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion de pasajes");
        setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Venta y gestion de Pasajes");

        jPPasajero.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del pasajero"));

        jLabel2.setText("DNI");

        jLabel3.setText("Nombre");

        jTNombre.setEditable(false);

        jLabel4.setText("Apellido");

        jTApellido.setEditable(false);

        jLabel5.setText("Email");

        jLabel6.setText("Telefono");

        jTTelefono.setEditable(false);

        jTEmail.setEditable(false);

        jBBuscarPasajero.setText("Buscar Pasajero");
        jBBuscarPasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarPasajeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPPasajeroLayout = new javax.swing.GroupLayout(jPPasajero);
        jPPasajero.setLayout(jPPasajeroLayout);
        jPPasajeroLayout.setHorizontalGroup(
            jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPasajeroLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPPasajeroLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPPasajeroLayout.createSequentialGroup()
                        .addGroup(jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTNombre)
                            .addComponent(jTApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPPasajeroLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTTelefono))
                    .addComponent(jTEmail)
                    .addGroup(jPPasajeroLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBBuscarPasajero)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPPasajeroLayout.setVerticalGroup(
            jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPasajeroLayout.createSequentialGroup()
                .addGroup(jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPPasajeroLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel2))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPasajeroLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBBuscarPasajero)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPasajeroLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3))
                    .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Origen - Destino"));

        jCBRuta.setName(""); // NOI18N
        jCBRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRutaActionPerformed(evt);
            }
        });

        jTHoy.setEditable(false);

        jCBHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBHorariosActionPerformed(evt);
            }
        });

        jLabel8.setText("Horario");

        jBVerColectivo.setText("Ver Colectivo");
        jBVerColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerColectivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCBRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jCBHorarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jTHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBVerColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jCBRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVerColectivo)
                    .addComponent(jTHoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidad de traslado"));

        jLabel11.setText("Marca");

        jLabel12.setText("Modelo");

        jLabel13.setText("Matricula");

        jLabel14.setText("Capacidad");

        jLabel15.setText("Lugares disponibles");

        jTMatricula.setEnabled(false);

        jTModelo.setEnabled(false);

        jTMarca.setEnabled(false);

        jTCapaciad.setEnabled(false);

        jTLugaresDisponibles.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTMatricula)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12)
                        .addComponent(jTMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTLugaresDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTCapaciad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jTModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCapaciad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTLugaresDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTPasajeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTPasajeros.setEnabled(false);
        jScrollPane1.setViewportView(jTPasajeros);

        jBNueva.setText("Nueva Venta");
        jBNueva.setEnabled(false);
        jBNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevaActionPerformed(evt);
            }
        });

        jBBuscar.setText("Buscar Pasaje");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBBorrar.setText("Borrar");
        jBBorrar.setEnabled(false);
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        jLabel7.setText("Elija un asiento");

        jBVerPasajeros.setText("Ver Pasajeros");
        jBVerPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerPasajerosActionPerformed(evt);
            }
        });

        jTPrecio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPrecioActionPerformed(evt);
            }
        });

        jLabel10.setText("PRECIO PASAJE ");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("$");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBVerPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jCBAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(57, 57, 57))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVerPasajeros)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jCBAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jBNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPPasajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPPasajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNueva)
                    .addComponent(jBBuscar)
                    .addComponent(jBBorrar)
                    .addComponent(jBGuardar)
                    .addComponent(jBSalir))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBVerPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerPasajerosActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
        llenarListaPasajeros();
    }//GEN-LAST:event_jBVerPasajerosActionPerformed

    private void jBBuscarPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarPasajeroActionPerformed
        // TODO add your handling code here:
        Pattern patronDNI = Pattern.compile("^\\d{1,10}$");
        
        if (!jTDni.getText().isEmpty()){
        
            Matcher matcher = patronDNI.matcher(jTDni.getText());
            if(matcher.matches()){
                pasajero = pasajeroDat.bucarPasajero(Integer.parseInt(jTDni.getText()));
                if(pasajero == null) JOptionPane.showMessageDialog(this, "El pasajero no se encuentra registrado, ingreselo desde el menu Pasajero");
                else{
                    jTDni.setBorder(new LineBorder(Color.BLACK, 2));
                    
                    jTApellido.setText(pasajero.getApellido());
                    jTNombre.setText(pasajero.getNombre());
                    jTEmail.setText(pasajero.getCorreo());
                    jTTelefono.setText(pasajero.getTelefono());
                }
            }else {
                jTDni.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(this, "Debe ingresar un nro de documento valido");
                
                        
                        }
        }
    }//GEN-LAST:event_jBBuscarPasajeroActionPerformed

    private void jCBRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRutaActionPerformed
        // TODO add your handling code here:
        jCBHorarios.removeAllItems();
        limpiarVariablesColectivo();
        limpiarCamposColectivo();
        ruta = (Ruta) jCBRuta.getSelectedItem();
        limpiarTabla();
        cargarHorarios();
    }//GEN-LAST:event_jCBRutaActionPerformed

    private void jCBHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBHorariosActionPerformed
        // TODO add your handling code here:
        limpiarVariablesColectivo();
        limpiarCamposColectivo();
        horario = (Horario) jCBHorarios.getSelectedItem();
        
        
            
    }//GEN-LAST:event_jCBHorariosActionPerformed

    private void jBNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevaActionPerformed
        // TODO add your handling code here:
        hoy = Date.valueOf(LocalDate.now());
        resetVista();
    }//GEN-LAST:event_jBNuevaActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        hoy = Date.valueOf(LocalDate.now());
        int nroPasaje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del pasaje a buscar"));
        pasaje = pasajeDat.buscarPasajePorId(nroPasaje);
        
        
        //JOptionPane.showMessageDialog(this, "Fecha actual: "+hoy+" - Fecha pasaje: "+pasaje.getFechaViaje());
        if (pasaje != null) {
            if(!pasaje.getFechaViaje().isEqual(hoy.toLocalDate())){
                JOptionPane.showMessageDialog(this, "El pasaje tiene fecha ya vencida, no puede modificarse");
                jBGuardar.setEnabled(false);
                jBBorrar.setEnabled(false);
            }else {
                jBGuardar.setEnabled(true);
                jBBorrar.setEnabled(true);
            }
        
        hoy = Date.valueOf(pasaje.getFechaViaje());
            pasajero = pasaje.getPasajero();
            colectivo = pasaje.getColectivo();
            ruta = pasaje.getRutas();
            horario = horarioDat.buscarHorariosPasaje(nroPasaje);
            precio = pasaje.getPrecio();
        }
        
        if (pasaje != null && pasajero != null && colectivo != null && ruta != null && horario != null) {
            
            cargarDatosPasajero();
            cargarDatosColectivo();
            jTPrecio.setText(precio.toString());
            jBNueva.setEnabled(true);
            jBBorrar.setEnabled(true);
            cargarDatosRuta();
            cargarDatosHorario();
            jTPrecio.setText(precio.toString());
            
        }else JOptionPane.showMessageDialog(this, "No se han podido cargar todos los datos del pasaje");
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        // TODO add your handling code here:
        if (pasaje != null) {
            pasajeDat.eliminarPasaje(pasaje.getIdPasaje());
        }
        resetVista();
    }//GEN-LAST:event_jBBorrarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        if (jCBAsiento.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No se puede grabar la informacion, busque un asiento disponible para la venta");
            return;
        }
        if (pasaje == null) {
            pasaje = new Pasaje(pasajero, colectivo, ruta, hoy.toLocalDate(), horario.getSalida(), (Integer) jCBAsiento.getSelectedItem(), precio, true);
            pasajeDat.guardarPasaje(pasaje);
        }
        else{
            pasaje = new Pasaje(pasaje.getIdPasaje(), pasajero, colectivo, ruta, pasaje.getFechaViaje(), horario.getSalida(), (Integer) jCBAsiento.getSelectedItem(), precio, true);
            pasajeDat.modificarPasaje(pasaje);
        }
        resetVista();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jTPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPrecioActionPerformed
        // TODO add your handling code here:
        validarPrecio();
    }//GEN-LAST:event_jTPrecioActionPerformed

    private void jBVerColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerColectivoActionPerformed
        // TODO add your handling code here:
        //LLAMAR A LA FUNCION QUE ME DEVUELVE EL COLECTIVO
        if (horario != null) {
            colectivo = coleDat.buscarColectivoPasajesVendidos(horario, hoy);

            if(colectivo != null){
                llenarDatosColectivo();
            }else{
                buscarColectivoVacio();
                if (colectivo != null) {
                    llenarDatosColectivo();
                }//else limpiarCamposColectivo();
            }
        }//else limpiarCamposColectivo();
    }//GEN-LAST:event_jBVerColectivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBBuscarPasajero;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBNueva;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jBVerColectivo;
    private javax.swing.JButton jBVerPasajeros;
    private javax.swing.JComboBox<Integer> jCBAsiento;
    private javax.swing.JComboBox<Horario> jCBHorarios;
    private javax.swing.JComboBox<Ruta> jCBRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPPasajero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTCapaciad;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTHoy;
    private javax.swing.JTextField jTLugaresDisponibles;
    private javax.swing.JTextField jTMarca;
    private javax.swing.JTextField jTMatricula;
    private javax.swing.JTextField jTModelo;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTable jTPasajeros;
    private javax.swing.JTextField jTPrecio;
    private javax.swing.JTextField jTTelefono;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos(){
    jBBorrar.setEnabled(false);
    jBBuscar.setEnabled(true);
    jBBuscarPasajero.setEnabled(true);
    jBGuardar.setEnabled(false);
    jBNueva.setEnabled(true);
    jCBRuta.setSelectedIndex(0);
    jCBRuta.setSelectedIndex(0);
    jTHoy.setText(Date.valueOf(LocalDate.now()).toString());
    jTApellido.setText("");
    jTCapaciad.setText("");
    jTDni.setText("");
    jTEmail.setText("");
    jTLugaresDisponibles.setText("");
    jTMarca.setText("");
    jTMatricula.setText("");
    jTModelo.setText("");
    jTNombre.setText("");
    jTTelefono.setText("");
    limpiarTabla();
    limpiarCamposColectivo();
    }
    
    private void limpiarTabla(){
        for (int i = modelo.getRowCount()-1; i >= 0 ; i--) {
            modelo.removeRow(i);
        }
    }
    
    private void buscarColectivoVacio(){
        if(coleDat.verColectivosVacios(hoy).size() > 0){
            colectivo = coleDat.verColectivosVacios(hoy).get(0);
            jBGuardar.setEnabled(true);
            
        }else{
            JOptionPane.showMessageDialog(this, "No hay colectivos disponibles para este viaje por hoy");
            jBGuardar.setEnabled(false);
           // limpiarCamposColectivo();
        }
    }
    
    private void limpiarCamposColectivo(){
        jTMatricula.setText("");
        jTMarca.setText("");
        jTModelo.setText("");
        jTCapaciad.setText("");
        jTLugaresDisponibles.setText("");
        jCBAsiento.removeAllItems();
        jCBAsiento.setEnabled(false);
    }
    
    private void llenarDatosColectivo(){
        lugaresOcupados = coleDat.verLugaresOcupados(colectivo, horario, hoy);
        capacidad = colectivo.getCapacidad();
        jTMatricula.setText(colectivo.getMatricula());
        jTMarca.setText(colectivo.getMarca());
        jTModelo.setText(colectivo.getModelo());
        jTCapaciad.setText(""+capacidad);
        jTLugaresDisponibles.setText(""+(colectivo.getCapacidad() - lugaresOcupados));
        jBBuscarPasajero.setEnabled(true);
        
        jCBAsiento.setEnabled(true);
        llenarAsientosDisponibles();
    }
    
    private void llenarListaPasajeros(){
        pasajes = coleDat.verPasajerosAsientos(colectivo, horario, hoy);
        Collections.sort(pasajes, (p1, p2) -> Integer.compare(p1.getAsiento(), p2.getAsiento()));
        
        if(pasajes.size()>0){

            for (Pasaje pasa : pasajes) {
                modelo.addRow(new Object[]{pasa.getPasajero().getDni(),
                                            pasa.getPasajero().getApellido(),
                                            pasa.getPasajero().getNombre(),
                                            pasa.getAsiento()});
            }
        }
    }
    
    private void llenarAsientosDisponibles(){
        pasajes = coleDat.verPasajerosAsientos(colectivo, horario, hoy);
        Collections.sort(pasajes, (p1, p2) -> Integer.compare(p1.getAsiento(), p2.getAsiento()));
        
        if (colectivo.getCapacidad() > lugaresOcupados) {
            //LLENAR jCBASIENTOS CON LOS ASIENTOS LIBRES
            jCBAsiento.removeAllItems();
            for (int i = 0; i < capacidad; i++) {
                jCBAsiento.addItem(i+1);
            }
            if (pasajes != null) {
                //JOptionPane.showMessageDialog(this, "Ya se han ocupado "+pasajes.size()+" Asientos");
                if(pasajes.size() > 0){
                    for (Pasaje pas : pasajes) {
                        jCBAsiento.removeItem(pas.getAsiento());
                    }
                }
            }
            Ruta temp = (Ruta) jCBRuta.getSelectedItem();
            if(pasaje != null)
                if(pasaje.getRutas().getIdRuta() == temp.getIdRuta()){
                    jCBAsiento.addItem(pasaje.getAsiento());
                }else jCBAsiento.setEnabled(true);
        }else {
            Ruta temp = (Ruta) jCBRuta.getSelectedItem();
            if(pasaje != null){
                if(pasaje.getRutas().getIdRuta() != temp.getIdRuta()){
                    JOptionPane.showMessageDialog(this, "Ya no hay lugares disponibles para este viaje");
                    jCBAsiento.setEnabled(false);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Ya no hay lugares disponibles para este viaje");
                jCBAsiento.setEnabled(false);
            }
        }
    }
    
    private void cargarRutas(){
        if(ruta ==null){
            jCBRuta.removeAllItems();
            ArrayList<Ruta> rutas = rutaDat.buscarRutas();
            if (rutas.size()>0) {
                for (Ruta ruta1 : rutas) {
                    jCBRuta.addItem(ruta1);
                }
                jCBRuta.setSelectedIndex(0);
                ruta = (Ruta) jCBRuta.getSelectedItem();
            }else JOptionPane.showMessageDialog(this,"No hay rutas cargadas en la base de datos");
        }else {
            for (int i = 0; i < jCBRuta.getItemCount(); i++) {
                if (jCBRuta.getItemAt(i).getIdRuta() == ruta.getIdRuta()) {
                    jCBRuta.setSelectedIndex(i);
                }
            }
        }
    }
    
    private void cargarHorarios(){
        if (ruta != null) {
            ArrayList<Horario> horarios = horarioDat.buscarHorariosRuta(ruta);
            if (horarios.size()>0) {
                for (Horario hor : horarios) {
                    jCBHorarios.addItem(hor);
                }
            if(horario == null)
                horario = jCBHorarios.getItemAt(0);
            else jCBHorarios.setSelectedItem(horario);
            }else JOptionPane.showMessageDialog(this,"No hay Horarios cargados para esta ruta en la base de datos");
        }
    }
    
    private void limpiarVariablesColectivo(){
        colectivo = null;
        pasajes = null;
        capacidad = 0;
        lugaresOcupados = 0;
    }
    
    private void cargarDatosPasajero(){
        jTApellido.setText(pasaje.getPasajero().getApellido());
        jTNombre.setText(pasaje.getPasajero().getNombre());
        jTDni.setText(pasaje.getPasajero().getDni());
        jTEmail.setText(pasaje.getPasajero().getCorreo());
        jTTelefono.setText(pasaje.getPasajero().getTelefono());
    }
    
    private void cargarDatosRuta(){
        cargarRutas();
        jCBRuta.setSelectedItem(ruta);
        }
    
    private void cargarDatosHorario(){
        cargarHorarios();
        jCBHorarios.setSelectedItem(horario);
    
    }
    
    private void cargarDatosColectivo(){
        llenarDatosColectivo();
    }
    
    private void validarPrecio(){
        Pattern patronPrecio = Pattern.compile("^(?:0|[1-9]\\d{0,6}|1000000)(?:\\.\\d{1,2})?$");
        
        if (!jTPrecio.getText().isEmpty()){
        
            Matcher matcher = patronPrecio.matcher(jTPrecio.getText());
            if(matcher.matches()){
                precio = Double.parseDouble(jTPrecio.getText());
            }else JOptionPane.showMessageDialog(this, "El precio no es valido");
        }
    }
    
    private void resetVista(){
        limpiarCampos();
        limpiarVariablesColectivo();
        pasajero = null;
        pasaje = null;
        pasajes = null;
        //cargarRutas();
        //cargarHorarios();
        jBGuardar.setEnabled(true);
        jBBorrar.setEnabled(false);
        jBNueva.setEnabled(false);
        jBBuscar.setEnabled(true);
    }
}
