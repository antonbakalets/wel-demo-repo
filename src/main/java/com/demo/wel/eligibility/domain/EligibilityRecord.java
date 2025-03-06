package com.demo.wel.eligibility.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EligibilityRecord {

    private String memberUniqueId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String employeeGroup;
    private LocalDate eligibilityEndDate;
}
