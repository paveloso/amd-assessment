package task4.utils;

import java.util.Base64;

public class Base64EncoderImpl implements Encoder {

    @Override
    public String encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }
}
