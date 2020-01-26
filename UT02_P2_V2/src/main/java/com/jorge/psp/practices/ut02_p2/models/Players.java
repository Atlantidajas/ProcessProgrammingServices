/*
@ Author Jorge Herrán.
@ Version 2.0
@ Since 26/01/2020
*/

package com.jorge.psp.practices.ut02_p2.models;

import com.jorge.psp.practices.ut02_p2.utils.GenerateRandomAlphabet;
import org.apache.commons.lang3.StringUtils;

public class Players extends Thread{

    private int numberPlayer;
    private String pickUpLetter;
    private String wordPlayer;
    private int coincidencesPlayer;

    public Players( int numberPlayer, String wordPlayer ) {
        this.numberPlayer = numberPlayer;
        this.wordPlayer = wordPlayer;
    }

    public void run() {

        GenerateRandomAlphabet gRa = new GenerateRandomAlphabet();
        this.pickUpLetter = gRa.getRandonAlphabet();
        this.coincidencesPlayer += StringUtils.countMatches( this.wordPlayer, this.pickUpLetter );

        System.out.println( "-----------------------------------");
        System.out.println( "| Jugador : " + this.numberPlayer + " |" );
        System.out.println( "    - Letra : " + this.pickUpLetter );
        System.out.println( "    - Palabra a completar: " + this.wordPlayer );
        System.out.println( "    - Coincidencias hasta el momento: " + this.coincidencesPlayer );

        if ( this.coincidencesPlayer == this.wordPlayer.length() ){
            System.out.println( "El ganador es el jugador: " + this.numberPlayer );
            return;
        }
        else{
            this.run();
        }
    }
}
