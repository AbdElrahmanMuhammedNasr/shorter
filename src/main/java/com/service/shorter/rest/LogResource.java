package com.service.shorter.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.shorter.domain.LogEntry;
import com.service.shorter.service.LogService;
import com.service.shorter.vm.request.LogRequestVm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/api/logs")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LogResource {

    LogService logService;
    ObjectMapper objectMapper;
    @PostMapping()
    public void saveLog(@RequestBody LogRequestVm log) throws IOException {
        LogEntry logEntry = objectMapper.readValue(log.getMessage(), LogEntry.class);
        logService.saveLog(logEntry);
    }
}
