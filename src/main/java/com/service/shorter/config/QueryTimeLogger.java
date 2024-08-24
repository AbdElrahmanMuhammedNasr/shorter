package com.service.shorter.config;

import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QueryTimeLogger implements StatementInspector {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryTimeLogger.class);

    @Override
    public String inspect(String sql) {
        long startTime = System.currentTimeMillis();
        // Execution of the query
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Executed query [{}] in {} ms" + sql +" "+ executionTime);
        return sql;
    }
}
