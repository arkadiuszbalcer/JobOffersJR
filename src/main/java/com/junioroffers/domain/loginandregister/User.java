package com.junioroffers.domain.loginandregister;

import lombok.Builder;

@Builder
public record User(
        String id,
        String username,
        String surname,
        String email,
        String password
) {

}
