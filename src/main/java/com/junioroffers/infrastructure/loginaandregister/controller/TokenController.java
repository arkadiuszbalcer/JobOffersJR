package com.junioroffers.infrastructure.loginaandregister.controller;

import com.junioroffers.infrastructure.loginaandregister.controller.dto.JwtResponseDto;
import com.junioroffers.infrastructure.loginaandregister.controller.dto.TokenRequestDto;
import com.junioroffers.infrastructure.security.jwt.JwtAuthenticatorFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@AllArgsConstructor
@RestController
public class TokenController {
    private final JwtAuthenticatorFacade jwtAuthenticatorFacade;
    @PostMapping("/token")
    public ResponseEntity<JwtResponseDto> authenticateAndGenerateToken(@Valid @RequestBody TokenRequestDto tokenRequest){
        final JwtResponseDto jwtResponse = jwtAuthenticatorFacade.authenticateAndGenerateToken(tokenRequest);
        return ResponseEntity.ok(jwtResponse);
    }
}





