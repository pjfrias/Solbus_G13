package Vistas;

import Conexion.*;
import Entidades.*;
import java.awt.Color;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class GestionRutas extends javax.swing.JInternalFrame {

    private HorarioData datosHora;
    private RutaData datosRuta;
    private boolean control1;
    private boolean control2;
    private boolean control3;
    private boolean control4;
    private boolean control5;
    private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
    private DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int a, int b) {

            return false;
        }
    };

    public GestionRutas() {
        initComponents();
        datosHora = new HorarioData();
        datosRuta = new RutaData();
        armarCabecera();
        //cargarFilas();
        jTorigen.setEnabled(false);
        jTdestino.setEnabled(false);
        jThoraSalida.setEnabled(false);
        jThoraLlegada.setEnabled(false);
        jRactivas.setSelected(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTrutas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBeditar = new javax.swing.JButton();
        jBagregar = new javax.swing.JButton();
        jBeliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLerror1 = new javax.swing.JLabel();
        jLerror2 = new javax.swing.JLabel();
        jLerror3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jThoraSalida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jThoraLlegada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTtiempoEstimado = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTorigen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTdestino = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRinactivas = new javax.swing.JRadioButton();
        jRactivas = new javax.swing.JRadioButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel7.setText("jLabel7");

        jTrutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTrutas);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Gestion de Rutas y Horarios");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBeditar.setText("Editar");
        jBeditar.setPreferredSize(new java.awt.Dimension(130, 23));
        jBeditar.setRequestFocusEnabled(false);
        jBeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeditarActionPerformed(evt);
            }
        });

        jBagregar.setText("Agregar");
        jBagregar.setPreferredSize(new java.awt.Dimension(130, 23));
        jBagregar.setRequestFocusEnabled(false);
        jBagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBagregarActionPerformed(evt);
            }
        });

        jBeliminar.setText("Desactivar");
        jBeliminar.setPreferredSize(new java.awt.Dimension(130, 23));
        jBeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeliminarActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.setPreferredSize(new java.awt.Dimension(130, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jBagregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jBeditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLerror1.setForeground(new java.awt.Color(255, 51, 51));
        jLerror1.setLabelFor(jThoraSalida);

        jLerror2.setForeground(new java.awt.Color(255, 51, 51));

        jLerror3.setForeground(new java.awt.Color(255, 51, 51));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Las horas deben agregarse en el formato 00:10"));

        jThoraSalida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jThoraSalida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jThoraSalida.setPreferredSize(new java.awt.Dimension(30, 26));
        jThoraSalida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jThoraSalidaFocusLost(evt);
            }
        });
        jThoraSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThoraSalidaActionPerformed(evt);
            }
        });

        jLabel5.setText("Hora Salida");

        jLabel3.setText("Hora Llegada");

        jThoraLlegada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jThoraLlegada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jThoraLlegada.setPreferredSize(new java.awt.Dimension(30, 26));
        jThoraLlegada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jThoraLlegadaFocusLost(evt);
            }
        });

        jLabel4.setText("Tiempo Estimado");

        jTtiempoEstimado.setEditable(false);
        jTtiempoEstimado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTtiempoEstimado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTtiempoEstimado.setPreferredSize(new java.awt.Dimension(30, 26));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jThoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jThoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTtiempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jThoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jThoraLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTtiempoEstimado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Localidades"));

        jTorigen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTorigenFocusLost(evt);
            }
        });

        jLabel1.setText("Origen");

        jTdestino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTdestinoFocusLost(evt);
            }
        });
        jTdestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTdestinoActionPerformed(evt);
            }
        });

        jLabel2.setText("Destino");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTorigen)
                        .addComponent(jTdestino, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTorigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(jTdestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLerror2)
                            .addComponent(jLerror3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLerror1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLerror2)
                .addGap(29, 29, 29)
                .addComponent(jLerror3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLerror1))
        );

        jRinactivas.setText("Inactivas");
        jRinactivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRinactivasActionPerformed(evt);
            }
        });

        jRactivas.setText("Activas");
        jRactivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRactivasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(jRactivas)
                                .addGap(83, 83, 83)
                                .addComponent(jRinactivas)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 717, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRinactivas)
                    .addComponent(jRactivas, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTdestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTdestinoActionPerformed

    }//GEN-LAST:event_jTdestinoActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBagregarActionPerformed
        jBagregar.setText("Guardar Ruta");
        jBeditar.setEnabled(false);
        jBeliminar.setEnabled(false);
        jTorigen.setEnabled(true);
        jTdestino.setEnabled(true);
        jThoraSalida.setEnabled(true);
        jThoraLlegada.setEnabled(true);

        controlRutas();
        if (control1 && control2 && control3 && control4 && control5) {
            LocalTime salida = LocalTime.parse(jThoraSalida.getText());
            LocalTime llegada = LocalTime.parse(jThoraLlegada.getText());
            LocalTime duracion = LocalTime.parse(jTtiempoEstimado.getText());

            Ruta ruta = new Ruta(jTorigen.getText(), jTdestino.getText(), duracion, true);
            Horario hora = new Horario(salida, llegada, ruta, true);

            datosRuta.guardarRuta(hora);
            ruta = datosRuta.buscarRutaOrigenDestino(ruta);
            hora.setRuta(ruta);
            datosHora.guardarHorario(hora);

            borrarFilas();
            cargarFilas();

            jBagregar.setText("Agregar");
            jBeditar.setEnabled(true);
            jBeliminar.setEnabled(true);
            jTorigen.setEnabled(false);
            jTdestino.setEnabled(false);
            jThoraSalida.setEnabled(false);
            jThoraLlegada.setEnabled(false);
            jTorigen.setText("");
            jTdestino.setText("");
            jThoraSalida.setText("");
            jThoraLlegada.setText("");
            jTtiempoEstimado.setText("");
        }


    }//GEN-LAST:event_jBagregarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jThoraSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jThoraSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jThoraSalidaActionPerformed

    private void jThoraSalidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jThoraSalidaFocusLost
        if (validarFormatoHora(jThoraSalida.getText())) {
            control1 = true;
            jLerror1.setText("");
            jThoraSalida.setBorder(null);
        } else {
            jThoraSalida.setBorder(bordeRojo);
            jLerror1.setText("Formato incorrecto");
            control1 = false;
        }
        if (control1 && control2) {
            setDuracion();
        }
    }//GEN-LAST:event_jThoraSalidaFocusLost

    private void jThoraLlegadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jThoraLlegadaFocusLost
        if (validarFormatoHora(jThoraLlegada.getText())) {
            control2 = true;
            jLerror1.setText("");
            jThoraLlegada.setBorder(null);
        } else {
            jThoraLlegada.setBorder(bordeRojo);
            jLerror1.setText("Formato incorrecto");
            control2 = false;
        }
        if (control1 && control2) {
            setDuracion();
        }
    }//GEN-LAST:event_jThoraLlegadaFocusLost

    private void jTorigenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTorigenFocusLost
        if (!validarFormatoPalabra(jTorigen.getText())) {
            jTorigen.setBorder(bordeRojo);
            jLerror2.setText("No puede quedar vacio");
            control3 = false;

        } else {
            jTorigen.setBorder(null);
            jLerror2.setText("");
            control3 = true;
        }
    }//GEN-LAST:event_jTorigenFocusLost

    private void jTdestinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTdestinoFocusLost
        if (!validarFormatoPalabra(jTdestino.getText())) {
            jTdestino.setBorder(bordeRojo);
            jLerror3.setText("No puede quedar vacio");
            control4 = false;

        } else {
            jTdestino.setBorder(null);
            jLerror3.setText("");
            control4 = true;
        }
    }//GEN-LAST:event_jTdestinoFocusLost

    private void jBeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeditarActionPerformed
        int fila = jTrutas.getSelectedRow();

        if (jBeditar.getText().equals("Cambiar")) {
            setDuracion();
            LocalTime duracion = LocalTime.parse(jTtiempoEstimado.getText());
            Ruta ruta = new Ruta(jTrutas.getValueAt(fila, 0) + "", jTrutas.getValueAt(fila, 1) + "", duracion, true);
            ruta = datosRuta.buscarRutaOrigenDestino(ruta);
            Horario hora = datosHora.buscarHorarioIDRuta(ruta);
            ruta.setOrigen(jTorigen.getText());
            ruta.setDestino(jTdestino.getText());
            ruta.setDuracion(LocalTime.parse(jTtiempoEstimado.getText()));
            hora.setSalida(LocalTime.parse(jThoraSalida.getText()));
            hora.setLlegada(LocalTime.parse(jThoraLlegada.getText()));
            datosHora.editarHorarioId(hora);
            datosRuta.editarRutaporId(ruta);

            borrarFilas();
            cargarFilas();

            jTorigen.setText("");
            jTdestino.setText("");
            jThoraSalida.setText("");
            jThoraLlegada.setText("");
            jTtiempoEstimado.setText("");

            jBagregar.setEnabled(true);
            jBeliminar.setEnabled(true);
            jTorigen.setEnabled(false);
            jTdestino.setEnabled(false);
            jThoraSalida.setEnabled(false);
            jThoraLlegada.setEnabled(false);

            jBeditar.setText("Editar");
        } else {
            jBagregar.setEnabled(false);
            jBeliminar.setEnabled(false);
            jTorigen.setEnabled(true);
            jTdestino.setEnabled(true);
            jThoraSalida.setEnabled(true);
            jThoraLlegada.setEnabled(true);

            jTorigen.setText(jTrutas.getValueAt(fila, 0) + "");
            jTdestino.setText(jTrutas.getValueAt(fila, 1) + "");
            jThoraSalida.setText(jTrutas.getValueAt(fila, 2) + "");
            jThoraLlegada.setText(jTrutas.getValueAt(fila, 3) + "");
            jTtiempoEstimado.setText(jTrutas.getValueAt(fila, 4) + "");
            jBeditar.setText("Cambiar");
        }
    }//GEN-LAST:event_jBeditarActionPerformed

    private void jBeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeliminarActionPerformed
        int fila = jTrutas.getSelectedRow();
        if (jBeliminar.getText().equals("Desactivar")) {            
            LocalTime duracion = LocalTime.parse(jTrutas.getValueAt(fila, 4) + "");
            Ruta ruta = new Ruta(jTrutas.getValueAt(fila, 0) + "", jTrutas.getValueAt(fila, 1) + "", duracion, true);
            ruta = datosRuta.buscarRutaOrigenDestino(ruta);
            Horario hora = datosHora.buscarHorarioIDRuta(ruta);
            datosHora.borrarHorarioPorId(hora);
            datosRuta.borrarRutaPorId(ruta);
            borrarFilas();
            cargarFilas();
        } else {
            LocalTime duracion = LocalTime.parse(jTrutas.getValueAt(fila, 4) + "");
            Ruta ruta = new Ruta(jTrutas.getValueAt(fila, 0) + "", jTrutas.getValueAt(fila, 1) + "", duracion, true);
            ruta = datosRuta.buscarRutaOrigenDestinoInactivo(ruta);
            Horario hora = datosHora.buscarHorarioIDRutaInactivo(ruta);
            datosHora.activarHorarioPorId(hora);
            datosRuta.activarRutaPorId(ruta);
            borrarFilas();
            cargarFilas();
        }

    }//GEN-LAST:event_jBeliminarActionPerformed

    private void jRactivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRactivasActionPerformed
        if (jRactivas.isSelected()) {
            jRinactivas.setSelected(false);
        } else {
            jRinactivas.setSelected(true);
        }
        jBeliminar.setText("Desactivar");

        borrarFilas();
        cargarFilas();// TODO add your handling code here:
    }//GEN-LAST:event_jRactivasActionPerformed

    private void jRinactivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRinactivasActionPerformed
        if (jRinactivas.isSelected()) {
            jRactivas.setSelected(false);
        } else {
            jRactivas.setSelected(true);
        }
        jBeliminar.setText("Activar");

        borrarFilas();
        cargarFilas();// TODO add your handling code here:
    }//GEN-LAST:event_jRinactivasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBagregar;
    private javax.swing.JButton jBeditar;
    private javax.swing.JButton jBeliminar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLerror1;
    private javax.swing.JLabel jLerror2;
    private javax.swing.JLabel jLerror3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRactivas;
    private javax.swing.JRadioButton jRinactivas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTdestino;
    private javax.swing.JTextField jThoraLlegada;
    private javax.swing.JTextField jThoraSalida;
    private javax.swing.JTextField jTorigen;
    private javax.swing.JTable jTrutas;
    private javax.swing.JTextField jTtiempoEstimado;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {

        model.addColumn("Origen");
        model.addColumn("Destino");
        model.addColumn("Hora Salida");
        model.addColumn("Hora Llegada");
        model.addColumn("Duracion Estimada");
        jTrutas.setModel(model);
    }

    private void borrarFilas() {
        int f = model.getRowCount() - 1;
        for (; f >= 0; f--) {
            model.removeRow(f);
        }
    }

    private void cargarFilas() {

        List<Horario> horas; 

        model = (DefaultTableModel) jTrutas.getModel();
        
        if (jRactivas.isSelected()) {
            horas = datosHora.buscarHorarios();
        } else {
            horas = datosHora.buscarHorariosInactivos();
        }

        for (Horario hora : horas) {
            model.addRow(new Object[]{
                hora.getRuta().getOrigen(),
                hora.getRuta().getDestino(),
                hora.getSalida(),
                hora.getLlegada(),
                hora.getRuta().getDuracion()
            });
        }
    }

    public boolean validarFormatoHora(String hora) {

        String patronHora = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern patron = Pattern.compile(patronHora);
        Matcher matcher = patron.matcher(hora);
        return matcher.matches();
    }

    public boolean validarFormatoPalabra(String palabra) {

        String patronHora = "\\s*(\\b\\D+\\b\\s*){1,40}";
        Pattern patron = Pattern.compile(patronHora);
        Matcher matcher = patron.matcher(palabra);
        return matcher.matches();
    }

    public void setDuracion() {
        Duration duracion = null;
        long horas = 0;
        long minutos = 0;
        LocalTime duracionTime = null;

        duracion = Duration.between(LocalTime.parse(jThoraSalida.getText()), LocalTime.parse(jThoraLlegada.getText()));
        horas = duracion.toHours();
        minutos = duracion.minusHours(horas).toMinutes();
        try {
            duracionTime = LocalTime.of((int) horas, (int) minutos);
        } catch (DateTimeException e) {
            jTtiempoEstimado.setText("Error");
            jLerror1.setText("Hora de Salida inferior a la hora de llegada");
            jThoraSalida.setBorder(bordeRojo);
            control1 = false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        jTtiempoEstimado.setText(duracionTime.format(formatter));
    }

    public void controlRutas() {
        if (!jTtiempoEstimado.getText().equals(""))  {            
            LocalTime duracion = LocalTime.parse(jTtiempoEstimado.getText());
            Ruta ruta = new Ruta(jTorigen.getText(), jTdestino.getText(), duracion, true);

            ruta = datosRuta.buscarRutaOrigenDestino(ruta);
            if (ruta.getOrigen() == null) {
                control5 = true;
            } else {
                control5 = false;
                jLerror1.setText("No se puede agregar otro horario a la misma ruta");
            }
        }
    }
}
