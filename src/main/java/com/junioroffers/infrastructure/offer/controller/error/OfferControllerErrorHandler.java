package com.junioroffers.infrastructure.offer.controller.error;

import com.junioroffers.domain.offer.OfferDuplicatedException;
import com.junioroffers.domain.offer.OfferNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;

@ControllerAdvice
@Log4j2
public class
OfferControllerErrorHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(OfferNotFoundException.class)
    @ResponseBody
    public OfferErrorResponse offerNotFound(OfferNotFoundException exception){
        final String message = exception.getMessage();
        log.error(message);
        return new OfferErrorResponse(message, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public OfferPostErrorResponse offerNotFound(OfferDuplicatedException exception){
        final String message = String.format("Offer with url %s already exists", exception.getOfferUrls());
        log.warn(message);
        return new OfferPostErrorResponse(Collections.singletonList(message), HttpStatus.CONFLICT);
    }

}
