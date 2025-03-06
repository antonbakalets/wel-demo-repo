package com.demo.wel.eligibility.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class EligibilityIT {

    @Autowired
    MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource({
            "integration/happy/employee1.json, integration/happy/output1.json",
            "integration/happy/dependent1.json, integration/happy/output1.json"
    })
    void verifyHappyPath(String input, String output) throws Exception {
        String requestJson = new ClassPathResource(input).getContentAsString(Charset.defaultCharset());
        String responseJson = new ClassPathResource(output).getContentAsString(Charset.defaultCharset());

        mockMvc.perform(post("/api/eligibility/verify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));
    }

    @ParameterizedTest
    @CsvSource({
            "integration/validation/employee1.json,integration/validation/pattern1.json",
            "integration/validation/dependent1.json,integration/validation/pattern1.json",
            "integration/validation/dependent2.json,integration/validation/dateformat1.json"
    })
    void verifyValidationError(String input, String output) throws Exception {
        String requestJson = new ClassPathResource(input).getContentAsString(Charset.defaultCharset());
        String responseJson = new ClassPathResource(output).getContentAsString(Charset.defaultCharset());

        mockMvc.perform(post("/api/eligibility/verify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(responseJson));
    }
}