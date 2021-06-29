package task4.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class HttpRequestMakerImpl implements HttpRequestMaker {

    private static final Logger LOGGER = Logger.getLogger(HttpRequestMakerImpl.class.getName());

    @Override
    public HttpResponse<String> sendGetRequest(String url) {
        HttpRequest request = null;
        HttpResponse<String> response = null;
        try {
            request = HttpRequest.newBuilder(new URI(url))
                    .GET()
                    .build();
            response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException ex) {
            LOGGER.severe("Building request failed. Check your parameters.");
        }

        return response;
    }

    @Override
    public HttpResponse<String> sendPostRequest(String url, String body, String contentTypeHeader, String authorizationHeader) {
        HttpRequest request = null;
        HttpResponse<String> response = null;
        try {
            request = HttpRequest.newBuilder(new URI(url))
                    .header("authorization", authorizationHeader)
                    .header("content-type", contentTypeHeader)
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException ex) {
            LOGGER.severe("Building request failed. Check your parameters.");
        }


        return response;
    }
}
