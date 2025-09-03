package br.com.catolicapb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AlreadyPetToCustomerException extends RuntimeException {

    public AlreadyPetToCustomerException(String msg) {
        super(msg);
    }
}
