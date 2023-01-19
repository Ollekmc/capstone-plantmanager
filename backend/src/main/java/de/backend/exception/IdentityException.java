package de.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class IdentityException extends Exception{

    public IdentityException(){super("Response is null");}

        public IdentityException(String message) {
            super(message);
        }
}
