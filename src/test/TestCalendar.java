package test;

import java.util.Calendar;

public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        
        info (calendar);
        
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        
//        info (calendar);
//        
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        
//        info (calendar);
//        
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        
//        info (calendar);
//        
//        calendar.add(Calendar.DAY_OF_MONTH, 18);
//        
//        info (calendar);
//        
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        
//        info (calendar);
        
        
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        info(calendar);
        
        System.out.println((int) ((calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000));
    }
    
    public static void info(Calendar calendar) {
//      System.out.println("Calendar.ERA --- " + calendar.get(Calendar.ERA));
      System.out.println("Calendar.YEAR --- " + calendar.get(Calendar.YEAR));
      System.out.println("Calendar.MONTH --- " + calendar.get(Calendar.MONTH));
//      System.out.println("Calendar.WEEK_OF_YEAR --- " + calendar.get(Calendar.WEEK_OF_YEAR));
//      System.out.println("Calendar.WEEK_OF_MONTH --- " + calendar.get(Calendar.WEEK_OF_MONTH));
//      System.out.println("Calendar.DATE --- " + calendar.get(Calendar.DATE));
      System.out.println("Calendar.DAY_OF_MONTH --- " + calendar.get(Calendar.DAY_OF_MONTH));
//      System.out.println("Calendar.DAY_OF_YEAR --- " + calendar.get(Calendar.DAY_OF_YEAR));
      System.out.println("Calendar.DAY_OF_WEEK --- " + calendar.get(Calendar.DAY_OF_WEEK));
//      System.out.println("Calendar.DAY_OF_WEEK_IN_MONTH --- " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//      System.out.println("Calendar.AM_PM --- " + calendar.get(Calendar.AM_PM));
      System.out.println("Calendar.HOUR --- " + calendar.get(Calendar.HOUR));
//      System.out.println("Calendar.HOUR_OF_DAY --- " + calendar.get(Calendar.HOUR_OF_DAY));
      System.out.println("Calendar.MINUTE --- " + calendar.get(Calendar.MINUTE));
      System.out.println("Calendar.SECOND --- " + calendar.get(Calendar.SECOND));
//      System.out.println("Calendar.MILLISECOND --- " + calendar.get(Calendar.MILLISECOND));
//      System.out.println("Calendar.ZONE_OFFSET --- " + calendar.get(Calendar.ZONE_OFFSET));
      System.out.println();
      System.out.println();
    }
}
