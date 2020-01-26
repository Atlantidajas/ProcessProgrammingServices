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
    private int coincidencesPlayer = 0;

    public Players( int numberPlayer, String wordPlayer ) {
        this.numberPlayer = numberPlayer;
        this.wordPlayer = wordPlayer;
    }

    public void run() {

        GenerateRandomAlphabet gRa = new GenerateRandomAlphabet();

        for( int i = 0; i < 3; i++ ){

            this.pickUpLetter = gRa.getRandonAlphabet();

            int j = 0;

            while( coincidencesPlayer != this.wordPlayer.length() ) {

                this.coincidencesPlayer += this.coincidencesPlayer;

                j++;

                if ( this.coincidencesPlayer == this.wordPlayer.length() ){

                    System.out.println( "El ganador es el jugador: " + this.numberPlayer );
                    return;
                }

            }

        }

    }
}
