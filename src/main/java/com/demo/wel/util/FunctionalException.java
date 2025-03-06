package com.demo.wel.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FunctionalException extends RuntimeException {

    private final ErrorCode errorCode;
    private final HttpStatus httpStatus;

    public FunctionalException(ErrorCode errorCode, String message) {
        this(errorCode, message, HttpStatus.BAD_REQUEST);
    }

    public FunctionalException(ErrorCode errorCode, String message, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}
