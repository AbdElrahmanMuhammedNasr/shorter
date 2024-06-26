package com.service.shorter;

import com.service.shorter.config.LinksConfig;
 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LinksConfig.class})
@EnableScheduling
public class ShorterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShorterApplication.class, args);
	}

}
