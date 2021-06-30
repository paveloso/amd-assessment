package task4.weather;

import task4.http.HttpRequestMaker;
import task4.http.HttpRequestMakerImpl;
import task4.parser.WeatherResponseParser;
import task4.utils.ApiUrlBuilder;

/**
 * implementation of WeatherCheck interface for OpenWeather api service
 */
public class OpenWeatherCheckerImpl implements WeatherChecker {

    private final HttpRequestMaker requestMaker = new HttpRequestMakerImpl();
    private final WeatherResponseParser parser = new WeatherResponseParser();

    /**
     * method takes HttpResponse from openweather server and parses in order to get temperature
     *
     * @return temperature value in Double format
     */
    @Override
    public Double getTemperature() {
        return parser.apply(requestMaker.sendGetRequest(ApiUrlBuilder.getWeatherApiEndpoint()).body());
    }
}
