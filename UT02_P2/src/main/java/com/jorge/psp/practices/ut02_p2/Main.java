/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 24/01/2020
*/

package com.jorge.psp.practices.ut02_p2;

import com.jorge.psp.practices.ut02_p2.models.GenerateRandomAlphabet;

public class Main {

    public static void main( String[] args ) {

        GenerateRandomAlphabet alphabet = new GenerateRandomAlphabet();
        System.out.println( alphabet.getrANDOMAlphabet() );

    }
}
