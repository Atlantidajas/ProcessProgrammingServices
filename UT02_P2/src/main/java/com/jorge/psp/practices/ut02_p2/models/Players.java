/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 25/01/2020
*/

package com.jorge.psp.practices.ut02_p2.models;

public class Players {

    private int numberPlayer;
    private String pickUpLetter;
    private boolean status;


    public Players( int numberPlayer ) {
        this.numberPlayer = numberPlayer;
    }

    public void setNumberPlayer(int numberPlayer) {
        this.numberPlayer = numberPlayer;
    }

    public void setPickUpLetter(String pickUpLetter) {
        this.pickUpLetter = pickUpLetter;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPickUpLetter() {
        return pickUpLetter;
    }

    public boolean isStatus() {
        return status;
    }

    public int getNumberPlayer() {
        return numberPlayer;
    }
}
