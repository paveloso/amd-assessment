package task4.parser;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class helps to extract a temperature value from the JSON response from the weather server
 */
public class WeatherResponseParser implements Function<String, Double> {

    private final String TEMP_KEYWORD = "\"temp\":";

    @Override
    public Double apply(String s) {
        String regex = "\"temp\":\\d{1,}.\\d{0,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        Double tempValue = null;
        if (matcher.find()) {
            tempValue = Double.parseDouble(s.substring(matcher.start() + TEMP_KEYWORD.length(), matcher.end()));
        } else {
            tempValue = 0d;
        }

        return tempValue;
    }
}
