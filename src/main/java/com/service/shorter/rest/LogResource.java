package com.service.shorter.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.shorter.domain.LogEntry;
import com.service.shorter.service.LogService;
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
    @PostMapping(consumes = "application/json")
    public void saveLog(@RequestBody String logData) throws IOException {
            JsonNode jsonNode = objectMapper.readTree(logData);
            LogEntry logEntry = objectMapper.treeToValue(jsonNode, LogEntry.class);
            logService.saveLog(logEntry);
    }
}
