package com.switchfully.funiversity.webapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AccessLevelException extends RuntimeException{
    public AccessLevelException(String message) {
        super(message);
    }
}
