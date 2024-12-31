package com.junioroffers.infrastracture.offer.http;
import com.junioroffers.domain.offer.OfferFetchable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class OfferHttpClientConfig {

    @Bean
    public RestTemplateErrorHandler restTemplateErrorHandler(){
        return new RestTemplateErrorHandler();
    }

    @Bean
    public RestTemplate offerHttpClient(@Value("${offer.http.client.config.connectionTimeout:1000}") long connectionTimeout,
                                        @Value("${offer.http.client.config.readTimeout:1000}") long readTimeout,
                                        RestTemplateErrorHandler restTemplateErrorHandler) {
        return new RestTemplateBuilder()
                .errorHandler(restTemplateErrorHandler)
                .setConnectTimeout(Duration.ofMillis(5000))
                .setReadTimeout(Duration.ofMillis(5000))
                .build();
    }

    @Bean
    public OfferFetchable offerFetchable(RestTemplate restTemplate,
                                         @Value("${offer.http.client.config.uri}") String uri,
                                         @Value("${offer.http.client.config.port}") int port) {
        return new OfferHttpClient(restTemplate, uri, port);
    }
}


