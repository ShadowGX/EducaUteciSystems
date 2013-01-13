/*
 *  ChatServerInterface.java
 *  Copyright (C) 2012  Diego Estévez <dgmvecuador@gmail.com>
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;
import org.educautecisystems.core.chat.LogChatManager;
import org.educautecisystems.core.chat.ServidorChat;

/**
 *
 * @author dgmv
 */
public class ChatServerInterface extends javax.swing.JInternalFrame implements LogChatManager {
	private StringBuffer bitacora = new StringBuffer();
	private boolean serverChatFuncionando = false;
	private ServidorChat servidorChat = null;

	/**
	 * Creates new form ChatServerInterface
	 */
	public ChatServerInterface() {
		initComponents();
        Timer actualizarBitacora = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarBitacoraPrivado();
            }
        });
        actualizarBitacora.start();
	}
	
	public void limpiarEventos() {
		txtBitacoraEventos.setText("");
		bitacora.delete(0, bitacora.length());
	}
	
	@Override
	public void logWarning( String txt )  {
		synchronized ( this ) {
			String linea = "<font color=\"#D87F01\"><b>[" + new Date() + "] Info:&nbsp;</b>" + txt + "</font><br>";
			bitacora.append(linea);
		}
	}
	
	@Override
	public void logError( String txt ) {
		synchronized ( this ) {
			String linea = "<font color=\"red\"><b>[" + new Date() + "] Info:&nbsp;</b>" + txt + "</font><br>";
			bitacora.append(linea);
		}
	}
	
	@Override
	public void logInfo( String txt ) {
		synchronized ( this ) {
			String linea = "<font color=\"blue\"><b>[" + new Date() + "] Info:&nbsp;</b>" + txt + "</font><br>";
			bitacora.append(linea);
		}
	}
	
	private void actualizarBitacoraPrivado() {
        synchronized( this ) {
            if ( !cbActualizar.isSelected() ) {
                return;
            }
            
            txtBitacoraEventos.setText("<html>"+bitacora+"</html>");
            txtBitacoraEventos.setCaretPosition(txtBitacoraEventos.getDocument().getLength());
        }
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
        txtNombreServidor = new javax.swing.JTextField();
        btnArrancarServidor = new javax.swing.JButton();
        btnDetenerServidor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBitacoraEventos = new javax.swing.JEditorPane();
        btnCerrarVentana = new javax.swing.JButton();
        cbActualizar = new javax.swing.JCheckBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sevidor Chat");

        jLabel1.setText("Nombre del Servidor:");

        txtNombreServidor.setText("Main-Chat-Server");

        btnArrancarServidor.setText("Arrancar Servidor");
        btnArrancarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArrancarServidorActionPerformed(evt);
            }
        });

        btnDetenerServidor.setText("Detener Servidor");
        btnDetenerServidor.setEnabled(false);
        btnDetenerServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerServidorActionPerformed(evt);
            }
        });

        jLabel2.setText("Eventos:");

        txtBitacoraEventos.setEditable(false);
        txtBitacoraEventos.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(txtBitacoraEventos);

        btnCerrarVentana.setText("Cerrar Ventana");
        btnCerrarVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarVentanaActionPerformed(evt);
            }
        });

        cbActualizar.setText("Auto-actualizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreServidor))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnArrancarServidor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDetenerServidor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCerrarVentana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbActualizar)))
                        .addGap(0, 360, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArrancarServidor)
                    .addComponent(btnDetenerServidor)
                    .addComponent(btnCerrarVentana)
                    .addComponent(cbActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-848)/2, (screenSize.height-435)/2, 848, 435);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarVentanaActionPerformed
        this.setVisible(false);
		this.dispose();
    }//GEN-LAST:event_btnCerrarVentanaActionPerformed

    private void btnArrancarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrancarServidorActionPerformed
        synchronized(this) {
			if ( !serverChatFuncionando ) {
				serverChatFuncionando = true;
				
				/* Detener el servidor si existe alguno */
				if ( servidorChat != null ) {
					servidorChat.detenerServidor();
					servidorChat = null;
				}
				
				/* Cambiar el estado de los botones cuando sea necesario. */
				btnDetenerServidor.setEnabled(true);
				btnArrancarServidor.setEnabled(false);
				
				/* Arrancar el servidor */
				servidorChat = new ServidorChat(this);
				servidorChat.start();
			}
		}
    }//GEN-LAST:event_btnArrancarServidorActionPerformed

    private void btnDetenerServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerServidorActionPerformed
        synchronized ( this ) {
			if ( serverChatFuncionando ) {
				if ( servidorChat != null ) {
					servidorChat.detenerServidor();
					servidorChat = null;
				}
				
				/* Cambiar el estado de los botones. */
				btnDetenerServidor.setEnabled(false);
				btnArrancarServidor.setEnabled(true);
				serverChatFuncionando = false;
			}
		}
    }//GEN-LAST:event_btnDetenerServidorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArrancarServidor;
    private javax.swing.JButton btnCerrarVentana;
    private javax.swing.JButton btnDetenerServidor;
    private javax.swing.JCheckBox cbActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane txtBitacoraEventos;
    private javax.swing.JTextField txtNombreServidor;
    // End of variables declaration//GEN-END:variables
}
