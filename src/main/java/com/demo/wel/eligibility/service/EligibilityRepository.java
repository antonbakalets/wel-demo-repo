package com.demo.wel.eligibility.service;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class EligibilityRepository {

    private final JdbcTemplate jdbcTemplate;

    public void findEmployee(String employeeId, LocalDate dateOfBirth) {
        log.debug("Searching employee in the database.");
    }

    public void findDependent(String firstName, String lastName, LocalDate dateOfBirth) {
        log.debug("Searching dependent in the database.");
    }
}
