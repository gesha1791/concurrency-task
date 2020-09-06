package chaplinskiy.task1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        final AtomicBoolean atomicBooleanFirst = new AtomicBoolean(true);
        final AtomicBoolean atomicBooleanSecond = new AtomicBoolean(false);
        final AtomicBoolean atomicBooleanThird = new AtomicBoolean(false);
        MyThread b = new MyThread("B", TypeMethod.B, foo);
        MyThread a = new MyThread("A", TypeMethod.A, foo);
        MyThread c = new MyThread("C", TypeMethod.C, foo);

        while (true){
            if (atomicBooleanSecond.get()){
                b.start();
                b.join();
                atomicBooleanSecond.set(false);
                atomicBooleanThird.set(true);
            }

            if (atomicBooleanThird.get()) {
                c.start();
                c.join();
                atomicBooleanThird.set(false);
            }

            if (atomicBooleanFirst.get()){
                a.start();
                a.join();
                atomicBooleanFirst.set(false);
                atomicBooleanSecond.set(true);

            }

            if (!atomicBooleanFirst.get() && !atomicBooleanSecond.get() && !atomicBooleanThird.get()){
                break;
            }
        }

    }
}
