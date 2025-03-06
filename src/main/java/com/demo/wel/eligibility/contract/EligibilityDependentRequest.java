package com.demo.wel.eligibility.contract;

import jakarta.validation.constraints.NotNull;

public class EligibilityDependentRequest extends EligibilityRequest {

    @NotNull
    @Override
    public String getEmployeeLastName() {
        return super.getEmployeeLastName();
    }

    @NotNull
    @Override
    public String getEmployeeFirstName() {
        return super.getEmployeeFirstName();
    }
}
