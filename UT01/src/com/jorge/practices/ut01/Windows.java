package com.jorge.practices.ut01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windows extends JFrame {

    public Windows() {

        super("Servicio Tomcat");
        setLocationRelativeTo(null);
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        JButton botonStart = new JButton("Arrancar");
        botonStart.setBackground( Color.green );

        JButton botonStop = new JButton("Parar");
        botonStop.setBackground( Color.red );

        JButton botonStatus = new JButton("Estado");
        botonStatus.setBackground( Color.orange );

        JLabel jLabel = new JLabel("Pulsa una opción  ");

        Process tomcatProcess = new Process();

        botonStart.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jLabel.setText("Iniciado Tomcat");
                jLabel.setForeground(  Color.green);
                tomcatProcess.executeProcess( "startup.bat" );
            }
        });

        botonStop.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jLabel.setText("Parado Tomcat");
                jLabel.setForeground( Color.red );
                tomcatProcess.executeProcess( "shutdown.bat" );
            }
        });

        botonStatus.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jLabel.setForeground( Color.orange );
                jLabel.setText( tomcatProcess.statusProcess("http://localhost:8080" ) );
            }
        });

        cp.add(jLabel);
        cp.add(botonStart);
        cp.add(botonStop);
        cp.add(botonStatus);
    }
}
