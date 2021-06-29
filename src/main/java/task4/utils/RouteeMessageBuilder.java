package task4.utils;

/**
 * utility class helps to create body message for Routee service
 */
public class RouteeMessageBuilder {

    /**
     * method transform incoming params into Routee service template for message to be send via SmsSender
     * @param message String phrase to be sent to user
     * @param numberTo String representation of phone number
     * @param sender String representation of sender
     * @return String representation of built JSON to be passed as a body param to Routee service
     */
    public static String createMessage(String message, String numberTo, String sender) {
        StringBuilder messageBuilder = new StringBuilder("");
        messageBuilder.append("{\"body\":\"").append(message);
        messageBuilder.append("\",\"to\":\"").append(numberTo);
        messageBuilder.append("\",\"from\":\"").append(sender).append("\"}");

        return messageBuilder.toString();
    }
}
