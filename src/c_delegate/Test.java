package c_delegate;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test implements Cloneable{
    
    int i = 0;

    
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
//        System.out.println(Math.ceil(-0.9));
        
        long bloodLost = (long)(1 * 12.3);
        
        System.out.println(bloodLost);
        
        int lostNum = (int)Math.ceil(bloodLost / 12.3);
        
        System.out.println(lostNum);
        
        Test t = new Test();
        t.stupid();
        Test t2 = (Test)t.clone();
        
        System.out.println(t.i);
        System.out.println(t2.i);
        System.out.println(t2.equals(t));
        
        System.out.println("a" + null);
        
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(1, 21);
        m.put(2, 21);
        System.out.println(m.toString());
        
        System.out.println(999999999 * 50);
        
//        String s = String.format("%d haha %s heihei", 1, "ha");
        String s = String.format("haha heihei %d", 1, "ha");
        System.out.println(s);
        
        
        String s1 = "1";
        String s2 = "2";
        double d1 = Double.valueOf(s1);
        double d2 = Double.valueOf(s2);
        double d3 = d1 + d2;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        String s3 = String.valueOf(d3);
        System.out.println(s3);
        
        
//        String ab = "963";  
//        System.out.println("1" + isNumber1(ab));  
//        System.out.println("2" + isNumber2(ab));  
//        System.out.println("3" + isNumber3(ab));
//        
//        int index = ab.indexOf(".");
//        System.out.println(index);
//        String newAb = ab.substring(0, index);
//        System.out.println(newAb);
        
        
        int[] types = new int[]{183,21,178,172,166,163,159,180,149,137,128,132,121,123,122,13,117,107,102,51,95};
        Arrays.sort(types);
        System.out.println(Arrays.binarySearch(types, 13)); 
        
    }
    
    
    
    public static boolean isNumber1(String str) {// 判断整型  
        return str.matches("^\\d+(\\.0*)?$$");  
    }  
      
    public static boolean isNumber2(String str) {// 判断小数，与判断整型的区别在与d后面的小数点（红色）  
        return str.matches("\\d+\\.\\d+$");  
    }  
      
    public static boolean isNumber3(String str) {// 判断小数点开头  
        return str.matches("\\.\\d+$");  
    }  
      
    
    
    
    
    public void stupid() {
        System.out.println();
        ++i;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Test)) {
            return false;
        }
        Test t = (Test)obj;
        return t.i == i;
    }
    
}
