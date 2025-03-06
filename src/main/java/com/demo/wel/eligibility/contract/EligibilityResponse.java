package com.demo.wel.eligibility.contract;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"status", "data"})
public class EligibilityResponse extends BaseResponse {

    private final EligibilityData data;

    public EligibilityResponse(EligibilityData data) {
        super("success");
        this.data = data;
    }
}
