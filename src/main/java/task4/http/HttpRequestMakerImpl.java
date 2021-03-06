package task4.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

/**
 * implements HttpRequestMaker interface and completes GET/POST requests
 */
public class HttpRequestMakerImpl implements HttpRequestMaker {

    private static final Logger LOGGER = Logger.getLogger(HttpRequestMakerImpl.class.getName());

    /**
     * implements and build GET request and sends it based on incoming URL param
     *
     * @param url String represents an endpoint for the request to be sent to
     * @return HttpResponse from server after sending the request
     */
    @Override
    public HttpResponse<String> sendGetRequest(String url) {
        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(url))
                    .GET()
                    .build();
            response = getResponse(request);
        } catch (URISyntaxException ex) {
            LOGGER.severe("Building request failed. Check your parameters.");
        }

        return response;
    }

    /**
     * implements and build POST request, completes with headers/body and sends it based on incoming URL param
     *
     * @param url                 api endpoint for the request to be sent to
     * @param body                String representation of the data to be passed as a body of request
     * @param contentTypeHeader   header for the 'content-type' parameter
     * @param authorizationHeader header for the 'authorization' parameter
     * @return HttpResponse received from server after the request was sent
     */
    @Override
    public HttpResponse<String> sendPostRequest(String url, String body, String contentTypeHeader, String authorizationHeader) {
        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(url))
                    .header("authorization", authorizationHeader)
                    .header("content-type", contentTypeHeader)
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            response = getResponse(request);
        } catch (URISyntaxException ex) {
            LOGGER.severe("Building request failed. Check your parameters.");
        }
        return response;
    }

    /**
     * method acquires response from the provided request
     *
     * @param request built request with parameters needed to be sent
     * @return HttpResponse from the provided request
     */
    private HttpResponse<String> getResponse(HttpRequest request) {
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            LOGGER.severe("Building response failed. Check your parameters.");
        }
        return response;
    }
}
