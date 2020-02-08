import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ServidorChat extends JFrame implements ActionListener {
    // Atributos
    private static final long serialVersionUID = 1L;
    static ServerSocket servidor;
    static final int PUERTO = 5050; // Puerto por el que escucha el servidor
    static int CONEXIONES = 0; // Cuenta el numero de conexiones
    static int ACTUALES = 0; // Numero de conexiones actuales activas
    static int MAXIMO = 10; // Maximo de conexiones permitidas

    static JTextField mensaje = new JTextField("");
    static JTextField mensaje2 = new JTextField("");
    private JScrollPane scrollpanel;
    static JTextArea textarea;
    JButton salir = new JButton("Salir");

    static Socket tabla[] = new Socket[MAXIMO]; // Almacena sockets de clientes
    // Desde el constructor se prepara la pantalla:

    // Constructor
    public ServidorChat() {
        super("Ventana del Servidor de Chat");
        setLayout(null);
        mensaje.setBounds(10, 10, 400, 30);
        add(mensaje);
        mensaje.setEditable(false);

        mensaje2.setBounds(10,348,400,39);
        add(mensaje2);

        textarea = new JTextArea();
        scrollpanel = new JScrollPane(textarea);

        scrollpanel.setBounds(10,50, 400, 300);
        add(scrollpanel);

        salir.setBounds(420, 10, 100, 30);
        add(salir);

        textarea.setEditable(false);
        salir.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    } // constructor

    //Se ha anulado el cierre de la ventana para que la finalización del servidor se haga desde el botón Salir. Cuando
    //se pulsa el botón se cierra el ServerSocket y finaliza la ejecución:

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == salir) { // Pulsamos en el boton salir
            try {
                servidor.close(); // Cerramos el chat
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.exit(0);
        }

    }
    //Desde el método main() se inicia el servidor y las variables y se prepara la pantalla:

    public static void main(String[] args) throws IOException {

        servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor inciado...");
        ServidorChat pantalla = new ServidorChat();
        pantalla.setBounds(0, 0, 540, 450);
        pantalla.setVisible(true);
        mensaje.setText("Número de Conexiones Actuales: " + 0);

        /*e hace un bucle para controlar el número de conexiones. Dentro del bucle el servidor espera la conexión del
        cliente y cuando se conecta se crea el socket:
        El servidor admite hasta 10 conexiones*/

        while (CONEXIONES < MAXIMO) {
            Socket socket = new Socket();
            try {
                socket = servidor.accept(); // Esperando un cliente
            } catch (SocketException ns) {
                //
                break; // Salimos del bucle
            }

        /* El socket creado satisfactoriamente se almacena en la tabla, se cuenta el número de conexiones, se
         incremetan las conexiones actuales y se lanza el hilo para gestionar los mensajes del cliente que se acaba de*/

            conectar:
            tabla[CONEXIONES] = socket;
            CONEXIONES++;
            ACTUALES++;
            HiloServidor hilo = new HiloServidor(socket);
            hilo.start();
        }

        /*Se sale del bucle anterior si ha habido 10 conexiones o si se pulsa el botón Salir. Al pulsar el botón salir se
        cierra el ServerSocket, esto causa que la sentencia socket = servidor.accept() lance la excepción
        SocketException (ya que el servidor está cerrado) desde donde se hace break para salir del bucle.
        Al salir del bucle se comprueba si el servidor está cerrado, si no lo está es que se han establecido las 10
        conexiones, se visualiza un mensaje y se cierra el servidor:
        Cuando finaliza el bucle se cierra el servidor si no se ha cerrado antes*/

        if (!servidor.isClosed())
            try {
                // Sale cuando se llega al maximo de conexiones
                mensaje2.setForeground(Color.red);
                mensaje2.setText("Maximo numero de conexiones establecidas: " + CONEXIONES);
                servidor.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        System.out.println("Servidor finalizado ...");
    }
}

