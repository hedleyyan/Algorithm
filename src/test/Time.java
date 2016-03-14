package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Time {
    public static void main(String[] args) {
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar c = Calendar.getInstance();
//        Date a = c.getTime();
//        String curDatetimeStr = simpleDateFormat.format(a);
//        System.out.println(curDatetimeStr);
//        c.add(Calendar.HOUR_OF_DAY, 1);
//        curDatetimeStr = simpleDateFormat.format( c);
//        System.out.println(curDatetimeStr);

        
        
        // 服务器激活当天应该刷新宝藏的时间
        Calendar activeCalendar = Calendar.getInstance();
        activeCalendar.setTimeInMillis(1426125901000L);
        activeCalendar.set(Calendar.HOUR_OF_DAY, 19);
        activeCalendar.set(Calendar.MINUTE, 0);
        activeCalendar.set(Calendar.SECOND, 0);
        activeCalendar.set(Calendar.MILLISECOND, 0);
        long activeTime = activeCalendar.getTimeInMillis();
        
        System.out.println(simpleDateFormat.format(activeCalendar.getTime()));
        
        // 现在的时间
        Calendar nowCalendar = Calendar.getInstance();
        long nowTime = nowCalendar.getTimeInMillis();
        
        // 刷新间隔
        int updateIntervalHours = 23;
        long updateInterval = TimeUnit.HOURS.toMillis(updateIntervalHours);
        System.out.println(updateInterval);
        
        // 现在距离第一次刷新宝藏过去的时间
        long passedSecondes = TimeUnit.MILLISECONDS.toMillis(nowTime - activeTime);
        
        // 距离上一次刷新的时间差
        long offset = passedSecondes % updateInterval;
        System.out.println(offset);
        
        // 下一次刷新的时间
        long nextTime = nowTime + updateInterval - offset;
        
        Calendar nextCal = Calendar.getInstance();
        nextCal.setTimeInMillis(nextTime);
        System.out.println(simpleDateFormat.format(nextCal.getTime()));
        
        System.out.println((nextTime - nowTime) / 1000L);    }
}
