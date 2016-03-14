package callback;

public class A {

    private final Callback callback;

    public static interface Callback {
        public void begin();
        public void end();
        public void ex();
    }
    public A(Callback callback) {
        this.callback = callback;
    }
    public void doIt() {
        callback.begin();
        System.out.println("do something ...");
        callback.end();
    }
}