/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 25/01/2020
*/

package com.jorge.psp.practices.ut02_p2.models;

import com.jorge.psp.practices.ut02_p2.utils.GenerateRandomAlphabet;
import org.apache.commons.lang3.StringUtils;

public class Players extends Thread{

    private int numberPlayer;
    private String pickUpLetter;
    private String wordPlayer;
    private int coincidencesPlayer;
    private int rollDice;

    public Players( int numberPlayer, String wordPlayer ) {
        this.numberPlayer = numberPlayer;
        this.wordPlayer = wordPlayer;
    }

    public void run() {

        int i = 1;
        while( isAlive() ) {//<-- Mientras el hilo está vivo

            GenerateRandomAlphabet gRa = new GenerateRandomAlphabet();
            this.pickUpLetter = gRa.getRandonAlphabet();
            this.coincidencesPlayer += StringUtils.countMatches( this.wordPlayer, this.pickUpLetter );

            System.out.println("| Jugador : " + this.numberPlayer + " |");
            System.out.println("    - Letra : " + this.pickUpLetter);
            System.out.println("    - Palabra a completar: " + this.wordPlayer);
            System.out.println("    - Coincidencias hasta el momento: " + this.coincidencesPlayer);

            if ( this.coincidencesPlayer == this.wordPlayer.length() ) {
                System.out.println("Tiradas ------------------------------->:" + i );
                this.rollDice = i;
                interrupt();//<-- Paro el Hilo (Interumpo)
                return;
            }
            i++;
            try {
                Thread.sleep(200);
                yield();
            } catch (InterruptedException e) {}


        }
    }

    public int getRollDice(){
        return this.rollDice;
    }

    public int getNumberPlayer() {
        return numberPlayer;
    }
}