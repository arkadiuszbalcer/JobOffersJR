package com.junioroffers.domain.offer;

import com.junioroffers.domain.offer.dto.JobOfferResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class BeanConfiguration implements OfferFetchable{
    @Override
    public List<JobOfferResponseDto> fetchOffers() {
        return null;
    }
}
