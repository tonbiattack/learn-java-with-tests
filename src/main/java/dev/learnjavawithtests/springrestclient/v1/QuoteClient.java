package dev.learnjavawithtests.springrestclient.v1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class QuoteClient {
    private final RestClient restClient;

    public QuoteClient(RestClient.Builder builder, @Value("${quotes.api.base-url:http://quotes.example}") String baseUrl) {
        this.restClient = builder.baseUrl(baseUrl).build();
    }

    public Quote fetchQuote(long id) {
        return restClient.get()
                .uri("/quotes/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new QuoteNotFoundException(id);
                })
                .body(Quote.class);
    }
}

