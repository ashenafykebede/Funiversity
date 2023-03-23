package com.switchfully.funiversity.webapi.exceptions;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(PasswordDoesntMatchException.class)
    protected void passwordDoesntMatchException(PasswordDoesntMatchException exception,
                                                HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(),exception.getMessage());

    }
    @org.springframework.web.bind.annotation.ExceptionHandler(AccessLevelException.class)
    protected void accessLevelException(AccessLevelException exception,HttpServletResponse response) throws IOException
    {
        response.sendError(HttpStatus.UNAUTHORIZED.value(),exception.getMessage());
    }
}
