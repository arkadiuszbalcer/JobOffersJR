package com.junioroffers.infrastructure.loginaandregister.controller.dto;

import lombok.Builder;

@Builder
public record JwtResponseDto(
        String username,
        String token
) {
}
