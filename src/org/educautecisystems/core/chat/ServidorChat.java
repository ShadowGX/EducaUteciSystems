/*
 *  ServidorChat.java
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

package org.educautecisystems.core.chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import org.educautecisystems.core.chat.elements.UserChat;

/**
 *
 * @author dgmv
 */
public class ServidorChat extends Thread {
	/* Datos escenciales para el servidor */
	private ServerSocket socketServidor;
	private ArrayList<AtenderClienteServidor> clientes;
	private static final ArrayList<UserChat> usuarios = new ArrayList<UserChat>();
	private Socket cliente;
	private boolean continuar;
	private LogChatManager logChatManager;

	/* Valores constantes */
	public static final int PUERTO_SERVIDOR = 7586;

	public ServidorChat( LogChatManager logChatManager ) {
		continuar = true;
		clientes = new ArrayList<AtenderClienteServidor>();
		this.logChatManager = logChatManager;
	}

	@Override
	public void run () {
		/* Evitar que problemas */
		if ( logChatManager == null ) {
			System.err.println("No existe interface para el log.");
			System.exit(-1);
			return;
		}
		
		try {
			logChatManager.logInfo("Arrancando servidor chat..");
			socketServidor = new ServerSocket(PUERTO_SERVIDOR);
			logChatManager.logInfo("Se esta escuchando el puerto: "+PUERTO_SERVIDOR);

			while ( continuar ) {
				logChatManager.logInfo("Esperando cliente nuevo.");
				cliente = socketServidor.accept();
				logChatManager.logInfo("Nuevo cliente en: "+cliente.getLocalAddress()+"/"+cliente.getPort());
				AtenderClienteServidor atencionCliente = new AtenderClienteServidor(cliente, logChatManager, this);
				logChatManager.logInfo("Arrancando hilo de atención..");
				atencionCliente.start();
				insertarCliente(atencionCliente);
				depurarListaClientes();
			}
		} catch ( Exception e ) {
			logChatManager.logError("Problema en el servidor: "+e);
		}
	}
	
	public void sendMessage( String toVar, String message, int idUserOrigin ) {
		String []usersId = toVar.split(",");
		
		for ( String userId:usersId ) {
			if ( userId.equals("all") ) {
				for ( AtenderClienteServidor atenderClienteServidor:clientes ) {
					atenderClienteServidor.sendMessage(0, message, idUserOrigin);
				}
			} else {
				int idUser = 0;
				
				try {
					idUser = Integer.parseInt(userId);
				} catch ( NumberFormatException nfe ) {
					logChatManager.logWarning("Invalid user number\""+userId+"\".");
					continue;
				}
				
				if ( idUser == 0 ) {
					logChatManager.logWarning("");
					continue;
				}
				
				for ( AtenderClienteServidor atenderClienteServidor:clientes ) {
					atenderClienteServidor.sendMessage(idUser, message, idUserOrigin);
				}
			}
		}
	}
	
	public int getUserIdFromToken ( String token ) {
		for ( UserChat usuario:usuarios ) {
			if ( usuario.getToken().equals(token) ) {
				return usuario.getId();
			}
		}
		
		return 0;
	}
	
	public static boolean testToken( String token ) {
		for ( UserChat usuario:usuarios ) {
			if ( token.equals(usuario.getToken()) ) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<UserChat> getUserList() {
		return usuarios;
	}
	
	public void insertarUsuario( UserChat userChat ) {
		usuarios.add(userChat);
	}
	
	public void quitarUsuario( UserChat userChat ) {
		usuarios.remove(userChat);
		
		/* Cerrar Cliente */
		for ( AtenderClienteServidor atenderClienteServidor:clientes ) {
			if ( atenderClienteServidor.esCliente(userChat.getId()) ) {
				atenderClienteServidor.detenerCliente();
			}
		}
	}
	
	public boolean logoutCliente( String token ) {
		for ( AtenderClienteServidor atenderClienteServidor:clientes ) {
			if ( atenderClienteServidor.detenerUsuarioToken(token) ) {
				/* Borrar usuario. */
				for ( UserChat usuario:usuarios ) {
					if ( usuario.getToken().equals(token) ) {
						usuarios.remove(usuario);
						break;
					}
				}
				return true;
			}
		}
		return false;
	}

	private void insertarCliente ( AtenderClienteServidor atencionCliente ) {
		clientes.add(atencionCliente);
	}

	private void quitarCliente( AtenderClienteServidor atencionCliente) {
		clientes.remove(atencionCliente);
	}

	public void depurarListaClientes () {
		for( AtenderClienteServidor atencionCliente : clientes ) {
			if ( !atencionCliente.estaCorriendo() ) {
				quitarCliente(atencionCliente);
			}
		}
	}

	public void detenerServidor() {
		continuar = false;
		try {
			for ( AtenderClienteServidor clienteAtencion:clientes ) {
				clienteAtencion.detenerCliente();
			}
			
			if ( socketServidor != null ) {
				socketServidor.close();
			}
		} catch ( Exception e ) {
			
		}
	}
}
