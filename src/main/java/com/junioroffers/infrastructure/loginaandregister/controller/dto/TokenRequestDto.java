package com.junioroffers.infrastructure.loginaandregister.controller.dto;

import javax.validation.constraints.NotBlank;

public record TokenRequestDto(
    @NotBlank(message = "{username.not.blank}")
    String username,

    @NotBlank(message = "{password.not.blank}")
    String password
){
}

