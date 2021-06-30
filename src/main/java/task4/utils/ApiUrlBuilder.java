package task4.utils;

import task4.constants.ConstantStorage;

/**
 * a class simplifies to get compiled url to pass to service for GET request
 */
public class ApiUrlBuilder {

    /**
     * method combines api url, city name, units and key for the weather api channel
     *
     * @return String representation of url
     */
    public static String getWeatherApiEndpoint() {
        StringBuilder urlBuilder = new StringBuilder("");
        urlBuilder.append("http://api.openweathermap.org/data/2.5/weather?q=");
        urlBuilder.append(ConstantStorage.THESSALONIKI.getValue());
        urlBuilder.append("&units=metric");
        urlBuilder.append("&appid=");
        urlBuilder.append(ConstantStorage.WEATHER_API_KEY.getValue());

        return urlBuilder.toString();
    }
}
