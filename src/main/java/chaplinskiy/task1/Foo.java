package chaplinskiy.task1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Foo {
    AtomicBoolean atomicBooleanFirst;
    AtomicBoolean atomicBooleanSecond;
    AtomicBoolean atomicBooleanThird;

    public Foo() {
        atomicBooleanFirst = new AtomicBoolean(true);
        atomicBooleanSecond = new AtomicBoolean(false);
        atomicBooleanThird = new AtomicBoolean(false);
    }


    public void first(Runnable r){
        if (atomicBooleanFirst.get()){
            atomicBooleanSecond.compareAndSet(false, true);
            atomicBooleanFirst.compareAndSet(true, false);

            r.run();
        }

    }

    public void second(Runnable r){

        if (atomicBooleanSecond.get()){
            atomicBooleanThird.compareAndSet(false, true);
            atomicBooleanSecond.compareAndSet(true, false);

            r.run();
        }
    }

    public void third(Runnable r){

        if (atomicBooleanThird.get()){
            r.run();
        }
    }

    public void first(){
        System.out.print("one");
    }
    public void second(){
        System.out.print("two");
    }
    public void third(){
        System.out.print("three");
    }

}
