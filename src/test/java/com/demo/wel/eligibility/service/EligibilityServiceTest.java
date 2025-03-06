package com.demo.wel.eligibility.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.demo.wel.eligibility.contract.EligibilityDependentRequest;
import com.demo.wel.eligibility.domain.EligibilityRecord;
import com.demo.wel.util.FunctionalException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class EligibilityServiceTest {

    @Test
    void validate() {
        EligibilityDependentRequest employeeRequest = new EligibilityDependentRequest();
        employeeRequest.setEmployeeCode("a1234");

        EligibilityRecord record1 = EligibilityRecord.builder().build();
        assertThatThrownBy(() -> EligibilityService.validate(record1, employeeRequest))
                .isInstanceOf(FunctionalException.class)
                .hasMessage("Employee group validation failed.");

        EligibilityRecord record2 = EligibilityRecord.builder().employeeGroup("a1234").build();

        assertThatThrownBy(() -> EligibilityService.validate(record2, employeeRequest))
                .isInstanceOf(FunctionalException.class)
                .hasMessage("Eligibility has expired.");
    }

    @Test
    void eligibilityExpired() {
        assertThat(EligibilityService.eligibilityExpired(null)).isTrue();
        assertThat(EligibilityService.eligibilityExpired(LocalDate.now().minusDays(1))).isTrue();
    }

    @Test
    void eligibilityNotExpired() {
        assertThat(EligibilityService.eligibilityExpired(LocalDate.now())).isFalse();
        assertThat(EligibilityService.eligibilityExpired(LocalDate.now().plusDays(1))).isFalse();
    }
}