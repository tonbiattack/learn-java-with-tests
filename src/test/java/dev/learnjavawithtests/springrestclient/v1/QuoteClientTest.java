package dev.learnjavawithtests.springrestclient.v1;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class QuoteClientTest {

    @Test
    void fetchesAQuoteFromTheRemoteApi() {
        RestClient.Builder builder = RestClient.builder();
        MockRestServiceServer server = MockRestServiceServer.bindTo(builder).build();
        QuoteClient quoteClient = new QuoteClient(builder, "http://quotes.example");

        server.expect(requestTo("http://quotes.example/quotes/42"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("""
                        {"id":42,"text":"Stay curious","author":"Pepper"}
                        """, MediaType.APPLICATION_JSON));

        Quote quote = quoteClient.fetchQuote(42L);

        assertEquals(new Quote(42L, "Stay curious", "Pepper"), quote);
        server.verify();
    }

    @Test
    void convertsNotFoundToADomainException() {
        RestClient.Builder builder = RestClient.builder();
        MockRestServiceServer server = MockRestServiceServer.bindTo(builder).build();
        QuoteClient quoteClient = new QuoteClient(builder, "http://quotes.example");

        server.expect(requestTo("http://quotes.example/quotes/99"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));

        assertThrows(QuoteNotFoundException.class, () -> quoteClient.fetchQuote(99L));
        server.verify();
    }
}
