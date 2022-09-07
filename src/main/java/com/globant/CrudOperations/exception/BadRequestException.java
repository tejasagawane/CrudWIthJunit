package com.globant.CrudOperations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

    private String message;

    public BadRequestException() {}

    public BadRequestException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
