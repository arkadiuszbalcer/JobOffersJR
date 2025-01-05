package com.junioroffers.infrastracture.offer.http;

import com.junioroffers.domain.offer.OfferFetchable;
import com.junioroffers.domain.offer.dto.JobOfferResponse;
import com.junioroffers.domain.offer.dto.JobOfferResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Collections;
import java.util.List;
@AllArgsConstructor
@Log4j2
public class OfferHttpClient implements OfferFetchable {
    private final RestTemplate restTemplate;
    private final String uri;
    private final int port;

    @Override
    public List<JobOfferResponse> fetchOffersToJobOfferResponse() {
        return null;
    }

    @Override
    public List<JobOfferResponseDto> fetchOffersToJobOfferResponseDto() {
        log.info("Started fetching offers using http client");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(headers);
        try {
            String urlForService = getUrlForService("/offers");
            final String url = UriComponentsBuilder.fromHttpUrl(urlForService).toUriString();
            ResponseEntity<List<JobOfferResponseDto>> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
                    new ParameterizedTypeReference<>() {
                    });
            final List<JobOfferResponseDto> body = response.getBody();
            if (body == null) {
                log.info("Response Body was null returning empty List");
                return Collections.emptyList();
            }
            log.info("Success Response Body Returned  " + body);
            return body;
        } catch (ResourceAccessException e) {
            log.error("Error while fetching offers using http client" + e.getMessage());
        }
        return null;
    }

    private String getUrlForService(String service) {
        return uri + ":" + port + service;

    }
}


