/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 24/01/2020
*/

package com.jorge.psp.practices.ut02_p2;

import com.jorge.psp.practices.ut02_p2.models.Players;
import com.jorge.psp.practices.ut02_p2.utils.CreatedWord;
import com.jorge.psp.practices.ut02_p2.utils.GenerateRandomAlphabet;

import java.util.ArrayList;


public class Main {

    public static void main( String[] args ) {


        CreatedWord createdWord = new CreatedWord( "Prueba" );

        Players player1 = new Players( 0, createdWord.getLowerCaseWord() );
        Players player2 = new Players( 1, createdWord.getLowerCaseWord() );
        Players player3 = new Players( 2, createdWord.getLowerCaseWord() );

        player1.start();
        player2.start();
        player3.start();

    }
}
