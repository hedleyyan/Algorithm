package callback;

import callback.A.Callback;

public class Context implements Callback {

    private A a;

    public void begin() {
        System.out.println("begin ...");
    }

    public void end() {
        System.out.println("end ...");
    }

    public Context() {
        this.a = new A(this);
    }

    public void ex() {
        this.a.doIt();
    }

}

class ContextB implements Callback {
    
    Callback real;
    
    public ContextB(Callback real) {
        this.real = real;
    }
    
    @Override
    public void begin() {
        System.out.println("B begin ...");
        real.begin();
    }

    @Override
    public void end() {
        System.out.println("B end ...");
        real.end();
    }
    
    public void ex() {
        System.out.println("B ex ...");
        real.ex();
    }
    
    public static void main(String args[]) {
        Callback real = new Context();
        new ContextB(real).ex();
    }
}


