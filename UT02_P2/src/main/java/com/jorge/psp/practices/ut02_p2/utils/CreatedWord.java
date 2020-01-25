/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 24/01/2020
*/

package com.jorge.psp.practices.ut02_p2.utils;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

public class CreatedWord{

    private String word;
    private String lowerCaseWord;
    private ArrayList<GenerateRandomAlphabet>generateRandomAlphabets = new ArrayList<GenerateRandomAlphabet>();
    private int coincidences = 0;


    public CreatedWord( String word ) {
        this.word = word;
        this.lowerCaseWord = word.toLowerCase();

    }

    public void guess(){

        int i = 0;

        while( this.coincidences != this.word.length() ) {

            generateRandomAlphabets.add( i, new GenerateRandomAlphabet() );

            this.coincidences += StringUtils.countMatches( this.lowerCaseWord, generateRandomAlphabets.get( i ).getRandonAlphabet() );

            System.out.println( "Letra aleatoria: " + generateRandomAlphabets.get( i ).getRandonAlphabet() );

            System.out.println( "Coincidencias:" + this.coincidences );

            System.out.println( "Tamaño palabra:" + this.word.length() );

            System.out.println( "Palabra para analizar:" + this.word );

            i++;

        }
    }
}

