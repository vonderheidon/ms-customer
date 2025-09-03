package br.com.catolicapb.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Contact {

    private String mobileNumber;
    private String phone;
}
