package task4.scheduler;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * implements TaskPlanner interface which allows to configure and schedule a task for execution
 */
public class WeatherTaskPlannerImpl implements TaskPlanner {

    private final int executeDelay;
    private final int executeTimes;
    private final int executePeriod;

    private final WeatherCheckerTask weatherCheckerTask = new WeatherCheckerTask(20.0);

    public WeatherTaskPlannerImpl(int executeDelay, int executeTimes, int executePeriod) {
        this.executeDelay = executeDelay;
        this.executeTimes = executeTimes;
        this.executePeriod = executePeriod;
    }

    /**
     * method configures a task to check the weather and schedule it to run 10 times with 10 minutes interval
     */
    @Override
    public void planAndExecute() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, executeTimes * executePeriod);
        executorService.scheduleAtFixedRate(weatherCheckerTask, executeDelay, executePeriod, TimeUnit.MINUTES);
        while (Calendar.getInstance().before(calendar)) ;
        executorService.shutdown();
    }
}
