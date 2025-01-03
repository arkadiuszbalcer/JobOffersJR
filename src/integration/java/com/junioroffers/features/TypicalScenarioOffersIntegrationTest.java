package com.junioroffers.features;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.junioroffers.BaseIntegrationTest;
import com.junioroffers.infrastracture.offer.scheduler.HttpOffersScheduler;
import  org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.time.Duration;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;

public class TypicalScenarioOffersIntegrationTest extends BaseIntegrationTest implements SampleJobOffersResponse {

    @Autowired
    HttpOffersScheduler httpOffersScheduler;
    @Test
    public void user_want_to_see_offers_but_have_to_be_logged_and_external_server_should_have_some_offers() {
        // step 1: there are no offers in external HTTP server
        wireMockServer.stubFor(WireMock.get("/offers")
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", "application/json")
                        .withBody(bodyWithOneOfferJson())));


        // step 2: scheduler ran 1st time and made GET to external server and system added 0 offers to database

        await()
                .atMost(Duration.ofSeconds(20))
                .until(()-> false);

        //step 3: user tried to get JWT token by requesting POST /token with username=someUser, password=somePassword and system returned UNAUTHORIZED(401)
        //step 4: user made GET /offers with no jwt token and system returned UNAUTHORIZED(401)
        //step 5: user made POST /register with username=someUser, password=somePassword and system registered user with status CREATED(201)
        //step 6: user tried to get JWT token by requesting POST /token with username=someUser, password=somePassword and system returned OK(200) and jwttoken=AAAA.BBBB.CCC
        //step 7: user made GET /offers with header “Authorization: Bearer AAAA.BBBB.CCC” and system returned OK(200) with 0 offers
        //step 8: there are 2 new offers in external HTTP server
        //step 9: scheduler ran 2nd time and made GET to external server and system added 2 new offers with ids: 1000 and 2000 to database
        //step 10: user made GET /offers with header “Authorization: Bearer AAAA.BBBB.CCC” and system returned OK(200) with 2 offers with ids: 1000 and 2000
        //step 11: user made GET /offers/9999 and system returned NOT_FOUND(404) with message “Offer with id 9999 not found”
        //step 12: user made GET /offers/1000 and system returned OK(200) with offer
        //step 13: there are 2 new offers in external HTTP server
        //step 14: scheduler ran 3rd time and made GET to external server and system added 2 new offers with ids: 3000 and 4000 to database
        //step 15: user made GET /offers with header “Authorization: Bearer AAAA.BBBB.CCC” and system returned OK(200) with 4 offers with ids: 1000,2000, 3000 and 4000
        //step 16: user made POST /offers with header “Authorization: Bearer AAAA.BBBB.CCC” and offer as body and system returned CREATED(201) with saved offer
        //step 17: user made GET /offers with header “Authorization: Bearer AAAA.BBBB.CCC” and system returned OK(200) with 5 offers
    }
}
