/*
 *  PantallaProfessor.java
 *  Copyright (C) 2013  Diego Estévez <dgmvecuador@gmail.com>
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

import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;

/**
 *
 * @author dgmv
 */
public class PantallaProfesor extends javax.swing.JInternalFrame {
	private Chat pantallaChat;
	/**
	 * Creates new form PantallaProfessor
	 */
	public PantallaProfesor( Chat pantallaChat ) {
		initComponents();
		this.pantallaChat = pantallaChat;
	}
	
	public void actualizarPantallaProfesor( BufferedImage screnshot ) {
		pantallaProfesorLabel.setIcon(new ImageIcon(screnshot));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerChat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pantallaProfesorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);

        btnVerChat.setText("Mostrar Chat");
        btnVerChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerChatActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerChat, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(pantallaProfesorLabel);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-874)/2, (screenSize.height-533)/2, 874, 533);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerChatActionPerformed
		try {
			pantallaChat.setSelected(true);
		} catch (PropertyVetoException ex) {
			
		}
    }//GEN-LAST:event_btnVerChatActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerChat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pantallaProfesorLabel;
    // End of variables declaration//GEN-END:variables
}
