package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.JobOfferResponseDto;
import com.junioroffers.domain.offer.dto.OfferResponseDto;

import java.util.List;

public class Education {
    private final OfferFetchable offerFetchable;
    private final OfferRepository offerRepository;

    Education(OfferFetchable offerFetchable, OfferRepository offerRepository) {
        this.offerFetchable = offerFetchable;
        this.offerRepository = offerRepository;
    }

    public List<Offer> downloadOffers() {
        List<Offer> offers = fetchOffers();
      return offerRepository.saveAll(offers);
    }
    private List<Offer> fetchOffers() {
        return offerFetchable.fetchOffersToJobOfferResponseDto()
                .stream()
                .map(OfferMapper::mapFromJobOfferResponseToOffer)
                .toList();

    }
 }


