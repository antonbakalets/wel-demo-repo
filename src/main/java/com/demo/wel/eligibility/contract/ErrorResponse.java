package com.demo.wel.eligibility.contract;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"status", "error"})
public class ErrorResponse extends BaseResponse {

    private final ErrorData error;
    public ErrorResponse(ErrorData error) {
        super("error");
        this.error = error;
    }
}
