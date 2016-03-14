
package unicode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str = "中";
        char x = '中';
        byte[] bytes = null;
        byte[] bytes1 = null;
        try {
            bytes = str.getBytes("utf-8");
            bytes1 = charToByte(x);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("bytes 大小：" + bytes.length);
        System.out.println("bytes1大小：" + bytes1.length);
        
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes1));
        char c = '\ud83d';
        System.out.println(c + "");
        
        
        System.out.println("\\u" + Integer.toHexString(x | 0x10000).substring(1));
    }

    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte)((c & 0xFF00) >> 8);
        b[1] = (byte)(c & 0xFF);
        return b;
    }
}
