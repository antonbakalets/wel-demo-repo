package com.demo.wel.eligibility.contract;

import jakarta.validation.constraints.NotNull;

public class EligibilityEmployeeRequest extends EligibilityRequest {

    @NotNull
    @Override
    public String getEmployeeId() {
        return super.getEmployeeId();
    }
}
