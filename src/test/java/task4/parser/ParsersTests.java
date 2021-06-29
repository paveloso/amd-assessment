package task4.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Unit test for parser package classes
 */
public class ParsersTests {

    @Test
    void openWeatherParserReturnTempWhenFoundRegex() throws InterruptedException, IOException, URISyntaxException {
        String json = "{\"coord\":{\"lon\":22.9439,\"lat\":40.6403},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"base\":\"stations\",\"main\":{\"temp\":29.63,\"feels_like\":33.1,\"temp_min\":26.87,\"temp_max\":31.92,\"pressure\":1016,\"humidity\":65},\"visibility\":10000,\"wind\":{\"speed\":0.89,\"deg\":225,\"gust\":2.24},\"clouds\":{\"all\":0},\"dt\":1624950907,\"sys\":{\"type\":2,\"id\":2036703,\"country\":\"GR\",\"sunrise\":1624935599,\"sunset\":1624989789},\"timezone\":10800,\"id\":734077,\"name\":\"Thessaloniki\",\"cod\":200}";
        WeatherResponseParser parser = new WeatherResponseParser();

        Double result = parser.apply(json);

        Assertions.assertEquals(29.63d, result);
    }

    @Test
    void routeeTokenParserReturnTokenWhenFoundRegex() {
        String json = "{\"access_token\":\"cffae121-a41e-4b9a-86fb-47b26c022147\",\"token_type\":\"bearer\",\"expires_in\":3599,\"scope\":\"voice lookup virtual_number contact report sms 2step number_validator account failover number_pool forms transactional_email email_sender promotional_email email_validator url_analyzer\",\"permissions\":[\"MT_ROLE_LOOKUP\",\"MT_ROLE_NUMBER_VALIDATOR\",\"MT_ROLE_ACCOUNT_FINANCE\",\"MT_ROLE_SMS\",\"MT_ROLE_REPORT\",\"MT_ROLE_VOICE\",\"MT_ROLE_NUMBER_POOL\",\"MT_ROLE_2STEP\",\"MT_ROLE_VIRTUAL_NUMBER\",\"MT_ROLE_CONTACT\",\"MT_ROLE_FAILOVER\",\"MT_ROLE_FORMS\",\"MT_ROLE_TRANSACTIONAL_EMAIL\",\"MT_ROLE_EMAIL_SENDER\",\"MT_ROLE_PRICING_PACKAGES\",\"MT_ROLE_PROMOTIONAL_EMAIL\",\"MT_ROLE_EMAIL_VALIDATOR\",\"MT_ROLE_URL_ANALYZER\"]}";
        RouteeAuthResponseParser parser = new RouteeAuthResponseParser();
        String result = parser.apply(json);

        Assertions.assertEquals("cffae121-a41e-4b9a-86fb-47b26c022147", result);
    }
}
