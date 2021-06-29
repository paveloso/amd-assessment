package task4.http;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public interface HttpRequestMaker {
    HttpResponse<String> sendGetRequest(String url);
    HttpResponse<String> sendPostRequest(String url, String body, String contentTypeHeader, String authorizationHeader);
}
