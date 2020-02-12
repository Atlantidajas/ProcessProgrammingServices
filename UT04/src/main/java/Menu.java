/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 11/02/2020
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Menu{

    private ClienteFTP clienteFTP = new ClienteFTP();
    private ArrayList<String> messages = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);

    public Menu() {

        //<-- Los números de opciones los asigno automáticamente en el for de mostrarMensaje()
        this.messages.add(0,"Desconectar " );
        this.messages.add(1,"Conectar " );
        this.messages.add(2,"Subir fichero por FTP " );
        this.messages.add(3,"Borrar fichero del directorio actual " );
        this.messages.add(4,"Borrar fichero de un directorio concreto " );
        this.messages.add(5,"Directorio actual " );
        this.messages.add(6,"Listar ficheros del directorio " );

    }

    public void viewMessageMenu()  {
        for ( int i = 0; i < this.messages.size(); i++ ){
            System.out.println( messages.get(i) + "pulse: " + i );
        }
    }

    public void optionsMenu( int opcion ) {

        switch( opcion ) {

            case 0:
                this.clienteFTP.desconectar();
                break;
            case 1:
                System.out.println( "Introduzca IP" );
                String server = sc.nextLine();

                System.out.println( "Introduzca Usuario" );
                String user = sc.nextLine();

                System.out.println( "Introduzca Contraseña" );
                String password = sc.nextLine();

                this.clienteFTP.conectar(server, user, password);
                break;
            case 2:
                System.out.println( "Introduzca la ruta del archivo que desea subir vía FTP" );
                String urlFile = sc.nextLine();

                System.out.println( "Introduzca el nombre que desea asignar al fichero" );
                String reNameFile = sc.nextLine();

                clienteFTP.subirFichero(urlFile,
                        reNameFile,
                        "/ftp/files");
                break;
            case 3:
                System.out.println("Introduzca nombre de fichero y su extensión");
                String nameFileDelte = sc.nextLine();
                clienteFTP.borrarFichero( nameFileDelte );
                break;

            case 4:
                System.out.println( "Introduzca URL del directorio que desa borrar" );
                String urlFile2 = sc.nextLine();
                System.out.println("Introduzca nombre de fichero, su extensión, ");
                String nameFileDelte2 = sc.nextLine();
                clienteFTP.borrarFichero( urlFile2, nameFileDelte2 );
                break;
            case 5:
                clienteFTP.directorioActual();
                break;
            case 6:
                clienteFTP.listarFicheros();
                break;

        }

    }

    public void viewMenu() {
        Scanner sc = new Scanner(System.in);
        int options = 0;

        do {

            this.viewMessageMenu();
            options = sc.nextInt();
            this.optionsMenu(options);

        }while(options != 0);

        sc.close();
    }


}