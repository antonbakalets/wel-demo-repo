package com.demo.wel.eligibility.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class EligibilityRepository {

    private static final String QUERY_EMPLOYEE = """
            SELECT member_unique_id,
                first_name,
                last_name,
                date_of_birth,
                eligibility_start_date,
                eligibility_end_date,
                employee_status,
                employee_group
            FROM eligibility_records
            WHERE member_unique_id = ?
                AND date_of_birth = ?
            """;

    private static final String QUERY_DEPENDENT = """
            SELECT member_unique_id,
                first_name,
                last_name,
                date_of_birth,
                eligibility_start_date,
                eligibility_end_date,
                employee_status,
                employee_group
            FROM eligibility_records
            WHERE first_name = ?
                AND last_name = ?
                AND date_of_birth = ?
            """;

    private final JdbcTemplate jdbcTemplate;

    public EligibilityRecord findEmployee(String employeeId, LocalDate dateOfBirth) {
        log.debug("Searching employee in the database.");
        return jdbcTemplate.queryForObject(QUERY_EMPLOYEE,
                new EligibilityRecordMapper(),
                employeeId, dateOfBirth.format(DateTimeFormatter.ISO_DATE));
    }

    public EligibilityRecord findDependent(String firstName, String lastName, LocalDate dateOfBirth) {
        log.debug("Searching dependent in the database.");
        return jdbcTemplate.queryForObject(QUERY_DEPENDENT,
                new EligibilityRecordMapper(),
                firstName, lastName, dateOfBirth.format(DateTimeFormatter.ISO_DATE));
    }
}
