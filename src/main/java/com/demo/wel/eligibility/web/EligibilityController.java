package com.demo.wel.eligibility.web;

import com.demo.wel.eligibility.contract.EligibilityRequest;
import com.demo.wel.eligibility.contract.EligibilityResponse;
import com.demo.wel.eligibility.service.EligibilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EligibilityController {

    private final EligibilityService eligibilityService;

    @PostMapping("/api/eligibility/verify")
    public EligibilityResponse verify(EligibilityRequest eligibilityRequest) {
        return eligibilityService.verify(eligibilityRequest);
    }
}
