package com.service.shorter.repository;

import com.service.shorter.domain.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry,Long> {

}
