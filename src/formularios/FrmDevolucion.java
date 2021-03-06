/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.DevolClass;
import clases.EntregaClass;
import clases.PDFClass;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel David Ortiz
 */
public class FrmDevolucion extends javax.swing.JFrame {

    /**
     * Creates new form FrmDevolucion
     */
    Date date = new Date();
    Date hour = new Date();

    public FrmDevolucion(String usuario) {
        initComponents();

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat HourFor = new SimpleDateFormat("HH:mm:ss");

        this.txtFecha.setText(DateFor.format(date));
        this.txtHora.setText(HourFor.format(hour));

        this.lblUsuario.setText(usuario);

        SimpleDateFormat DateFor2 = new SimpleDateFormat("yyyyMMddHHmmss.SS");
        this.lblDevol1.setText("Devolucion No.");
        this.lblDevol2.setText(DateFor2.format(date));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlTitulo = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblDevol2 = new javax.swing.JLabel();
        lblDevol1 = new javax.swing.JLabel();
        pnlDevolucion = new javax.swing.JPanel();
        lblFechaD = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblHoraD = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        lblNombresD = new javax.swing.JLabel();
        txtNombresD = new javax.swing.JTextField();
        lblApellidosD = new javax.swing.JLabel();
        txtApellidosD = new javax.swing.JTextField();
        pnlSolicitud = new javax.swing.JPanel();
        lblSolcitud = new javax.swing.JLabel();
        txtSolicitud = new javax.swing.JTextField();
        lblFechaS = new javax.swing.JLabel();
        txtFechaS = new javax.swing.JTextField();
        lblHoraS = new javax.swing.JLabel();
        txtHoraS = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pnlBici = new javax.swing.JPanel();
        lblCodigoB = new javax.swing.JLabel();
        txtCodBici = new javax.swing.JTextField();
        lblMarcaB = new javax.swing.JLabel();
        txtMarcaBici = new javax.swing.JTextField();
        lblModeloB = new javax.swing.JLabel();
        txtModeloBici = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        pnlBotones = new javax.swing.JPanel();
        btnRecibir = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnCancel1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(435, 637));
        setMinimumSize(new java.awt.Dimension(435, 637));
        setName("Devolucion"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(435, 637));

        pnlTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUsuario.setText("jLabel4");

        lblDevol2.setText("jLabel1");

        lblDevol1.setText("jLabel2");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                        .addComponent(lblDevol2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuario))
                    .addGroup(pnlTituloLayout.createSequentialGroup()
                        .addComponent(lblDevol1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblUsuario))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblDevol1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDevol2)
                .addContainerGap())
        );

        pnlDevolucion.setBorder(javax.swing.BorderFactory.createTitledBorder("Quien devuelve"));
        pnlDevolucion.setPreferredSize(new java.awt.Dimension(587, 240));
        pnlDevolucion.setLayout(new java.awt.GridBagLayout());

        lblFechaD.setText("Fecha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 5);
        pnlDevolucion.add(lblFechaD, gridBagConstraints);

        txtFecha.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pnlDevolucion.add(txtFecha, gridBagConstraints);

        lblHoraD.setText("Hora");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pnlDevolucion.add(lblHoraD, gridBagConstraints);

        txtHora.setEditable(false);
        txtHora.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 15);
        pnlDevolucion.add(txtHora, gridBagConstraints);

        lblNombresD.setText("Nombres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 0, 5);
        pnlDevolucion.add(lblNombresD, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 15);
        pnlDevolucion.add(txtNombresD, gridBagConstraints);

        lblApellidosD.setText("Apellidos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 0, 5);
        pnlDevolucion.add(lblApellidosD, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 15);
        pnlDevolucion.add(txtApellidosD, gridBagConstraints);

        pnlSolicitud.setBorder(javax.swing.BorderFactory.createTitledBorder("No. Solicitud"));
        pnlSolicitud.setLayout(new java.awt.GridBagLayout());

        lblSolcitud.setText("Solicitud");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 10, 5);
        pnlSolicitud.add(lblSolcitud, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(0, -5, 10, 15);
        pnlSolicitud.add(txtSolicitud, gridBagConstraints);

        lblFechaS.setText("Fecha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 5);
        pnlSolicitud.add(lblFechaS, gridBagConstraints);

        txtFechaS.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, -5, 0, 5);
        pnlSolicitud.add(txtFechaS, gridBagConstraints);

        lblHoraS.setText("Hora");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pnlSolicitud.add(lblHoraS, gridBagConstraints);

        txtHoraS.setEditable(false);
        txtHoraS.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 15);
        pnlSolicitud.add(txtHoraS, gridBagConstraints);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 10, 15);
        pnlSolicitud.add(jButton1, gridBagConstraints);

        pnlBici.setBorder(javax.swing.BorderFactory.createTitledBorder("Bicicleta"));

        lblCodigoB.setText("Codigo");

        lblMarcaB.setText("Marca");

        txtMarcaBici.setEditable(false);

        lblModeloB.setText("Modelo");

        txtModeloBici.setEditable(false);

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBiciLayout = new javax.swing.GroupLayout(pnlBici);
        pnlBici.setLayout(pnlBiciLayout);
        pnlBiciLayout.setHorizontalGroup(
            pnlBiciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBiciLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlBiciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarcaB)
                    .addComponent(lblCodigoB)
                    .addComponent(lblModeloB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBiciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBiciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtModeloBici, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addComponent(txtMarcaBici))
                    .addGroup(pnlBiciLayout.createSequentialGroup()
                        .addComponent(txtCodBici, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(19, 19, 19))
        );
        pnlBiciLayout.setVerticalGroup(
            pnlBiciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBiciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBiciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoB)
                    .addComponent(txtCodBici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(pnlBiciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarcaB)
                    .addComponent(txtMarcaBici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBiciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModeloB)
                    .addComponent(txtModeloBici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBotones.setLayout(new java.awt.GridBagLayout());

        btnRecibir.setText("Recibir");
        btnRecibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 5, 5);
        pnlBotones.add(btnRecibir, gridBagConstraints);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        pnlBotones.add(btnImprimir, gridBagConstraints);

        btnCancel.setText("Nuevo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        pnlBotones.add(btnCancel, gridBagConstraints);

        btnCancel1.setText("Cancelar");
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 15);
        pnlBotones.add(btnCancel1, gridBagConstraints);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Reporte");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(pnlSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlBici, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibirActionPerformed

        try {
            String codigo = this.lblDevol2.getText();
            QRCodeWriter qrCode = new QRCodeWriter();
            BitMatrix bqr = qrCode.encode(codigo, BarcodeFormat.QR_CODE.QR_CODE, 200, 200);
            Path pQr = FileSystems.getDefault().getPath("images/QR/" + codigo + "D.png");
            MatrixToImageWriter.writeToPath(bqr, "PNG", pQr);

            DevolClass devolClass = new DevolClass(this.lblDevol2.getText(), this.txtFecha.getText(), this.txtHora.getText(), this.txtNombresD.getText(),
                    this.txtApellidosD.getText(), this.txtCodBici.getText(), this.lblUsuario.getText());

            devolClass.devolucion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }


    }//GEN-LAST:event_btnRecibirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] u;

        try {
            File myObj = new File("control_entregas.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                u = data.split(",");

                if (u[0].equals(this.txtSolicitud.getText())) {
                    this.txtFechaS.setText(u[1]);
                    this.txtHoraS.setText(u[2]);
                }/*else{
                    JOptionPane.showMessageDialog(null, "El codigo de bicicleta no se encuentra intente introducionedo otro");
                }*/
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String[] u;

        try {
            File myObj = new File("bicicletas.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                u = data.split(",");

                if (u[0].equals(this.txtCodBici.getText())) {
                    this.txtMarcaBici.setText(u[1]);
                    this.txtModeloBici.setText(u[2]);
                }/*else{
                    JOptionPane.showMessageDialog(null, "El codigo de bicicleta no se encuentra intente introducionedo otro");
                }*/
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        this.dispose();
        new FrmMenu(this.lblUsuario.getText()).setVisible(true);
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        PDFClass pdfClass = new PDFClass("Devolucion", 2);

        pdfClass.pdfSolDev(this.lblDevol2.getText(), this.txtNombresD.getText(), this.txtApellidosD.getText(), this.txtMarcaBici.getText(),
                this.txtModeloBici.getText());
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        PDFClass pdfClass = new PDFClass("ReporteD", 5);
        String[] encabezado = {"No Solicitud", "Fecha", "Hora", "Nombres", "Apellidos", "Codigo", "Usuario"};
        pdfClass.reportes(encabezado);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FrmDevolucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRecibir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblApellidosD;
    private javax.swing.JLabel lblCodigoB;
    private javax.swing.JLabel lblDevol1;
    private javax.swing.JLabel lblDevol2;
    private javax.swing.JLabel lblFechaD;
    private javax.swing.JLabel lblFechaS;
    private javax.swing.JLabel lblHoraD;
    private javax.swing.JLabel lblHoraS;
    private javax.swing.JLabel lblMarcaB;
    private javax.swing.JLabel lblModeloB;
    private javax.swing.JLabel lblNombresD;
    private javax.swing.JLabel lblSolcitud;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlBici;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDevolucion;
    private javax.swing.JPanel pnlSolicitud;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTextField txtApellidosD;
    private javax.swing.JTextField txtCodBici;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaS;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtHoraS;
    private javax.swing.JTextField txtMarcaBici;
    private javax.swing.JTextField txtModeloBici;
    private javax.swing.JTextField txtNombresD;
    private javax.swing.JTextField txtSolicitud;
    // End of variables declaration//GEN-END:variables
}
