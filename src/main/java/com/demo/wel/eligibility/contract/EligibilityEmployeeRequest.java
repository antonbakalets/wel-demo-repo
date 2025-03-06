package com.demo.wel.eligibility.contract;

import com.demo.wel.eligibility.service.EligibilityVisitor;
import jakarta.validation.constraints.NotNull;

public class EligibilityEmployeeRequest extends EligibilityRequest {

    @NotNull
    @Override
    public String getEmployeeId() {
        return super.getEmployeeId();
    }

    @Override
    public void accept(EligibilityVisitor eligibilityVisitor) {
        eligibilityVisitor.visit(this);
    }
}
