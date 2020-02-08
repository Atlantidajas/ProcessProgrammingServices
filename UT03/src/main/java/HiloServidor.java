import java.io.*;
import java.net.*;

public class HiloServidor extends Thread {

    // Atributos
    DataInputStream fentrada;
    Socket socket = null;

    public HiloServidor(Socket s) {

        socket = s;
        try {
            // Se crea el flujo de entrada
            fentrada = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Error de E/S");
            e.printStackTrace();
        }

    } // constructor
    /*En el método run(), lo primero que hacemos es enviar los mensajes que hay actualmente en el Chat al
    programa cliente para que los visualice en la pantalla. Esto se hace en el método EnviarMensajes() (se definirá
    más adelante). Los mensajes que se envían son los que están en el TextArea del Servidor de Chat:*/

    public void run() {

        ServidorChat.mensaje.setText("Numero de Conexiones Actuales: "
                + ServidorChat.ACTUALES);
        // Nada más conextarse el cliente le envio todos los mensajes
        String texto = ServidorChat.textarea.getText();

        //EnviarMensajes(texto);

        /*A continuación se hace un bucle while en el que se recibe lo que el cliente escribe en el chat. Cuando un cliente
        finaliza (pulsa el botón Salir de su pantalla) envía un asterisco al Servidor de Chat, entonces se sale del bucle
        while, ya que termina el proceso del cliente, de esta manera se controlan las conexiones actuales:*/

        while(true) {
            String cadena = "";
            try {
                cadena = fentrada.readUTF(); // Leemos lo que escribe el cliente
                // Cuando un cliente finaliza envia un *
                if (cadena.trim().equals("*")) {
                    ServidorChat.ACTUALES --;
                    ServidorChat.mensaje.setText("Numero de Conexiones Actuales: "
                            + ServidorChat.ACTUALES);
                    break; // Salir del while
                }
        /*        El texto que el cliente escribe en su chat, se añade al TextArea del servidor y el servidor enviará a todos los
                clientes el texto que hay en su TextArea llamando de nuevo a EnviarMensaje(), así todos ven la conversación:*/
                ServidorChat.textarea.append(cadena + "\n");
                texto = ServidorChat.textarea.getText();
                EnviarMensajes(texto); // Se envia el texto a todos los clientes

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        } // while

    } // run

     /*El método EnviarMensajes() envía el texto del TextArea a todos los sockets que están en la tabla de sockets,
    de esta manera todos ven la conversación. Será necesario abrir un stream de escritura a cada socket y escribir
    el texto:*/

    // Envia los mensajes del TextArea a los clientes de chat
    private void EnviarMensajes( String texto ) {

        // Recorremos la tabla de sockets para enviarles los mensajes
        for (int i = 0; i < ServidorChat.CONEXIONES; i++) {
            Socket s = ServidorChat.tabla[i];

            try {
                DataOutputStream fsalida = new DataOutputStream(s.getOutputStream());
                fsalida.writeUTF(texto);

            } catch (SocketException se) {

                // Esta excepcion ocurre cuando escribimos en un socket
                // de un cliente que ha finalizado
                se.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } // for

    } // EnviarMensajes

} // HiloServidor



