package task4.utils;

import java.util.Base64;

/**
 * utility class which helps to encode a string to Base64 format
 */
public class Base64EncoderImpl implements Encoder {

    /**
     * method encodes a string into base64 format
     * @param input to be encode to base64 format
     * @return String in base64 format
     */
    @Override
    public String encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }
}
