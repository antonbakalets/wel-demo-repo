package com.demo.wel.eligibility.service;

import com.demo.wel.eligibility.contract.EligibilityData;
import com.demo.wel.eligibility.contract.EligibilityDependentRequest;
import com.demo.wel.eligibility.contract.EligibilityEmployeeRequest;
import com.demo.wel.eligibility.contract.EligibilityRequest;
import com.demo.wel.eligibility.contract.EligibilityResponse;
import com.demo.wel.eligibility.domain.EligibilityRecord;
import com.demo.wel.eligibility.domain.EligibilityRepository;
import com.demo.wel.util.ErrorCode;
import com.demo.wel.util.FunctionalException;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EligibilityService {

    private final EligibilityRepository eligibilityRepository;

    public EligibilityResponse visit(EligibilityEmployeeRequest employeeRequest) {
        log.info("Verifying eligibility for an employee.");
        EligibilityRecord record = eligibilityRepository.findEmployee(
                employeeRequest.getEmployeeId(), employeeRequest.getDateOfBirth());
        validate(record, employeeRequest);
        return new EligibilityResponse(EligibilityData.of(record));
    }

    public EligibilityResponse visit(EligibilityDependentRequest dependentRequest) {
        log.debug("Verifying eligibility for a dependent.");
        EligibilityRecord record = eligibilityRepository.findDependent(
                dependentRequest.getFirstName(), dependentRequest.getLastName(), dependentRequest.getDateOfBirth());
        validate(record, dependentRequest);
        return new EligibilityResponse(EligibilityData.of(record));
    }

    protected static void validate(EligibilityRecord record, EligibilityRequest employeeRequest) {
        if (!employeeRequest.getEmployeeCode().equals(record.getEmployeeGroup())) {
            throw new FunctionalException(ErrorCode.VALIDATION_ERROR,
                    "Employee group validation failed.", HttpStatus.FORBIDDEN);
        }
        if (eligibilityExpired(record.getEligibilityEndDate())) {
            throw new FunctionalException(ErrorCode.ELIGIBILITY_EXPIRED, "Eligibility has expired.");
        }
    }

    protected static boolean eligibilityExpired(LocalDate endDate) {
        return endDate == null || endDate.isBefore(LocalDate.now());
    }
}
