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

    private final double tempLimit;
    private static final String MESSAGE_TEMP_LESS = "Pavels and Temperature less than 20C. ";
    private static final String MESSAGE_TEMP_MORE = "Pavels and Temperature more than 20C. ";

    private WeatherChecker weatherChecker = new OpenWeatherCheckerImpl();
    private SmsSender smsSender = new RouteeSmsSenderImpl();

    public WeatherCheckerTask(double tempLimit) {
        this.tempLimit = tempLimit;
    }

    /**
     * method comparing the temperature value from weather channel with limit and send a sms to user
     */
    @Override
    public void run() {
        Double currentTemp = weatherChecker.getTemperature();
        smsSender.sendSms((tempLimit > currentTemp ? MESSAGE_TEMP_LESS : MESSAGE_TEMP_MORE) + currentTemp);
    }
}
