package task4.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task1.ArrayValidator;

import java.net.http.HttpResponse;

/**
 * Unit test for http package classes
 */
public class HttpMakersTests {

    private HttpRequestMaker requestMaker = new HttpRequestMakerImpl();

    @Test
    void getRequestReturnsNotNull() {
        HttpResponse<String> response = requestMaker.sendGetRequest("https://www.google.com");

        Assertions.assertNotNull(response);
    }

    @Test
    void getRequestThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> requestMaker.sendGetRequest("123"));
    }
}
