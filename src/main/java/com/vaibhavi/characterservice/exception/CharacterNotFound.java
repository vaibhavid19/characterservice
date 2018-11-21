package com.vaibhavi.characterservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND,reason="This character does not exist in database")
public class CharacterNotFound extends RuntimeException {

    public CharacterNotFound() {

    }
    public CharacterNotFound(String message) {
        super(message);
    }
}
