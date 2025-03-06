package com.demo.wel.eligibility.contract;

import com.demo.wel.eligibility.service.EligibilityVisitor;
import jakarta.validation.constraints.NotNull;

public class EligibilityDependentRequest extends EligibilityRequest {

    @NotNull
    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @NotNull
    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void accept(EligibilityVisitor eligibilityVisitor) {
        eligibilityVisitor.visit(this);
    }
}
