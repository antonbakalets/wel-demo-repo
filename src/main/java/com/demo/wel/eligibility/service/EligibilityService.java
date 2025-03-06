package com.demo.wel.eligibility.service;

import com.demo.wel.eligibility.contract.EligibilityData;
import com.demo.wel.eligibility.contract.EligibilityDependentRequest;
import com.demo.wel.eligibility.contract.EligibilityEmployeeRequest;
import com.demo.wel.eligibility.contract.EligibilityResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EligibilityService {

    private final EligibilityRepository eligibilityRepository;

    public EligibilityResponse visit(EligibilityEmployeeRequest eligibilityEmployeeRequest) {
        log.info("Verifying eligibility for an employee: {}", eligibilityEmployeeRequest);
        return new EligibilityResponse(EligibilityData.builder().build());
    }

    public EligibilityResponse visit(EligibilityDependentRequest eligibilityDependentRequest) {
        log.debug("Verifying eligibility for a dependent: {}", eligibilityDependentRequest);
        return new EligibilityResponse(EligibilityData.builder().build());
    }
}
