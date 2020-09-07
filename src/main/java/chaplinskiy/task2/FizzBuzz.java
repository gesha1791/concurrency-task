package chaplinskiy.task2;

import java.util.concurrent.atomic.AtomicBoolean;

public class FizzBuzz {
    private int n;

    AtomicBoolean checkFizzBuzz = new AtomicBoolean(true);
    AtomicBoolean checkFizz = new AtomicBoolean(false);;
    AtomicBoolean checkBuzz = new AtomicBoolean(false);;
    AtomicBoolean printNumber = new AtomicBoolean(false);;
    AtomicBoolean finish = new AtomicBoolean(false);;

    public FizzBuzz(int number) {
        n = number;
    }

    public void checkFizzBuzz(Runnable r, int n){
        if (checkFizzBuzz.get()){
            if (n % 3 == 0 && n%5 == 0){
                r.run();
                finish.compareAndSet(false, true);
            } else {
                checkFizz.compareAndSet(false, true);
            }
        }
    }

    public void checkFizz(Runnable r, int n){
        if (checkFizz.get()){
            if (n % 3 == 0){
                r.run();
                checkFizzBuzz.compareAndSet(false, true);
                finish.compareAndSet(false, true);
            } else {
                checkBuzz.compareAndSet(false, true);
                checkFizz.compareAndSet(true, false);
            }
        }
    }

    public void checkBuzz(Runnable r, int n){
        if (checkBuzz.get()){
            if (n % 5 == 0){
                r.run();
                checkFizzBuzz.compareAndSet(false, true);
                finish.compareAndSet(false, true);
            } else {
                checkBuzz.compareAndSet(true,false);
                printNumber.compareAndSet(false, true);
            }
        }
    }

    public void checkNumber(Runnable r, int n){
        if (printNumber.get()){
            r.run();
            checkFizzBuzz.compareAndSet(false, true);
            finish.compareAndSet(false, true);
        }
    }

    public void printFizzBuzz() {
        System.out.print("fizzbuzz.");
    }


    public void printFizz() {
        System.out.print("fizz" + " , ");
    }

    public void printBuzz() {
        System.out.print("buzz" + " , ");
    }

    public void printNumber(int n) {
        System.out.print(n + " , ");
    }
}
