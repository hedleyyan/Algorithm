package test;

import java.math.BigDecimal;

public class FloatTest {
//        public static void main(String args[]) {
//            System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
//            
//            
//            float a = 2000000000F;
//            System.out.println(Math.ulp(a));
//            System.out.println(a + 1);
//            System.out.println(a);
//        }
//        
        
    public static void main(String[] args) throws Exception {
        // 自反性
        System.out.println(Double.NaN == Double.NaN);   // false
        
        // 传递性
        long x = Long.MAX_VALUE;
        double y = (double)Long.MAX_VALUE;
        long z = Long.MAX_VALUE - 1;
        System.out.print((x == y) + " ");   // Imprecise! true
        System.out.print((y == z) + " ");   // Imprecise! true
        System.out.println(x == z);         // Precise    false
    }
        
}
