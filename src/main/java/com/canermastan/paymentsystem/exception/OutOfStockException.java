package com.canermastan.paymentsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OutOfStockException extends Exception{
    public OutOfStockException(String message) {
        super(message);
    }
}
