/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 24/01/2020
*/

package com.jorge.psp.practices.ut02_p2.utils;

import com.jorge.psp.practices.ut02_p2.models.Players;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

public class CreatedWord implements Runnable{

    private String word;
    private String lowerCaseWord;
    private ArrayList<GenerateRandomAlphabet>generateRandomAlphabets = new ArrayList<GenerateRandomAlphabet>();
    private int coincidences = 0;


    public CreatedWord( String word ) {
        this.word = word;
        this.lowerCaseWord = word.toLowerCase();

    }

    public void guess( int guessPlayer ){

        int i = 0;

        while( this.coincidences != this.word.length() ) {

            generateRandomAlphabets.add( i, new GenerateRandomAlphabet() );

            this.coincidences += StringUtils.countMatches( this.lowerCaseWord, generateRandomAlphabets.get( i ).getRandonAlphabet() );

            System.out.println("Jugador : " + guessPlayer );

            System.out.println( "Letra aleatoria: " + generateRandomAlphabets.get( i ).getRandonAlphabet() );

            System.out.println( "Coincidencias:" + this.coincidences );

            System.out.println( "Tamaño palabra:" + this.word.length() );

            System.out.println( "Palabra para analizar:" + this.word );

            if( this.coincidences == this.word.length() ){
                System.out.println("El juego a terminado");
                System.out.println( "El ganador es jugador: *******" + guessPlayer + "*********" );

            }
            i++;
        }
    }

    public void run() {

        for( int i = 1; i < 4; i++ ){

            Players players = new Players( i );
            guess( players.getNumberPlayer() );//<-- Guess player

        }
    }
}

