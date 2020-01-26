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

        CreatedWord createdWord = new CreatedWord( "Prueba" );

        Players players1 = new Players( 0, createdWord.getLowerCaseWord()  );
        Players players2 = new Players( 1, createdWord.getLowerCaseWord()  );
        Players players3 = new Players( 2, createdWord.getLowerCaseWord()  );

        players1.start();
        players2.start();
        players3.start();
    }
}
