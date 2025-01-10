package com.junioroffers.domain.offer;
import com.junioroffers.domain.offer.OfferService;
import com.junioroffers.domain.offer.OfferFetchable;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@AllArgsConstructor
    @Configuration
    public class OfferFacadeConfiguration {


        @Bean
        OfferFacade offerFacade(OfferFetchable offerFetchable, OfferRepository repository) {
            OfferService offerService = new OfferService(offerFetchable, repository);
            return new OfferFacade(repository, offerService);
        }



    }
