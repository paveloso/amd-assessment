package task4;

import task4.scheduler.TaskPlanner;
import task4.scheduler.WeatherTaskPlannerImpl;

/**
 * application that helps track the weather and notify the user it temperature changes
 */
public class WeatherNotificationApplication {

    public static void main(String[] args) {
        TaskPlanner taskPlanner = new WeatherTaskPlannerImpl();
        taskPlanner.planAndExecute();
    }
}
