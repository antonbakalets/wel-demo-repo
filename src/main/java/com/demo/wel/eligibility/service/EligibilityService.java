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

    public EligibilityResponse visit(EligibilityEmployeeRequest employeeRequest) {
        log.info("Verifying eligibility for an employee.");
        eligibilityRepository.findEmployee(employeeRequest.getEmployeeId(), employeeRequest.getDateOfBirth());
        return new EligibilityResponse(EligibilityData.builder().build());
    }

    public EligibilityResponse visit(EligibilityDependentRequest dependentRequest) {
        log.debug("Verifying eligibility for a dependent.");
        eligibilityRepository.findDependent(dependentRequest.getFirstName(), dependentRequest.getLastName(), dependentRequest.getDateOfBirth());
        return new EligibilityResponse(EligibilityData.builder().build());
    }
}
