package task4.utils;

import task4.constants.ConstantHolder;

public class ApiUrlBuilder {

    public static String getWeatherApiEndpoint() {
        StringBuilder urlBuilder = new StringBuilder("");
        urlBuilder.append("http://api.openweathermap.org/data/2.5/weather?q=");
        urlBuilder.append(ConstantHolder.THESSALONIKI);
        urlBuilder.append("&units=metric");
        urlBuilder.append("&appid=");
        urlBuilder.append(ConstantHolder.WEATHER_API_KEY);

        return urlBuilder.toString();
    }
}
