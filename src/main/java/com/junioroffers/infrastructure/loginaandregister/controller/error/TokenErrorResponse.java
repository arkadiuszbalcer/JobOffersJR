package com.junioroffers.infrastructure.loginaandregister.controller.error;

import org.springframework.http.HttpStatus;

public record TokenErrorResponse (String message,
                                  HttpStatus status){
}
