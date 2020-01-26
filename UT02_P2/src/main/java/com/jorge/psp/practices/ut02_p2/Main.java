/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 24/01/2020
*/

package com.jorge.psp.practices.ut02_p2;

import com.jorge.psp.practices.ut02_p2.models.Players;
import com.jorge.psp.practices.ut02_p2.utils.CreatedWord;


public class Main {

    public static void main( String[] args ) {

        CreatedWord createdWord1 = new CreatedWord( "Prueba" );
        new Thread( createdWord1 ).start();

        CreatedWord createdWord2 = new CreatedWord( "Prueba" );
        new Thread( createdWord2 ).start();

        CreatedWord createdWord3 = new CreatedWord( "Prueba" );
        new Thread( createdWord3 ).start();




    }
}
