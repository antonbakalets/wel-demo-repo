package com.demo.wel.eligibility.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

public class EligibilityRecordMapper implements RowMapper<EligibilityRecord> {
    @Override
    public EligibilityRecord mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        return EligibilityRecord.builder()
                .memberUniqueId(rs.getString("member_unique_id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .birthDate(parseDate(rs, "date_of_birth"))
                .eligibilityStartDate(parseDate(rs, "eligibility_start_date"))
                .eligibilityEndDate(parseDate(rs, "eligibility_end_date"))
                .employeeGroup(rs.getString("employee_group"))
                .employeeStatus(rs.getString("employee_status"))
                .build();
    }

    private static LocalDate parseDate(ResultSet rs, String columnLabel) throws SQLException {
        String value = rs.getString(columnLabel);
        return value == null
                ? null
                : LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
    }

}
