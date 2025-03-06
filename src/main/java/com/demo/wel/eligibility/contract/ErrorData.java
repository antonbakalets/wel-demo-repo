package com.demo.wel.eligibility.contract;

import com.demo.wel.util.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorData {

    private ErrorCode code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorDetail> details;
}
