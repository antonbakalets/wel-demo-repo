package com.demo.wel.util;

import lombok.Getter;

@Getter
public class FunctionalException extends RuntimeException {

    private final ErrorCode errorCode;

    public FunctionalException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
