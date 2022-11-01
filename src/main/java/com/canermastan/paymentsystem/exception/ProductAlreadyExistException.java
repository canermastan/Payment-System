package com.canermastan.paymentsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductAlreadyExistException extends Exception {
    public ProductAlreadyExistException(String exception) {
        super(exception);
    }
}