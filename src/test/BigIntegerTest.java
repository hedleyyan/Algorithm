package test;

import java.math.BigInteger;

public class BigIntegerTest {
    
    public static int i = 10;
    
    public static void main(String[] args) {
        BigInteger bi = new BigInteger(new byte[] {-1,0});
        System.out.println(bi);
        
        
        System.out.println( -1 >>> 2);
        
        
        System.out.println(test());
        System.out.println(i);
    }
    
    public static int test() {
        try {
            return i;
        } finally {
            for (int i = 0; i < 10; i++) {
                if (i == 1) {
                    continue;
                    
                }
            }
        }
    }
    
}
