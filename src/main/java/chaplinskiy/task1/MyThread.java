package chaplinskiy.task1;

public class MyThread extends Thread {
    String name;
    TypeMethod typeMethod;
    Foo foo;

    public MyThread(String n, TypeMethod type, Foo f) {
        name = n;
        typeMethod = type;
        foo = f;
    }

    @Override
    public void run() {

        if (typeMethod.equals(TypeMethod.A)){
            foo.first();
        }

        if (typeMethod.equals(TypeMethod.B)){
            foo.second();
        }

        if (typeMethod.equals(TypeMethod.C)){
            foo.third();
        }



    }
}
