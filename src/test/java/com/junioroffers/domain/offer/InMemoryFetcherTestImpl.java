package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.JobOfferResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Profile("test")
@Service
public class InMemoryFetcherTestImpl implements OfferFetchable{
    List<JobOfferResponse> listOfOffers;
    InMemoryFetcherTestImpl(List<JobOfferResponse> listOfOffers) {
        this.listOfOffers = listOfOffers;
    }


    @Override
    public List<JobOfferResponse> fetchOffers() {
        return listOfOffers;
    }
}