package task4.parser;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class contains single method which help to extract and return an access_token from the JSON server response
 */
public class RouteeAuthResponseParser implements Function<String, String> {

    private final String TOKEN_KEYWORD = "\"access_token\":";

    @Override
    public String apply(String s) {
        String regex = "\"access_token\":\"[A-Za-z0-9-]{1,}\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        String token = null;
        if (matcher.find()) {
            token = s.substring(matcher.start() + TOKEN_KEYWORD.length(), matcher.end());
        } else {
            token = "";
        }
        return token.replace("\"", "");
    }
}
