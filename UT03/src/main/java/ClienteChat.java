import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClienteChat extends JFrame implements ActionListener, Runnable {

    private static final long serialVersionUID = 1L;
    Socket socket = null;

    DataInputStream fentrada;
    DataOutputStream fsalida;

    String nombre;
    static JTextField mensaje = new JTextField();
    private JScrollPane scrollpane1;
    static JTextArea textarea1;
    JButton boton = new JButton("Enviar");
    JButton desconectar = new JButton("Salir");
    boolean repetir = true;


    public ClienteChat(Socket socket, String nombre) {

        super("Conexión del Cliente Chat: " + nombre);
        setLayout(null);

        mensaje.setBounds(10, 10, 400, 30);
        add(mensaje);

        textarea1 = new JTextArea();
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10, 50, 400, 300);
        add(scrollpane1);

        boton.setBounds(420, 10, 100, 30);
        add(boton);

        desconectar.setBounds(420, 50, 100, 30);
        add(desconectar);

        textarea1.setEditable(false);
        boton.addActionListener(this);
        desconectar.addActionListener(this);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.socket = socket;
        this.nombre = nombre;

        try {
            fentrada = new DataInputStream(socket.getInputStream());
            fsalida = new DataOutputStream(socket.getOutputStream());
            String texto = " > Entrada en el Chat ..." + nombre;
            fsalida.writeUTF(texto); // Escribe un mensaje de entrada
        } catch (IOException e) {
            System.out.println("Error de E/S");
            e.printStackTrace();
            System.exit(0);
        }

    }

    public void actionPerformed(ActionEvent e) {
        // Se pulta el boton de Enviar
        if (e.getSource() == boton) {
            String texto = nombre + "> " + mensaje.getText();
            try {
                mensaje.setText("");
                fsalida.writeUTF(texto);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == desconectar) {
            String texto = " > Abandona el Chat ... " + nombre;
            try {
                fsalida.writeUTF(texto);
                fsalida.writeUTF("*");
                repetir = false; // Para salir del bucle
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    public void run() {
        String texto = "";

        while (repetir) {
            try {
                texto = fentrada.readUTF(); // Leer mensajes
                textarea1.setText(texto); // Visualizar los mensajes
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Imposible conectar con el Servidor\n"
                                + e.getMessage(), "<<Mensaje de Error:2>>",
                        JOptionPane.ERROR_MESSAGE);
                repetir = false; // Salimos del bucle
            }
        }

        try {
            socket.close(); // Cerrar socket
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        int puerto = 5050;
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick: ");
        Socket socket = null;

        try {
            // Cliente y servidor se ejecutan en la máquina local

            socket = new Socket("192.168.56.1", puerto);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Imposible Conectar con el Servidor\n" + e.getMessage(),
                    "<<Mensaje de Error:1>>", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        if (!nombre.trim().equals("")) { // Hay que escribir algo
            ClienteChat cliente = new ClienteChat(socket, nombre);
            cliente.setBounds(0, 0, 540, 400);
            cliente.setVisible(true);
            new Thread(cliente).start();
        } else {
            System.out.println("El nombre está vacio ...");
        }
    }
}
