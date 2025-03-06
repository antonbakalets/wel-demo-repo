package com.demo.wel.eligibility.contract;

import com.demo.wel.eligibility.service.EligibilityVisitor;
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

    @Override
    public void accept(EligibilityVisitor eligibilityVisitor) {
        eligibilityVisitor.visit(this);
    }
}
