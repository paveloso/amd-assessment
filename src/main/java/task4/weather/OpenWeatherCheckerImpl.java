package task4.weather;

import task4.http.HttpRequestMaker;
import task4.http.HttpRequestMakerImpl;
import task4.parser.WeatherResponseParser;
import task4.utils.ApiUrlBuilder;

public class OpenWeatherCheckerImpl implements WeatherChecker {

    private HttpRequestMaker requestMaker = new HttpRequestMakerImpl();
    private WeatherResponseParser parser = new WeatherResponseParser();

    @Override
    public Double getTemperature() {
        return parser.apply(requestMaker.sendGetRequest(ApiUrlBuilder.getWeatherApiEndpoint()).body());
    }
}
