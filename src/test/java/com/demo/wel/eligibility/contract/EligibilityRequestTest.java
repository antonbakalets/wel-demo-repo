package com.demo.wel.eligibility.contract;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import org.junit.jupiter.api.Test;


class EligibilityRequestTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void memberStatusPropertyRequired() {
        assertThatThrownBy(() -> objectMapper.readValue("{}", EligibilityDependentRequest.class))
                .isInstanceOf(InvalidTypeIdException.class)
                .hasMessageContaining("missing type id property 'member_status'");
        assertThatThrownBy(() -> objectMapper.readValue("{}", EligibilityEmployeeRequest.class))
                .isInstanceOf(InvalidTypeIdException.class)
                .hasMessageContaining("missing type id property 'member_status'");
    }
}