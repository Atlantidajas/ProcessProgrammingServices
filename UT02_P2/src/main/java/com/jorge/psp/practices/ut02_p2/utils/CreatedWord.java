/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 24/01/2020
*/

package com.jorge.psp.practices.ut02_p2.utils;

public class CreatedWord {

    private String word;
    private String lowerCaseWord;

    public CreatedWord( String word ) {
        this.word = word;
        this.lowerCaseWord = word.toLowerCase();
    }

    public String getLowerCaseWord() {
        return lowerCaseWord;
    }
}

