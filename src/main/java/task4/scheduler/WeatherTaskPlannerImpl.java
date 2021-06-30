package task4.scheduler;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * implements TaskPlanner interface which allows to configure and schedule a task for execution
 */
public class WeatherTaskPlannerImpl implements TaskPlanner {

    private final int EXECUTE_DELAY = 0;
    private final int EXECUTE_TIMES = 10;
    private final int EXECUTE_PERIOD = 10;

    private final WeatherCheckerTask weatherCheckerTask = new WeatherCheckerTask();

    /**
     * method configures a task to check the weather and schedule it to run 10 times with 10 minutes interval
     */
    @Override
    public void planAndExecute() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, EXECUTE_TIMES * EXECUTE_PERIOD);
        executorService.scheduleAtFixedRate(weatherCheckerTask, EXECUTE_DELAY, EXECUTE_PERIOD, TimeUnit.MINUTES);
        while (Calendar.getInstance().before(calendar)) ;
        executorService.shutdown();
    }
}
