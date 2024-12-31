package com.junioroffers.domain.offer;

import lombok.Getter;

import java.util.List;

@Getter
public class OfferDuplicatedException extends RuntimeException {
    private final List<String> offerUrls;

    public OfferDuplicatedException(String offerUrl) {
        super(String.format("Offer with offerUrl [%s] already exists", offerUrl));
        this.offerUrls = List.of(offerUrl);
    }

    public OfferDuplicatedException(String message, List<Offer> offers) {
        super(String.format("error" + message + offers.toString()));
        this.offerUrls = offers.stream().map(Offer::offerUrl).toList();
    }
}