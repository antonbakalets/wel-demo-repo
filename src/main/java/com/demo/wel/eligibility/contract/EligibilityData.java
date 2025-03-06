package com.demo.wel.eligibility.contract;

import com.demo.wel.eligibility.domain.EligibilityRecord;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EligibilityData {

    private String memberUniqueId;

    private String firstName;

    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate eligibilityStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate eligibilityEndDate;

    private String employeeStatus;

    private String employeeGroup;

    public static EligibilityData of(EligibilityRecord record) {
        return EligibilityData.builder()
                .memberUniqueId(record.getMemberUniqueId())
                .firstName(record.getFirstName())
                .lastName(record.getLastName())
                .dateOfBirth(record.getBirthDate())
                .eligibilityStartDate(record.getEligibilityStartDate())
                .eligibilityEndDate(record.getEligibilityEndDate())
                .employeeStatus(record.getEmployeeStatus())
                .employeeGroup(record.getEmployeeGroup())
                .build();
    }
}
