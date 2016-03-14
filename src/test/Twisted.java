
package test;

public class Twisted {
    private final String name;

    Twisted(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    private void reproduce() {
        new Twisted("reproduce") {
            void printName() {
                System.out.println(name());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Twisted("main").reproduce();
    }
    
    public class Inner {
        private void syso() {
            name();
        }
    }
}

class Outer3 extends Twisted {

    Outer3(String name) {
        super(name);
    }
    
    public static void main(String[] args) {
        float c = 1.0009765625F;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(c)));
        System.out.println(c);
        System.out.println(String.format("%.11f", c));
    }
    
//    
//    0 00111101 10011001100110011001101
    
//      0 01111011 10011001100110011001101
//      0.099999998
//      2^(-4) * 1.10011001100110011001101 = +2^(-4)+2^(-5)+2^(-8)+2^(-9)+2^(-12)+2^(-13)+2^(-16)+2^(-17)+2^(-20)+2^(-21)+2^(-24)+2^(-25)+2^(-28)
      

    
    
//      0 01111100 00000000000000000000000
//      1*2^-3
//      0.001

//    + 1+4+8+16+32-127=-66 
//    1.110011001100110011001101  *  2^(-66)
    
}
