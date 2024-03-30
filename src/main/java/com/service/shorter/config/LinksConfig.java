package com.service.shorter.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "links")
public record LinksConfig (int length, int iteration, String shortHost) {
}
