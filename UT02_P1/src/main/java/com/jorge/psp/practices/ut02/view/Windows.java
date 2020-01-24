/*
@ Autor: Jorge Herrán
@ Version: 1.0
@ Since : 24/01/2020
*/

package com.jorge.psp.practices.ut02.view;

import com.jorge.psp.practices.ut02.utils.SearchOccurrences;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static java.lang.Thread.sleep;

public class Windows extends JFrame implements ActionListener, Runnable {

    private JLabel jLabelSearch = new JLabel( "Palabra a encontrar:" );
    private JLabel jLabelCoincidences = new JLabel();
    private JTextField jTextFieldSearch = new JTextField();
    private JScrollPane scrollpane1;
    private JTextArea textarea = new JTextArea();
    private JButton buttonClear = new JButton("Limpiar");
    private JButton buttonSearch = new JButton("Buscar");

    public Windows() {

        setLayout( null );
        setTitle( "Contador de palabras" );

        jLabelSearch.setBounds( 20, 10, 200, 30 );
        add( jLabelSearch );

        jTextFieldSearch.setBounds( 140, 10, 110, 30 );
        add( jTextFieldSearch );


        jLabelCoincidences.setBounds( 260, 10, 200, 30 );
        jLabelCoincidences.setText( "Coincidencias: ? " );

        add( jLabelCoincidences );

        textarea.setBounds(20,50,350,200);
        textarea.setLineWrap(true);//<-- Salto de carro
        add( textarea );

        buttonClear.setBounds(150,280,100,30);
        add( buttonClear );
        buttonClear.addActionListener(this );

    }

    public void actionPerformed(ActionEvent e ) {

        if ( e.getSource() == buttonClear ) {
            textarea.setText( "" );
        }

    }

    public void run() {

        for(int j = 0; j < 300; j++ ) {

            try {
                sleep(5000);

                SearchOccurrences textSearch = new SearchOccurrences( this.textarea.getText(), this.jTextFieldSearch.getText() );

                this.jLabelCoincidences.setText( "Coincidencias: " + textSearch.getCoincidences() );
            }
            catch (InterruptedException e) {

            }
        }
    }
}
