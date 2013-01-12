/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.educautecisystems.core.chat.cliente;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.educautecisystems.core.Sistema;
import org.educautecisystems.core.chat.elements.ChatConstants;
import org.educautecisystems.core.chat.elements.MessageHeaderParser;
import org.educautecisystems.intefaz.Chat;

/**
 *
 * @author Shadow2013
 */
public class ClienteServidorChat extends Thread {
    private Chat pantallaChat;
    private boolean continuar;
    
    /* Informaciòn del cliente. */
    private String clienteToken = null;
    private String clienteUsuarioId = null;
    
    public ClienteServidorChat( Chat pantallaChat ) {
        this.pantallaChat = pantallaChat;
        continuar = true;
    }

    @Override
    public void run() {
        if ( pantallaChat == null ) {
            System.err.println("No se ha encontrado una ventana de chat al cual hacer referencia.");
            return;
        }
        
        pantallaChat.mostrarInfo("Iniciando chat..");
        
        /* Conectarse con el servidor. */
        try {
            pantallaChat.mostrarInfo("Conectando con el servidor..");
            Socket socket = new Socket(Sistema.getChatServerConf().getIp(), 
                Integer.parseInt(Sistema.getChatServerConf().getPort()));
            pantallaChat.mostrarInfo("Conectado con ["+Sistema.getChatServerConf().getIp()+
                    ":"+Sistema.getChatServerConf().getPort()+"]");
            
            pantallaChat.activarBotones(true);
            cicloUsuario(socket);
            
            pantallaChat.mostrarInfo("Cerrando conexión..");
            socket.close();
        } catch ( Exception ex ) {
            if ( ex instanceof NumberFormatException ) {
                pantallaChat.mostrarError("El puerto ingresado no es un nùmero.");
                return;
            }
            pantallaChat.mostrarError("MAIN - "+ex.getLocalizedMessage());
            return;
        }
        
        pantallaChat.mostrarInfo("Cerrando chat..");
    }
    
    private void cicloUsuario( Socket socket ) throws Exception {
        OutputStream salida = socket.getOutputStream();
        InputStream entrada = socket.getInputStream();
        StringBuilder mensaje = new StringBuilder();
        
        mensaje.append(ChatConstants.CHAT_HEADER_MAIN_COMMAND);
        mensaje.append(ChatConstants.CHAT_END_HEADER);
        mensaje.append(generateHeaderValue(ChatConstants.LABEL_COMMAND, ChatConstants.COMMAND_LOGIN));
        mensaje.append(generateHeaderValue(ChatConstants.LABEL_REAL_NAME, Sistema.getChatSessionConf().getRealName()));
        mensaje.append(generateHeaderValue(ChatConstants.LABEL_NICKNAME, Sistema.getChatSessionConf().getNickname()));
        mensaje.append(ChatConstants.CHAT_END_HEADER);

        salida.write(mensaje.toString().getBytes());
        salida.flush();
        
        MessageHeaderParser header = MessageHeaderParser.parseMessageHeader(entrada, true);
        if (!header.getVar(ChatConstants.CHAT_HEADER_RESPONSE_COMMAND).equals(ChatConstants.RESPONSE_OK)) {
            pantallaChat.mostrarError("No se pudo negociar con el servidor.");
            return;
        }

        clienteToken = header.getVar(ChatConstants.LABEL_USER_TOKEN);
        clienteUsuarioId = header.getVar(ChatConstants.LABEL_USER_ID);
        
        pantallaChat.mostrarInfo("Token: "+clienteToken);
        pantallaChat.mostrarInfo("User Id: "+clienteUsuarioId);
        
        while ( continuar ) {
            MessageHeaderParser headerMessage = MessageHeaderParser.parseMessageHeader(entrada, true);
            if (!headerMessage.getVar(ChatConstants.CHAT_HEADER_RESPONSE_COMMAND).equals(ChatConstants.RESPONSE_OK)) {
                pantallaChat.mostrarError("No se pudo negociar con el servidor.");
                continue;
            }
            
            String contentLength = header.getVar(ChatConstants.LABEL_CONTENT_LENGHT);
            String userId = header.getVar(ChatConstants.LABEL_USER_ID);
            
            long contentLengthLong = -1;
			
			try {
				contentLengthLong = Long.parseLong(contentLength);
			} catch ( NumberFormatException nfe ) {
				pantallaChat.mostrarError("Error al recibir el mensaje.");
				return;
			}
            
            StringBuilder message = new StringBuilder();
			int byteRead = entrada.read();
			
			for ( long i=0; i<contentLengthLong; i++ ) {
				if ( byteRead != -1 ) {
					message.append((char) byteRead);
					byteRead = entrada.read();
				} else {
					pantallaChat.mostrarError("Not Enought bytes read.");
					return;
				}
			}
            
            pantallaChat.recibirMensaje(userId, message.toString());
        }
    }
    
    public void enviarMensaje( final String txt ) {
        final StringBuilder mensaje = new StringBuilder();
        
        Thread hiloMensajes = new Thread() {
            @Override
            public void run() {
                try {
                    pantallaChat.mostrarInfo("Conectando...");
                    Socket socket = new Socket(Sistema.getChatServerConf().getIp(),
                            Integer.parseInt(Sistema.getChatServerConf().getPort()));
                    OutputStream salida = socket.getOutputStream();
                    InputStream entrada = socket.getInputStream();

                    /* Generar salida. */
                    pantallaChat.mostrarInfo("Contruyendo mensaje...");
                    mensaje.append(ChatConstants.CHAT_HEADER_MAIN_COMMAND);
                    mensaje.append(ChatConstants.CHAT_END_HEADER);
                    mensaje.append(generateHeaderValue(ChatConstants.LABEL_COMMAND, ChatConstants.COMMAND_SEND_MESSAGE));
                    mensaje.append(generateHeaderValue(ChatConstants.LABEL_TO, "all"));
                    mensaje.append(generateHeaderValue(ChatConstants.LABEL_USER_TOKEN, clienteToken));
                    mensaje.append(generateHeaderValue(ChatConstants.LABEL_CONTENT_LENGHT, "" + txt.length()));
                    mensaje.append(ChatConstants.CHAT_END_HEADER);
                    mensaje.append(txt);

                    System.out.println(mensaje.toString());
                    pantallaChat.mostrarInfo("Enviando mensaje...");
                    salida.write(mensaje.toString().getBytes());
                    salida.flush();
                    pantallaChat.mostrarInfo("Mensaje enviado.");

                    MessageHeaderParser headerMessage = MessageHeaderParser.parseMessageHeader(entrada, true);
                    if (!headerMessage.getVar(ChatConstants.CHAT_HEADER_RESPONSE_COMMAND).equals(ChatConstants.RESPONSE_OK)) {
                        pantallaChat.mostrarError("El servidor no recibió el mensaje.");
                    }
                    pantallaChat.mostrarInfo("Servidor responde exitosamente.");
                    socket.close();
                } catch (Exception e) {
                    pantallaChat.mostrarInfo("No se pudo enviar el mensaje: " + e.getLocalizedMessage());
                }
            }
        };
        hiloMensajes.start();
    }
    
    private String generateHeaderValue( String name, String val ) {
		return name + ": " + val + "\r\n";
	}
}
