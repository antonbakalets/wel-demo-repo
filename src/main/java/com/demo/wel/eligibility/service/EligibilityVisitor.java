package com.demo.wel.eligibility.service;

import com.demo.wel.eligibility.contract.EligibilityDependentRequest;
import com.demo.wel.eligibility.contract.EligibilityEmployeeRequest;

public interface EligibilityVisitor {

    void visit(EligibilityEmployeeRequest eligibilityEmployeeRequest);

    void visit(EligibilityDependentRequest eligibilityDependentRequest);
}
