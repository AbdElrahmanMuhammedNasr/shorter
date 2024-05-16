package com.service.shorter.service.impl;

import com.service.shorter.domain.LogEntry;
import com.service.shorter.repository.LogEntryRepository;
import com.service.shorter.service.LogService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LogServiceImpl implements LogService {
    LogEntryRepository logEntryRepository;
    @Override
    public void saveLog(LogEntry log) {
        logEntryRepository.save(log);
    }
}
