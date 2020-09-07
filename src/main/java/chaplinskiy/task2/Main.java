package chaplinskiy.task2;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            FizzBuzz fizzBuzz = new FizzBuzz(i);
            int tempI = i;

            do{
                fizzBuzz.checkNumber(new Runnable() {
                    @Override
                    public void run() {
                        fizzBuzz.printNumber(tempI);
                    }
                }, i);

                fizzBuzz.checkFizzBuzz(new Runnable() {
                    @Override
                    public void run() {
                        fizzBuzz.printFizzBuzz();
                    }
                }, i);

                fizzBuzz.checkBuzz(new Runnable() {
                    @Override
                    public void run() {
                        fizzBuzz.printBuzz();
                    }
                }, i);

                fizzBuzz.checkFizz(new Runnable() {
                    @Override
                    public void run() {
                        fizzBuzz.printFizz();
                    }
                }, i);

            } while (!fizzBuzz.finish.get());

            fizzBuzz.finish.compareAndExchange(true, false);
        }
    }

}
