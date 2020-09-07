package chaplinskiy.task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        foo.first(new Runnable() {
            @Override
            public void run() {
                foo.first();
            }
        });

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
    }
}
