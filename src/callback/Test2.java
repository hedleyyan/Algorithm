package callback;

public class Test2 {

}

interface CallBack {
    void methodToCallBack();
}

class CallBackImpl implements CallBack {
    public void methodToCallBack() {
        System.out.println("I've been called back");
    }
}

class CallBackDec implements CallBack {
    
    CallBack real;
    
    public CallBackDec(CallBack real) {
        this.real = real;
    }
    
    public void methodToCallBack() {
        System.out.println("decorate");
        real.methodToCallBack();
    }
}

class Caller {

    public void register(CallBack callback) {
        callback.methodToCallBack();
    }

    public static void main(String[] args) {
        Caller caller = new Caller();
        CallBack callBack = new CallBackImpl();
        CallBack callBack2 = new CallBackDec(callBack);
        caller.register(callBack2);
    }
} 