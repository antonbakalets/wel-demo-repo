package com.demo.wel.eligibility.service;

import com.demo.wel.eligibility.contract.EligibilityDependentRequest;
import com.demo.wel.eligibility.contract.EligibilityEmployeeRequest;
import com.demo.wel.eligibility.contract.EligibilityResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultEligibilityVisitor implements EligibilityVisitor {

    private final EligibilityService eligibilityService;
    @Getter
    private EligibilityResponse response;

    @Override
    public void visit(EligibilityEmployeeRequest eligibilityEmployeeRequest) {
        response = eligibilityService.visit(eligibilityEmployeeRequest);
    }

    @Override
    public void visit(EligibilityDependentRequest eligibilityDependentRequest) {
        response = eligibilityService.visit(eligibilityDependentRequest);
    }
}
