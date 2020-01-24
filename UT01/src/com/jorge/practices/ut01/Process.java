package com.jorge.practices.ut01;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Process {
    public Runtime r = Runtime.getRuntime();
    public Map map = System.getenv();//<-- Obtengo el valor de la variable directorio ejecutar Tomcat
    public java.lang.Process p;

    public Process() {}

    public void executeProcess( String command ) {

        try {
            String catalinaHome = (String) map.get("CATALINA_HOME");
            this.p = r.exec(catalinaHome + "\\bin\\" + command );


        } catch (Exception e) {
            System.out.println("Error al ejecutar el comando: " + command );
            e.printStackTrace();
        }

    }

    public String statusProcess( String host ){

        String statusProcess = "";
        try {

            URL url = new URL(host);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            try {
                int a = connection.getResponseCode();
                if( a == 200 ){
                    statusProcess = "OK";
                }
                if( a == 404 ){
                    statusProcess = "No encontrado" + connection.toString();

                }


            }catch ( Exception e ){
                if (e.getCause() == null){
                    statusProcess = "No hay conexión";
                }
                else {
                    statusProcess = e.getCause().toString();
                }
        }
        }catch ( Exception e ){
            statusProcess = e.getMessage();
        }
        return statusProcess;
    }
}