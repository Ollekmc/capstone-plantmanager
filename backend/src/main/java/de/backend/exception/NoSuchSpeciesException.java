package de.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchSpeciesException extends IllegalArgumentException{

        public NoSuchSpeciesException(String s) {
            super(s);
        }

    }