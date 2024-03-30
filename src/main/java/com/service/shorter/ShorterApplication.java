package com.service.shorter;

import com.service.shorter.config.LinksConfig;
 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LinksConfig.class})

public class ShorterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShorterApplication.class, args);
	}

}
