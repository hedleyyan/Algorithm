package test;

public class ThreadLocalTest {
    private static ThreadLocal<Car> car = new ThreadLocal<Car>();
    private static int l = 0;
    
    public static Car getDefaultCar() {
        Car agent = car.get();
        if (null == agent) {
            agent = new Car();
            car.set(agent);
        } else {
        }
        return agent;
    }
    
    public static void main(String[] args) {
        new EngineTest().say();
        
        new Thread () {
            public void run() {
                new EngineTest().say();
            };
        }.start();
        
    }
}


class Car {
    public static int id;
    
    public Car() {
        id++;
    }
    
    @Override
    public String toString() {
        return this.id + "";
    }
}


class DaoTest {
    public static Car car = null;
    
    public void say () {
        car = ThreadLocalTest.getDefaultCar();
        System.out.println(car);
    }
}

class EngineTest {
    private static DaoTest dt = new DaoTest();
    private static int a = 0;
//    private DaoTest dt = new DaoTest();
    
    public void say() {
        dt.say();
        System.out.println(a++);
        System.out.println(dt);
    }
}