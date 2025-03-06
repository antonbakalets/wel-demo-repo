package com.demo.wel.eligibility.contract;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EligibilityData {

    private String memberUniqueId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String eligibilityStartDate;
    private String eligibilityEndDate;
    private String employeeStatus;
    private String employeeGroup;
}
