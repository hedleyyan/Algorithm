package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("\\b\\w+(?<!s)\\b");
        Pattern p2 = Pattern.compile("\\b\\w+[^s]\\b");
        
        Matcher m1 = p1.matcher("John's atxa jxl eixss");
        Matcher m2 = p2.matcher("ds John's asd ds xre ");
//        
//        while (m1.find()) {
//            System.out.println(m1.group());
//            System.out.println();
//        }
        
        while (m2.find()) {
            System.out.println(m2.group());
            System.out.println();
        }
    }
    
}
