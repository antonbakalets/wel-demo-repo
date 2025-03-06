package com.demo.wel.eligibility.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EligibilityRequest {

    @Pattern(regexp = "^[a-zA-Z0-9]{10}$")
    @JsonProperty("employee_code")
    private String employeeCode;
}
