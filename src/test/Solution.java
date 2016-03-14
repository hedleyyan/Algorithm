package test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        
        String apm = time.substring(time.length() - 2);
        int hour = Integer.valueOf(time.substring(0, 2));
        if (hour >= 12) {
            hour -= 12;
        }
        
        if (apm.equals("PM")) {
            hour = hour + 12;
            if (hour == 24) {
                hour = 0;
            }
        }
        String hourStr = hour < 10 ? "0" + hour : "" + hour;
        System.out.println(hourStr + time.substring(2, time.length() - 2));
    }
}