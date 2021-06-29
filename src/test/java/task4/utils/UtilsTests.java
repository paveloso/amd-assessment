package task4.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTests {

    @Test
    void compareUrlWeatherEndpoint() {
        String expected = "http://api.openweathermap.org/data/2.5/weather?q=Thessaloniki&units=metric&appid=b385aa7d4e568152288b3c9f5c2458a5";
        String result = ApiUrlBuilder.getWeatherApiEndpoint();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void routeeMessageBuilderCorrectMessageStructure() {
        String result = RouteeMessageBuilder.createMessage("This is test message.", "+306922222222", "amdCandidate");
        String expected = "{\"body\":\"This is test message.\",\"to\":\"+306922222222\",\"from\":\"amdCandidate\"}";

        Assertions.assertEquals(expected, result);
    }

    @Test
    void encoderReturnsBase64String() {
        String result = new Base64EncoderImpl().encode("5756a411e4b06a33d50517c7:vb6QpjCIOG");
        String expected = "NTc1NmE0MTFlNGIwNmEzM2Q1MDUxN2M3OnZiNlFwakNJT0c=";

        Assertions.assertEquals(expected, result);
    }
}
