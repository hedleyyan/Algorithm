package test;

import java.util.Calendar;


public class A {
    public static void main(String[] args) {
        int update_hour = 5;
        Calendar nowCalendar = Calendar.getInstance();
        Calendar targetCalendar = Calendar.getInstance();
        System.out.println(targetCalendar.get(Calendar.HOUR_OF_DAY));
        if (targetCalendar.get(Calendar.HOUR_OF_DAY) >= update_hour) {
            int refresh_interval_hour = 23;
            targetCalendar.add(Calendar.HOUR_OF_DAY, refresh_interval_hour);
            
            System.out.println(targetCalendar.get(Calendar.HOUR_OF_DAY));
        }
        targetCalendar.set(Calendar.HOUR_OF_DAY, update_hour);
        targetCalendar.set(Calendar.MINUTE, 0);
        targetCalendar.set(Calendar.SECOND, 0);
        targetCalendar.set(Calendar.MILLISECOND, 0);
        System.out.println((targetCalendar.getTimeInMillis() - nowCalendar.getTimeInMillis()) / 1000);
    }
}
