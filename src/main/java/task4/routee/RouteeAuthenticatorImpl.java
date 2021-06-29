package task4.routee;

import task4.http.HttpRequestMaker;
import task4.http.HttpRequestMakerImpl;
import task4.parser.RouteeAuthResponseParser;
import task4.utils.Base64EncoderImpl;
import task4.utils.Encoder;

import java.net.http.HttpResponse;

/**
 * implementation of the Authenticator interface for Routee service
 */
public class RouteeAuthenticatorImpl implements Authenticator {

    private static final String APPLICATION_URL = "https://auth.routee.net/oauth/token";
    private static final String APPLICATION_ID = "5c5d5e28e4b0bae5f4accfec";
    private static final String APPLICATION_SECRET = "MGkNfqGud0";

    private Encoder encoder = new Base64EncoderImpl();
    private HttpRequestMaker httpRequestMaker = new HttpRequestMakerImpl();
    private RouteeAuthResponseParser parser = new RouteeAuthResponseParser();

    /**
     * method help to authenticate a user in Routee service, building the authentication request
     * and returns response with token
     * @return HttpResponse from the server about authentication results
     */
    private HttpResponse authenticate() {

        String encodedAppParams = encoder.encode(APPLICATION_ID + ":" + APPLICATION_SECRET);
        String authorizationHeader = "Basic " + encodedAppParams;
        String contentTypeHeader = "application/x-www-form-urlencoded";
        String body = "grant_type=client_credentials";

        return httpRequestMaker.sendPostRequest(APPLICATION_URL, body, contentTypeHeader, authorizationHeader);
    }

    /**
     * methos takes the server response and extract the access_token if exist
     * @return access_token if it exist in server's response
     */
    @Override
    public String getAuthToken() {
        return parser.apply(authenticate().body().toString());
    }
}
