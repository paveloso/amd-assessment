package task4.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

/**
 * Unit test for http package classes
 */
public class HttpMakersTests {

    private HttpRequestMaker requestMaker = new HttpRequestMakerImpl();

    @Test
    void getRequestReturnsNotNull() {
        final String url = "https://www.google.com";
        HttpResponse<String> response = requestMaker.sendGetRequest(url);

        Assertions.assertNotNull(response);
    }

    @Test
    void getRequestThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            final String url = "123";
            requestMaker.sendGetRequest(url);
        });
    }
}
