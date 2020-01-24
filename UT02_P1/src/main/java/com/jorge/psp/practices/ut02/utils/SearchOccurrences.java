/*
@ Autor: Jorge Herrán
@ Version: 1.0
@ Since 24/01/2020
 */

package com.jorge.psp.practices.ut02.utils;

import org.apache.commons.lang3.StringUtils;

public class SearchOccurrences {

    private String textIn;
    private String textTreated;
    private int coincidences;

    public SearchOccurrences( String textIn, String textSearch) {
        this.textIn = textIn;
        this.textTreated = StringUtils.lowerCase( textIn );
        this.coincidences = StringUtils.countMatches( this.textTreated, StringUtils.lowerCase( textSearch ) );
    }

    public void setTextIn(String textIn) {
        this.textIn = textIn;
    }

    public void setTextTreated(String textTreated) {
        this.textTreated = textTreated;
    }

    public void setCoincidences(int coincidences) {
        this.coincidences = coincidences;
    }

    public String getTextIn() {
        return textIn;
    }

    public String getTextTreated() {
        return textTreated;
    }

    public int getCoincidences() {
        return coincidences;
    }

}
