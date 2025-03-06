package com.demo.wel.eligibility.contract;

import lombok.Getter;
import org.springframework.validation.FieldError;

@Getter
public class ErrorDetail {

    private final String field;
    private final String issue;

    public ErrorDetail(FieldError fieldError) {
        field = fieldError.getField();
        issue = fieldError.getDefaultMessage();
    }
}
