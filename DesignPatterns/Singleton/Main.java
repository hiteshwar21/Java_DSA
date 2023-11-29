package DesignPatterns.Singleton;

public class Main {
    public static void main(String[] args) {
        //Enum based implementation
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        singletonEnum1.show();

        singletonEnum1.info = "New Value";
        singletonEnum1.show();

        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;

        singletonEnum2.info = "Enum 2 tried";
        singletonEnum1.show();
        singletonEnum2.show();

        //Class based implementation
        SingletonClass singletonClass1 = SingletonClass.getInstance();
        System.out.println(singletonClass1.getInfo());

        SingletonClass singletonClass2 = SingletonClass.getInstance();
        singletonClass2.info = "Changed by class 2";

        System.out.println(singletonClass1.getInfo());
        System.out.println(singletonClass2.getInfo());


        //MultiThread Examples
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());

        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            SingletonClass singletonClass = SingletonClass.getInstance();
            singletonClass.setInfo("Foo");
            System.out.println(singletonClass.getInfo());
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            SingletonClass singletonClass = SingletonClass.getInstance();
            singletonClass.info = "Bar";
            System.out.println(singletonClass.getInfo());
        }
    }
}