/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 25/01/2020
*/

package com.jorge.psp.practices.ut02_p2.models;

public class Players {

    private int numberPlayer;
    private String pickUpLetter;
    private boolean status = false;


    public Players( int numberPlayer ) {
        this.numberPlayer = numberPlayer;
    }

    public int getNumberPlayer() {
        return numberPlayer;
    }

    public boolean pickUpLetter( String pickUpLetter ) {
        this.status = true;
        System.out.println("Jugador: " + this.numberPlayer + " coge letra :" + this.pickUpLetter);
        return this.status;
    }

    public boolean cambioTurno(){
        this.status = false;
        return this.status;
    }
}
