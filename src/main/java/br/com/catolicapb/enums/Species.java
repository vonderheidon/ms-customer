package br.com.catolicapb.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Species {

    CANINO,
    FELINO,
    AVE;

    @JsonCreator
    public static Species fromString(String value) {
        return Species.valueOf(value.toUpperCase());
    }
}
