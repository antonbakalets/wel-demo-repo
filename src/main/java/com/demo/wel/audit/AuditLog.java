package com.demo.wel.audit;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AuditLog {

    private Integer id;
    private LocalDateTime time;
    private String requestParams;
    private String ipAddress;
    private String resultStatus;
    private int responseCode;

}
