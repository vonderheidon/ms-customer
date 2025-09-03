package br.com.catolicapb.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Specie {

    CANINO,
    FELINO,
    AVE;

    @JsonCreator
    public static Specie fromString(String value) {
        return Specie.valueOf(value.toUpperCase());
    }


}
