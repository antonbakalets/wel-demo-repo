package com.demo.wel.eligibility.contract;

import com.demo.wel.eligibility.service.EligibilityVisitor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        property = "member_status")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EligibilityEmployeeRequest.class, name = "employee"),
        @JsonSubTypes.Type(value = EligibilityDependentRequest.class, name = "dependent"),
})
public abstract class EligibilityRequest {

    public abstract void accept(EligibilityVisitor eligibilityVisitor);

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}$")
    @JsonProperty("employee_code")
    private String employeeCode;

    @JsonProperty("employee_id")
    private String employeeId;

    @JsonProperty("employee_date_of_birth")
    private LocalDateTime employeeDateOfBirth;

    @JsonProperty("employee_first_name")
    private String employeeFirstName;

    @JsonProperty("employee_last_name")
    private String employeeLastName;

}
