package com.junioroffers.infrastructure.security.jwt.offer;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("auth.jwt")
public record JwtConfigurationProperties(
        String secret,
        Long expirationDays,
        String issuer
) {
}
