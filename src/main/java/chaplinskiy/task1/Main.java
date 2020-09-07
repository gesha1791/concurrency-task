package chaplinskiy.task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        do {
            foo.second(new Runnable() {
                @Override
                public void run() {
                    foo.second();
                }
            });

            foo.third(new Runnable() {
                @Override
                public void run() {
                    foo.third();
                }
            });

            foo.first(new Runnable() {
                @Override
                public void run() {
                    foo.first();
                }
            });

        } while (!foo.finish.get());

    }
}
