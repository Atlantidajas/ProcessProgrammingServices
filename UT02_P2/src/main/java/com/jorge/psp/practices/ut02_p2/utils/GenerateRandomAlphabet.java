/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 24/01/2020
*/

package com.jorge.psp.practices.ut02_p2.utils;



public class GenerateRandomAlphabet{

    private int numRandon;
    private boolean free = true;

    private static final String[] ALPHABET = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m","N", "ñ", "o","p","q","r","s","t","u","v","w", "x","y","z"};

    public GenerateRandomAlphabet() {

        this.numRandon = ( int ) Math.round( Math.random() * 26 );
    }

    public String getRandonAlphabet() {
        return ALPHABET[this.numRandon];
    }


}
