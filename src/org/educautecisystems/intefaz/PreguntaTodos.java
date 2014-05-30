/*
 *  PreguntaTodos.java
 *  Copyright (C) 2013  Guillermo Pazos <shadowguiller@hotmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.educautecisystems.intefaz;

import org.educautecisystems.core.chat.ServidorChat;
import org.educautecisystems.core.chat.elements.ChatConstants;
import org.educautecisystems.core.chat.elements.PreguntaMessage;
import org.educautecisystems.core.chat.elements.ReceptorPregunta;

/**
 *
 * @author dgmv
 */
public class PreguntaTodos extends javax.swing.JInternalFrame implements ReceptorPregunta {
    public static int idPregunta = 1;
    private int respuestaSi = 0;
    private int respuestaNo = 0;
    private boolean continuar = true;
    
    ServidorChat servidorChat;
    PreguntaMessage preguntaMessage = null;

    /**
     * Creates new form PreguntaTodos
     */
    public PreguntaTodos( ServidorChat servidorChat ) {
        initComponents();
        final PreguntaTodos ventanaPadre = this;
        this.servidorChat = servidorChat;
        btnExportarResultados.setVisible(false);
        
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while ( continuar ) {
                    if (respuestaSi != 0 || respuestaNo != 0) {
                        synchronized (ventanaPadre) {
                            int total = respuestaSi + respuestaNo;
                            progressBarSi.setMaximum(total);
                            progressBarNo.setMaximum(total);
                            
                            progressBarSi.setValue(respuestaSi);
                            progressBarNo.setValue(respuestaNo);
                            
                            /* Seleccionar las cadenas */
                            progressBarSi.setString(""+respuestaSi);
                            progressBarNo.setString(""+respuestaNo);
                        }
                    }
                    
                    /* Esperar para actualizar. */
                    try {
                        Thread.sleep(500);
                    } catch ( Exception e  ) {
                        
                    }
                }
            }
        });
        hilo.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPregunta = new javax.swing.JTextField();
        btnIngresarPregunta = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        progressBarSi = new javax.swing.JProgressBar();
        progressBarNo = new javax.swing.JProgressBar();
        btnExportarResultados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Preguntar");

        jLabel1.setText("<html><b>Pregunta:</b></html>");

        btnIngresarPregunta.setText("Ingresar Pregunta");
        btnIngresarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPreguntaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("<html><b>Resultados:</b></html>");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Si:");

        jLabel4.setText("No:");

        progressBarSi.setString("0");
        progressBarSi.setStringPainted(true);

        progressBarNo.setString("0");
        progressBarNo.setStringPainted(true);

        btnExportarResultados.setText("Exportar resultados");
        btnExportarResultados.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExportarResultados)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(progressBarSi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBarNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(progressBarSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(progressBarNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportarResultados)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPregunta)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIngresarPregunta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)))
                        .addGap(0, 275, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarPregunta)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        /* Borrar pregunta de la lista */
        if ( preguntaMessage != null ) {
            servidorChat.borrarPregunta(preguntaMessage);
        }
        
        continuar = false;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIngresarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPreguntaActionPerformed
        String pregunta = txtPregunta.getText();
        preguntaMessage = new PreguntaMessage(idPregunta, pregunta, this);
        
        servidorChat.enviarPregunta(preguntaMessage);
        
        /* No permitir que pregunte de nuevo */
        txtPregunta.setEnabled(false);
        btnIngresarPregunta.setEnabled(false);
    }//GEN-LAST:event_btnIngresarPreguntaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExportarResultados;
    private javax.swing.JButton btnIngresarPregunta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progressBarNo;
    private javax.swing.JProgressBar progressBarSi;
    private javax.swing.JTextField txtPregunta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void enviarResultadoPregunta(String respuesta) {
        synchronized (this) {
            if (respuesta.equals(ChatConstants.RESPUESTA_SI)) {
                respuestaSi++;
            } else if ( respuesta.equals(ChatConstants.RESPUESTA_NO) ) {
                respuestaNo++;
            } else {
                System.err.println("Respuesta de encuesta no reconocida: "+respuesta);
            }
        }
        
    }
}
