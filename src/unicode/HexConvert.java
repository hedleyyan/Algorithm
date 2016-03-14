package unicode;

public class HexConvert {
    public static void main(String[] args) {
        int n1 = 14;
      //十进制转成十六进制：
      Integer.toHexString(n1);
      //十进制转成八进制
      Integer.toOctalString(n1);
      //十进制转成二进制
      Integer.toBinaryString(12);

      //十六进制转成十进制
      Integer.valueOf("FFFF",16).toString();
      //十六进制转成二进制
      Integer.toBinaryString(Integer.valueOf("FFFF",16));
      //十六进制转成八进制
      Integer.toOctalString(Integer.valueOf("FFFF",16));

      //八进制转成十进制
      Integer.valueOf("576",8).toString();
      //八进制转成二进制
      Integer.toBinaryString(Integer.valueOf("23",8));
      //八进制转成十六进制
      Integer.toHexString(Integer.valueOf("23",8));

      //二进制转十进制
      Integer.valueOf("0101",2).toString();
      //二进制转八进制
      Integer.toOctalString(Integer.parseInt("0101", 2));
      
      
//      1101 1000 0111 1100
//      1101 1111 0000 0000
      
      //二进制转十六进制
      System.out.println(Integer.toHexString(Integer.parseInt("1101100001111100", 2)));
      System.out.println(Integer.toHexString(Integer.parseInt("1101100010111100", 2)));
      System.out.println(Integer.toHexString(Integer.parseInt("1101111100000000", 2)));
      
      
      int b1 = Integer.valueOf("D7C0",16);
      int b2 = Integer.valueOf("D800",16);
      
      int extra = Integer.valueOf("1111100",2);
      
      System.out.println(Integer.toHexString(b1 + extra));
      System.out.println(Integer.toHexString(b2 + extra));
      
      System.out.println("\ud83c\udf00");
      System.out.println("\ud87c\udf00");
      
      char l1 = '\ud83c';
      char l2 = '\udf00';
      System.out.println(l1);
      System.out.println(l2);
      System.out.println(String.valueOf(new char[]{l1,l2}));
      
      
      int hexInt = Integer.parseInt("1F300", 16);
      String stringRepresentation = new String(Character.toChars(hexInt));
      System.out.println(stringRepresentation);
    }
}
