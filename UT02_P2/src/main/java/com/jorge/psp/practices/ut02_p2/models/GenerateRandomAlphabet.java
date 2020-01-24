/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 24/01/2020
*/

package com.jorge.psp.practices.ut02_p2.models;

public class GenerateRandomAlphabet {

    private static final String [] ALPHABET = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M","N", "Ñ", "O","P","Q","R","S","T","U","V","W", "X","Y","Z" };

    private int numRandon;

    public GenerateRandomAlphabet() {
        this.numRandon = ( int ) Math.round(Math.random() * 27 ) ;
    }

    public String getrANDOMAlphabet() {
        return ALPHABET[this.numRandon];
    }

}
