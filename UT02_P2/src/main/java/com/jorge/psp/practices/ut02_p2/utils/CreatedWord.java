/*
@ Author Jorge Herrán.
@ Version 1.0
@ Since 24/01/2020
*/

package com.jorge.psp.practices.ut02_p2.utils;

import com.jorge.psp.practices.ut02_p2.models.Players;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

public class CreatedWord {

    private String word;
    private String lowerCaseWord;
    private int coincidences = 0;


    public CreatedWord( String word ) {
        this.word = word;
        this.lowerCaseWord = word.toLowerCase();

    }

    public String getLowerCaseWord() {
        return lowerCaseWord;
    }
}

