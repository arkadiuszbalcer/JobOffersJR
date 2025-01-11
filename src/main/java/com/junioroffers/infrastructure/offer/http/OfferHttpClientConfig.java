package com.junioroffers.infrastructure.offer.http;
import com.junioroffers.domain.offer.OfferFetchable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class OfferHttpClientConfig {

    @Bean
    public RestTemplateResponseErrorHandler restTemplateResponseErrorHandler(){
        return new RestTemplateResponseErrorHandler();
    }

    @Bean
    public RestTemplate restTemplate(@Value("${offer.http.client.config.connectionTimeout:1000}") long connectionTimeout,
                                        @Value("${offer.http.client.config.readTimeout:1000}") long readTimeout,
                                        RestTemplateResponseErrorHandler restTemplateResponseErrorHandler) {
        return new RestTemplateBuilder()
                .errorHandler(restTemplateResponseErrorHandler)
                .setConnectTimeout(Duration.ofMillis(5000))
                .setReadTimeout(Duration.ofMillis(5000))
                .build();
    }

    @Bean
    public OfferFetchable remoteOfferClient(RestTemplate restTemplate,
                                         @Value("${offer.http.client.config.uri}") String uri,
                                         @Value("${offer.http.client.config.port}") int port) {
        return new OfferHttpClient(restTemplate, uri, port);
    }
}


