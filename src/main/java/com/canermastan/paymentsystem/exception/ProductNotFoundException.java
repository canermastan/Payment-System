package com.canermastan.paymentsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String exception) {
        super(exception);
    }
}
