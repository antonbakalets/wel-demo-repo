package com.demo.wel.eligibility.service;

import com.demo.wel.eligibility.contract.EligibilityRequest;
import com.demo.wel.eligibility.contract.EligibilityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EligibilityService {
    public EligibilityResponse verify(EligibilityRequest eligibilityRequest) {
        log.debug("Verifying  eligibility.");
        return new EligibilityResponse();
    }
}
