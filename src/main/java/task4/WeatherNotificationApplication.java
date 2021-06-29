package task4;

import task4.scheduler.TaskPlanner;
import task4.scheduler.WeatherTaskPlannerImpl;

public class WeatherNotificationApplication {

    public static void main(String[] args) {
        TaskPlanner taskPlanner = new WeatherTaskPlannerImpl();
        taskPlanner.planAndExecute();
    }
}
