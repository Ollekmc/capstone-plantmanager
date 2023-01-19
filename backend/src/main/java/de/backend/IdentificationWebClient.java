package de.backend;

import de.backend.exception.IdentityException;
import de.backend.model.SpeciesIdentity;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

public class IdentificationWebClient {
    private WebClient webClient;
    private final String baseUrl;

    public IdentificationWebClient(String baseUrl) {
        this.baseUrl = baseUrl;
        setUp();
    }

    private void setUp(){
        this.webClient = WebClient.builder()
                .baseUrl(this.baseUrl)
                .build();
    }
    public List<SpeciesIdentity> getIdentity() throws IdentityException {

        SpeciesIdentity[] speciesIdentities = this.webClient
                .method(HttpMethod.GET)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(SpeciesIdentity[].class))
                .block();
        if (speciesIdentities != null) {
            return Arrays.asList(speciesIdentities);
        } else {
            throw new IdentityException();
        }
    }
}
