package task4.parser;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class contains single method which help to extract and return an access_token from the JSON server response
 */
public class RouteeAuthResponseParser implements Function<String, String> {
    private static final String ACCESS_TOKEN_REG_EXP = "\"access_token\":\"[A-Za-z0-9-]{1,}\"";
    private static final String TOKEN_KEYWORD = "\"access_token\":";
    private static final int TOKEN_KEYWORD_LENGTH = TOKEN_KEYWORD.length();

    @Override
    public String apply(String s) {
        Pattern pattern = Pattern.compile(ACCESS_TOKEN_REG_EXP);
        Matcher matcher = pattern.matcher(s);

        return matcher.find()
                ? s.substring(matcher.start() + TOKEN_KEYWORD_LENGTH, matcher.end()).replace("\"", "")
                : "";
    }
}
