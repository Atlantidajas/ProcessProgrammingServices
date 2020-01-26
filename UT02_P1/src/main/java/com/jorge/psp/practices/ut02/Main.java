/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 24/01/2020
*/

package com.jorge.psp.practices.ut02;

import com.jorge.psp.practices.ut02.view.Windows;

public class Main {

    public static void main( String[] args ) {

        Windows WordCounterWindow = new Windows();
        WordCounterWindow.setBounds(0,0,410,380);
        WordCounterWindow.setVisible(true);

        new Thread( WordCounterWindow ).start();


    }
}
