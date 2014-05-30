/*
 *  ChatServerInterface.java
 *  Copyright (C) 2012  Guillermo Pazos <shadowguiller@gmail.com>
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

import java.io.File;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import org.educautecisystems.core.Sistema;
import org.educautecisystems.core.chat.cliente.ClienteServidorChat;
import org.educautecisystems.core.chat.elements.FileChat;
import org.educautecisystems.core.chat.elements.UserChat;

/**
 *
 * @author Guillermo
 */
public class Material_Apoyo extends javax.swing.JInternalFrame {
    
    //private VentanaPrincipal ventanaPrincipal;
    private ClienteServidorChat clienteServidorChat;  
    private ArrayList<FileChat> archivos;
    DefaultListModel listaArchivosModelo = new DefaultListModel();
    private long actualSize = 0;
    private long actualSizeListaUsuarios = 0;
    private long actualSizeListaArchivos = 0;
    private BufferedImage pantallaActual = null;
    
    

    /**
     * Creates new form MaterialApoyo
     */
    public Material_Apoyo() {
        initComponents();
        
        Timer actualizarListaArchivosTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarListaArchivos();
            }
        });
        actualizarListaArchivosTimer.start();
    }

/*    Material_Apoyo(VentanaPrincipal aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMaterApoytabpanel = new javax.swing.JTabbedPane();
        jPanelTeo = new javax.swing.JPanel();
        jlabAvis = new javax.swing.JLabel();
        jButSubir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDoc = new javax.swing.JList();
        jButEliminar = new javax.swing.JButton();
        jPanelPractLab = new javax.swing.JPanel();
        jlabAvis1 = new javax.swing.JLabel();
        jButSubir1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListDoc1 = new javax.swing.JList();
        jButEliminar1 = new javax.swing.JButton();
        jPanelEjerResu = new javax.swing.JPanel();
        jlabAvis2 = new javax.swing.JLabel();
        jButSubir2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListDoc2 = new javax.swing.JList();
        jButEliminar2 = new javax.swing.JButton();
        jPanelTarea = new javax.swing.JPanel();
        jlabAvis3 = new javax.swing.JLabel();
        jButSubir3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListDoc3 = new javax.swing.JList();
        jButEliminar3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Material de Apoyo");
        setName("MaterialApoyo"); // NOI18N

        jlabAvis.setText("Porfavor suba solo la teoria");

        jButSubir.setText("Subir");
        jButSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButSubirActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListDoc);

        jButEliminar.setText("Eliminar");
        jButEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTeoLayout = new javax.swing.GroupLayout(jPanelTeo);
        jPanelTeo.setLayout(jPanelTeoLayout);
        jPanelTeoLayout.setHorizontalGroup(
            jPanelTeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTeoLayout.createSequentialGroup()
                .addGroup(jPanelTeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTeoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlabAvis))
                    .addGroup(jPanelTeoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButSubir)
                        .addGap(28, 28, 28)
                        .addComponent(jButEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTeoLayout.setVerticalGroup(
            jPanelTeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTeoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addGroup(jPanelTeoLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jlabAvis)
                        .addGap(45, 45, 45)
                        .addGroup(jPanelTeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButSubir)
                            .addComponent(jButEliminar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMaterApoytabpanel.addTab("Documento Teoria", jPanelTeo);

        jlabAvis1.setText("Porfavor suba solo la Practica de Laboratorio");

        jButSubir1.setText("Subir");
        jButSubir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButSubir1ActionPerformed(evt);
            }
        });

        jListDoc1.setModel(listaArchivosModelo);
        jListDoc1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jListDoc1);

        jButEliminar1.setText("Eliminar");

        javax.swing.GroupLayout jPanelPractLabLayout = new javax.swing.GroupLayout(jPanelPractLab);
        jPanelPractLab.setLayout(jPanelPractLabLayout);
        jPanelPractLabLayout.setHorizontalGroup(
            jPanelPractLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPractLabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPractLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabAvis1)
                    .addGroup(jPanelPractLabLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButSubir1)
                        .addGap(27, 27, 27)
                        .addComponent(jButEliminar1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPractLabLayout.setVerticalGroup(
            jPanelPractLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPractLabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPractLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addGroup(jPanelPractLabLayout.createSequentialGroup()
                        .addComponent(jlabAvis1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanelPractLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButSubir1)
                            .addComponent(jButEliminar1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMaterApoytabpanel.addTab("Practica de Laboratorio", jPanelPractLab);

        jlabAvis2.setText("Porfavor suba solo los Ejercicios Resueltos");

        jButSubir2.setText("Subir");
        jButSubir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButSubir2ActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jListDoc2);

        jButEliminar2.setText("Eliminar");

        javax.swing.GroupLayout jPanelEjerResuLayout = new javax.swing.GroupLayout(jPanelEjerResu);
        jPanelEjerResu.setLayout(jPanelEjerResuLayout);
        jPanelEjerResuLayout.setHorizontalGroup(
            jPanelEjerResuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEjerResuLayout.createSequentialGroup()
                .addGroup(jPanelEjerResuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEjerResuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlabAvis2))
                    .addGroup(jPanelEjerResuLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButSubir2)
                        .addGap(27, 27, 27)
                        .addComponent(jButEliminar2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelEjerResuLayout.setVerticalGroup(
            jPanelEjerResuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEjerResuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEjerResuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addGroup(jPanelEjerResuLayout.createSequentialGroup()
                        .addComponent(jlabAvis2)
                        .addGap(52, 52, 52)
                        .addGroup(jPanelEjerResuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButSubir2)
                            .addComponent(jButEliminar2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMaterApoytabpanel.addTab("Ejercicios Resueltos", jPanelEjerResu);

        jlabAvis3.setText("Porfavor suba solo la tarea");

        jButSubir3.setText("Subir");
        jButSubir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButSubir3ActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(jListDoc3);

        jButEliminar3.setText("Eliminar");

        javax.swing.GroupLayout jPanelTareaLayout = new javax.swing.GroupLayout(jPanelTarea);
        jPanelTarea.setLayout(jPanelTareaLayout);
        jPanelTareaLayout.setHorizontalGroup(
            jPanelTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTareaLayout.createSequentialGroup()
                .addGroup(jPanelTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTareaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlabAvis3))
                    .addGroup(jPanelTareaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButSubir3)
                        .addGap(18, 18, 18)
                        .addComponent(jButEliminar3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTareaLayout.setVerticalGroup(
            jPanelTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTareaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addGroup(jPanelTareaLayout.createSequentialGroup()
                        .addComponent(jlabAvis3)
                        .addGap(59, 59, 59)
                        .addGroup(jPanelTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButSubir3)
                            .addComponent(jButEliminar3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMaterApoytabpanel.addTab("Tarea", jPanelTarea);

        jLabel1.setText("Cuadro para subir los documentos de clase");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jMaterApoytabpanel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jMaterApoytabpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButEliminarActionPerformed

    private void actualizarListaArchivos() {
        synchronized (this) {
            StringBuilder comprobador = new StringBuilder();

            for (FileChat fileChat : archivos) {
                comprobador.append(fileChat.toString());
            }

            /* No actualizar la lista si no es necesario. */
            if (actualSizeListaArchivos == comprobador.toString().length()) {
                return;
            }

            listaArchivosModelo.clear();

            for (FileChat fileChat : archivos) {
                listaArchivosModelo.addElement(fileChat);
            }
            actualSizeListaArchivos = comprobador.toString().length();
        }
    }
    
    private void jButSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButSubirActionPerformed
        FileChat fileChat = (FileChat) jListDoc.getSelectedValue();

        /* Revisar si existe algún elemento seleccionado. */
        if (fileChat == null) {
            Sistema.mostrarMensajeError("Por favor seleccione un archivo.");
            return;
        }

        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccione donde guardar el archivo.");
        fc.setSelectedFile(new File(fc.getCurrentDirectory(), fileChat.getName()));
        int respuesta = fc.showSaveDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            clienteServidorChat.descargarArchivo(fileChat, archivo);
        }
    }//GEN-LAST:event_jButSubirActionPerformed

    private void jButSubir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButSubir1ActionPerformed
        FileChat fileChat = (FileChat) jListDoc1.getSelectedValue();
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccione archivo a subir");
        fc.setSelectedFile(new File(fc.getCurrentDirectory(), fileChat.getName()));
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
        File archivo = fc.getSelectedFile();
        clienteServidorChat.subirArchivo(fileChat,archivo);
        }
    }//GEN-LAST:event_jButSubir1ActionPerformed

    private void jButSubir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButSubir2ActionPerformed
        FileChat fileChat = (FileChat) jListDoc2.getSelectedValue();
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccione archivo a subir");
        fc.setSelectedFile(new File(fc.getCurrentDirectory(), fileChat.getName()));
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
        File archivo = fc.getSelectedFile();
        clienteServidorChat.subirArchivo(fileChat,archivo);
        }
    }//GEN-LAST:event_jButSubir2ActionPerformed

    private void jButSubir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButSubir3ActionPerformed
        FileChat fileChat = (FileChat) jListDoc3.getSelectedValue();
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccione archivo a subir");
        fc.setSelectedFile(new File(fc.getCurrentDirectory(), fileChat.getName()));
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
        File archivo = fc.getSelectedFile();
        clienteServidorChat.subirArchivo(fileChat,archivo);
        }
    }//GEN-LAST:event_jButSubir3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButEliminar;
    private javax.swing.JButton jButEliminar1;
    private javax.swing.JButton jButEliminar2;
    private javax.swing.JButton jButEliminar3;
    private javax.swing.JButton jButSubir;
    private javax.swing.JButton jButSubir1;
    private javax.swing.JButton jButSubir2;
    private javax.swing.JButton jButSubir3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jListDoc;
    private javax.swing.JList jListDoc1;
    private javax.swing.JList jListDoc2;
    private javax.swing.JList jListDoc3;
    private javax.swing.JTabbedPane jMaterApoytabpanel;
    private javax.swing.JPanel jPanelEjerResu;
    private javax.swing.JPanel jPanelPractLab;
    private javax.swing.JPanel jPanelTarea;
    private javax.swing.JPanel jPanelTeo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlabAvis;
    private javax.swing.JLabel jlabAvis1;
    private javax.swing.JLabel jlabAvis2;
    private javax.swing.JLabel jlabAvis3;
    // End of variables declaration//GEN-END:variables
}