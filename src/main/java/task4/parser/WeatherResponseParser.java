package task4.parser;

import java.util.function.Function;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class helps to extract a temperature value from the JSON response from the weather server
 */
public class WeatherResponseParser implements Function<String, Double> {

    private static final Logger LOGGER = Logger.getLogger(WeatherResponseParser.class.getName());

    private final String TEMP_REG_EXP = "\"temp\":\\d{1,}.\\d{0,}";
    private final String TEMP_KEYWORD = "\"temp\":";
    private final int TEMP_KEYWORD_LENGTH = TEMP_KEYWORD.length();

    @Override
    public Double apply(String s) {
        Pattern pattern = Pattern.compile(TEMP_REG_EXP);
        Matcher matcher = pattern.matcher(s);

        double tempValue = 0d;
        if (matcher.find()) {
            try {
                tempValue = Double.parseDouble(s.substring(matcher.start() + TEMP_KEYWORD_LENGTH, matcher.end()));
            } catch (NumberFormatException ex) {
                LOGGER.severe("Invalid temperature value received for parsing");
            }
        }

        return tempValue;
    }
}
