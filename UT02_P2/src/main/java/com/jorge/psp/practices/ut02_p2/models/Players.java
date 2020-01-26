/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 25/01/2020
*/

package com.jorge.psp.practices.ut02_p2.models;

import com.jorge.psp.practices.ut02_p2.utils.GenerateRandomAlphabet;

public class Players extends Thread{

    private int numberPlayer;
    private String pickUpLetter;
    private String wordPlayer;
    private int coincidencesPlayer;
    GenerateRandomAlphabet gRa = new GenerateRandomAlphabet();

    public Players( int numberPlayer, String wordPlayer ) {
        this.numberPlayer = numberPlayer;
        this.wordPlayer = wordPlayer;
    }

    public void run() {


        int j = 0;

            this.pickUpLetter = gRa.getRandonAlphabet();

            while( coincidencesPlayer != this.wordPlayer.length() ) {

                this.coincidencesPlayer += this.coincidencesPlayer;

                System.out.println( "-----------------------------------");
                System.out.println( "| Jugador : " + this.numberPlayer + " |" );
                System.out.println( "    - Letra : " + this.pickUpLetter );
                System.out.println( "    - Palabra a completar: " + this.wordPlayer );
                System.out.println( "    - Coincidencias hasta el momento: " + this.coincidencesPlayer );

                j++;

                if ( this.coincidencesPlayer == this.wordPlayer.length() ){

                    System.out.println( "El ganador es el jugador: " + this.numberPlayer );
                    return;
                }

            }

        }

}
