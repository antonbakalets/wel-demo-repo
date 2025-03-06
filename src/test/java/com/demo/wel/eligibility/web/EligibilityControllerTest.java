package com.demo.wel.eligibility.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.demo.wel.eligibility.contract.EligibilityDependentRequest;
import com.demo.wel.eligibility.contract.EligibilityEmployeeRequest;
import com.demo.wel.eligibility.contract.EligibilityResponse;
import com.demo.wel.eligibility.service.EligibilityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class EligibilityControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    EligibilityService eligibilityService;

    @Test
    void verifyEmployee() throws Exception {
        when(eligibilityService.visit(any(EligibilityEmployeeRequest.class))).thenReturn(new EligibilityResponse());

        mockMvc.perform(post("/api/eligibility/verify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                  {
                                      "employee_code": "e1",
                                      "member_status": "employee",
                                      "employee_id": "123"
                                  }
                                  """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "status": "success"
                        }
                        """));
    }

    @Test
    void verifyDependent() throws Exception {
        when(eligibilityService.visit(any(EligibilityDependentRequest.class))).thenReturn(new EligibilityResponse());

        mockMvc.perform(post("/api/eligibility/verify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                  {
                                      "employee_code": "d1",
                                      "member_status": "dependent",
                                      "employee_first_name": "First",
                                      "employee_last_name": "Last"
                                  }
                                  """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                          "status": "success"
                        }
                        """));
    }

}