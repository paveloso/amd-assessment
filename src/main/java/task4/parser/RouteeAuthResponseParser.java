package task4.parser;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class contains single method which help to extract and return an access_token from the JSON server response
 */
public class RouteeAuthResponseParser implements Function<String, String> {
    private final String ACCESS_TOKEN_REG_EXP = "\"access_token\":\"[A-Za-z0-9-]{1,}\"";
    private final String TOKEN_KEYWORD = "\"access_token\":";
    private final int TOKEN_KEYWORD_LENGTH = TOKEN_KEYWORD.length();

    @Override
    public String apply(String s) {
        Pattern pattern = Pattern.compile(ACCESS_TOKEN_REG_EXP);
        Matcher matcher = pattern.matcher(s);

        String token = "";
        if (matcher.find()) {
            token = s.substring(matcher.start() + TOKEN_KEYWORD_LENGTH, matcher.end());
        }
        return token.replace("\"", "");
    }
}
