package com.demo.wel.eligibility.web;

import com.demo.wel.eligibility.contract.EligibilityRequest;
import com.demo.wel.eligibility.contract.EligibilityResponse;
import com.demo.wel.eligibility.service.EligibilityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EligibilityController {

    private final EligibilityService eligibilityService;

    @PostMapping("/api/eligibility/verify")
    public EligibilityResponse verify(@RequestBody @Valid EligibilityRequest eligibilityRequest) {
        return eligibilityService.verify(eligibilityRequest);
    }
}
