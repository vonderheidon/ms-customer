package br.com.catolicapb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AlreadyExistsPetToCustomer extends RuntimeException {
    public AlreadyExistsPetToCustomer(String message) {
        super(message);
    }
}
