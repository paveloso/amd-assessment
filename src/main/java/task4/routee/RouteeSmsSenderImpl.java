package task4.routee;

import task4.http.HttpRequestMaker;
import task4.http.HttpRequestMakerImpl;
import task4.utils.RouteeMessageBuilder;

/**
 * implements SmsSender interface for Routee service to simplify sms sending
 */
public class RouteeSmsSenderImpl implements SmsSender {
    private static final String APPLICATION_SMS_URL = "https://connect.routee.net/sms";
    private static final String NUMBER_TO = "+306922222222";
    private static final String SENDER = "amdTelecom";
    private static final String CONTENT_TYPE_HEADER = "application/json";

    private final HttpRequestMaker httpRequestMaker = new HttpRequestMakerImpl();
    private final RouteeAuthenticatorImpl routeeAuthenticator = new RouteeAuthenticatorImpl();

    /**
     * implements logic for Routee service to send sms, the user just need to pass the message,
     * the rest is preconfigured
     *
     * @param message string which needs to be passed as a sms message
     */
    @Override
    public void sendSms(String message) {
        String authorizationHeader = "Bearer " + routeeAuthenticator.getAuthToken();
        String body = RouteeMessageBuilder.createMessage(message, NUMBER_TO, SENDER);
        httpRequestMaker.sendPostRequest(APPLICATION_SMS_URL, body, CONTENT_TYPE_HEADER, authorizationHeader);
    }
}
