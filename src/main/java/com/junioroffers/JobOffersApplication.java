package com.junioroffers;

import com.junioroffers.infrastructure.security.jwt.offer.JwtConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(value = {JwtConfigurationProperties.class})
public class JobOffersApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobOffersApplication.class, args);
    }
}