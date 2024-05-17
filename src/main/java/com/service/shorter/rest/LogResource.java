package com.service.shorter.rest;

import com.service.shorter.domain.LogEntry;
import com.service.shorter.service.LogService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/logs")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LogResource {

    LogService logService;

    @PostMapping
    public void saveLog(@RequestBody String logData) {
        System.out.println("logEntry: ======================================");
        System.out.println("logEntry: ====================================== "+ logData );
//        logService.saveLog(logEntry);
    }
}
