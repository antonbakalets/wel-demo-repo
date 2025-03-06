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
        LocalDate eligibilityEndDate = LocalDate.parse(rs.getString("eligibility_end_date"), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate birthDate = LocalDate.parse(rs.getString("date_of_birth"), DateTimeFormatter.ISO_LOCAL_DATE);

        return EligibilityRecord.builder()
                .memberUniqueId(rs.getString("member_unique_id"))
                .memberUniqueId(rs.getString("first_name"))
                .memberUniqueId(rs.getString("last_name"))
                .birthDate(birthDate)
                .employeeGroup(rs.getString("employee_group"))
                .eligibilityEndDate(eligibilityEndDate)
                .build();
    }

}
