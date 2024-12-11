package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.JobOfferResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OfferFetchable {
List<JobOfferResponseDto>fetchOffers();
}