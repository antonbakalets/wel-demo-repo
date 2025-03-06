package com.demo.wel.eligibility.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.demo.wel.eligibility.contract.EligibilityRequest;
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
    void verify() throws Exception {
        when(eligibilityService.verify(any(EligibilityRequest.class))).thenReturn(new EligibilityResponse());

        mockMvc.perform(post("/api/eligibility/verify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                  {
                                      "member_status": "employee",
                                      "employee_id": "123"
                                  }
                                  """))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

}