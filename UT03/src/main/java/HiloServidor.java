import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class HiloServidor extends Thread {

    DataInputStream fentrada;
    Socket socket = null;

    public HiloServidor(Socket s) {

        socket = s;
        try {
            fentrada = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Error de E/S");
            e.printStackTrace();
        }

    }

    public void run() {

        ServidorChat.mensaje.setText("Numero de Conexiones Actuales: "
                + ServidorChat.ACTUALES);
        String texto = ServidorChat.textarea.getText();

        while (true) {
            String cadena = "";
            try {
                cadena = fentrada.readUTF(); // Leemos lo que escribe el cliente
                // Cuando un cliente finaliza envia un *
                if (cadena.trim().equals("*")) {
                    ServidorChat.ACTUALES--;
                    ServidorChat.mensaje.setText("Numero de Conexiones Actuales: "
                            + ServidorChat.ACTUALES);
                    break; // Salir del while
                }

                ServidorChat.textarea.append(cadena + "\n");
                texto = ServidorChat.textarea.getText();
                EnviarMensajes(texto);

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

    }


    private void EnviarMensajes(String texto) {

        for (int i = 0; i < ServidorChat.CONEXIONES; i++) {
            Socket s = ServidorChat.tabla[i];

            try {
                DataOutputStream fsalida = new DataOutputStream(s.getOutputStream());
                fsalida.writeUTF(texto);

            } catch (SocketException se) {

                se.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}



