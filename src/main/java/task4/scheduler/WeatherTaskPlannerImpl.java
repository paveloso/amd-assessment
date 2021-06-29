package task4.scheduler;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherTaskPlannerImpl implements TaskPlanner {

    private final int EXECUTE_TIMES = 10;

    private WeatherCheckerTask weatherCheckerTask = new WeatherCheckerTask();

    @Override
    public void planAndExecute() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, EXECUTE_TIMES * 10);
        executorService.scheduleAtFixedRate(weatherCheckerTask, 0, 10, TimeUnit.MINUTES);
        while (Calendar.getInstance().before(calendar)) {

        }
        executorService.shutdown();
    }
}
