package task4.utils;

public class RouteeMessageBuilder {

    public static String createMessage(String message, String numberTo, String sender) {
        StringBuilder messageBuilder = new StringBuilder("");
        messageBuilder.append("{\"body\":\"").append(message);
        messageBuilder.append("\",\"to\":\"").append(numberTo);
        messageBuilder.append("\",\"from\":\"").append(sender).append("\"}");

        return messageBuilder.toString();
    }
}
