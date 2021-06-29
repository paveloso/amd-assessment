package task4.http;

import java.net.http.HttpResponse;

/**
 * interface offers methods to make GET/POST requests
 */
public interface HttpRequestMaker {
    HttpResponse<String> sendGetRequest(String url);
    HttpResponse<String> sendPostRequest(String url, String body, String contentTypeHeader, String authorizationHeader);
}
