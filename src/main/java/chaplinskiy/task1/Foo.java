package chaplinskiy.task1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Foo {
    AtomicBoolean atomicBooleanFirst;
    AtomicBoolean atomicBooleanSecond;
    AtomicBoolean atomicBooleanThird;

    AtomicBoolean finish;

    public Foo() {
        atomicBooleanFirst = new AtomicBoolean(true);
        atomicBooleanSecond = new AtomicBoolean(false);
        atomicBooleanThird = new AtomicBoolean(false);
        finish = new AtomicBoolean(false);
    }


    public void first(Runnable r){
        if (atomicBooleanFirst.get()){
            r.run();
            atomicBooleanSecond.compareAndSet(false, true);
            atomicBooleanFirst.compareAndSet(true, false);
        }

    }

    public void second(Runnable r){
        if (atomicBooleanSecond.get()){
            r.run();
            atomicBooleanThird.compareAndSet(false, true);
            atomicBooleanSecond.compareAndSet(true, false);
        }
    }

    public void third(Runnable r){
        if (atomicBooleanThird.get()){
            r.run();
            atomicBooleanThird.compareAndSet(true, false);
            finish.set(true);
        }
    }

    public void first(){
        System.out.print("one");
    }
    public void second(){
        System.out.print("two");
    }
    public void third(){
        System.out.print("third");
    }

}
