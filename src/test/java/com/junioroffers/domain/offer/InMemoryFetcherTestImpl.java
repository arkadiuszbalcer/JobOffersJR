package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.JobOfferResponse;
import com.junioroffers.domain.offer.dto.JobOfferResponseDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Profile("test")
@Service
public class InMemoryFetcherTestImpl implements OfferFetchable{
    List<JobOfferResponseDto> listOfOffers;

    InMemoryFetcherTestImpl(List<JobOfferResponseDto> listOfOffers) {
        this.listOfOffers = listOfOffers;
    }

    @Override
    public List<JobOfferResponseDto> fetchOffersToJobOfferResponseDto() {
        return listOfOffers;
    }



    @Override
    public List<JobOfferResponse> fetchOffersToJobOfferResponse() {
        return null;
    }
}