package com.see0gan.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidTypeException extends RuntimeException
{
    public InvalidTypeException(String message) {
        super(message);
    }
}
