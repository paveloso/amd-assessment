package task4.scheduler;

import task4.routee.RouteeSmsSenderImpl;
import task4.routee.SmsSender;
import task4.weather.OpenWeatherCheckerImpl;
import task4.weather.WeatherChecker;

import java.util.TimerTask;

/**
 * class represents Task which is responsible to check the weather data and notify a user about it result
 */
public class WeatherCheckerTask extends TimerTask {

    private final double TEMP_LIMIT = 20.0;
    private final String MESSAGE_TEMP_LESS = "Pavels and Temperature less than 20C. ";
    private final String MESSAGE_TEMP_MORE = "Pavels and Temperature more than 20C. ";

    private WeatherChecker weatherChecker = new OpenWeatherCheckerImpl();
    private SmsSender smsSender = new RouteeSmsSenderImpl();

    /**
     * method comparing the temperature value from weather channel with limit and send a sms to user
     */
    @Override
    public void run() {
        Double currentTemp = weatherChecker.getTemperature();
        if (TEMP_LIMIT > currentTemp) {
            smsSender.sendSms(MESSAGE_TEMP_LESS + currentTemp);
        } else {
            smsSender.sendSms(MESSAGE_TEMP_MORE + currentTemp);
        }
    }
}
