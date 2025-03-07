package com.demo.wel.audit;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuditService {

    private final AuditLogRepository auditLogRepository;

    public void logEvent(String requestParams, String ipAddress, String status, int responseCode) {
        AuditLog auditLog = AuditLog.builder()
                .time(LocalDateTime.now())
                .requestParams(maskSensitiveData(requestParams))
                .ipAddress(ipAddress)
                .resultStatus(status)
                .responseCode(responseCode)
                .build();

        log.debug("Logging for audit: {}", auditLog);
        auditLogRepository.save(auditLog);
    }

    private String maskSensitiveData(String requestParams) {
        return requestParams.replaceAll("(\"password\":\\s*)\"[^\"]+\"", "$1\"*****\"");
    }
}
