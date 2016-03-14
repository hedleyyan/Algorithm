package test;

public class Outer2 {
    public static int A = 10;
    int a = 10;
    
    public static void AB() {
        
    }
    
    static class Inner {
        public static void main(String[] args) {
            A = 20;
            System.out.println();
        }
    }
    
    void testO() {
        class Inner3 {
            class Inner4 {
                
            }
            
            void test() {
                testO();
                
                class Inner5 {
                    
                }
            }
        }
    }
    
    class Inner2 {
        
    }
    
    public static void main(String[] args) {
        System.out.println(String.format("%02d", Math.abs("novr222".hashCode() % 100)));
        
    }
    
}
