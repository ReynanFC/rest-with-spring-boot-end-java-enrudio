package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArithmeticException extends RuntimeException {

    public ArithmeticException(String message) {
        super(message);
    }
}
