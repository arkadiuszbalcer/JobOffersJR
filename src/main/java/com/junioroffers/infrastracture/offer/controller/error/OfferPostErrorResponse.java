package com.junioroffers.infrastracture.offer.controller.error;

import org.springframework.http.HttpStatus;

import java.util.List;

public record OfferPostErrorResponse(
        List<String> message, HttpStatus status)
{ }
