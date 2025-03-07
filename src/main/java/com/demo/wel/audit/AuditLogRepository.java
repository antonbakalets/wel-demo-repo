package com.demo.wel.audit;

import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuditLogRepository {

    private static final String INSERT_LOG = """
            INSERT INTO audit_logs (timestamp, request_params, ip_address, result_status, response_code)
            VALUES (?, ?, ?, ?, ?)
            """;

    private final JdbcTemplate jdbcTemplate;

    public void save(AuditLog auditLog) {
        jdbcTemplate.update(INSERT_LOG,
                auditLog.getTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                auditLog.getRequestParams(),
                auditLog.getIpAddress(),
                auditLog.getResultStatus(),
                auditLog.getResponseCode());
    }
}