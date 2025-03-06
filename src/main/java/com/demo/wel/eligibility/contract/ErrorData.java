package com.demo.wel.eligibility.contract;

import com.demo.wel.util.ErrorCode;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorData {

    private ErrorCode code;
    private String message;
    private List<ErrorDetail> details;
}
