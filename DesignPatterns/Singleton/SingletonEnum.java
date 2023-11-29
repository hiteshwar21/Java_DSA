package DesignPatterns.Singleton;

public enum SingletonEnum {
    INSTANCE;
    String info = "Initial info class";

    public void show() {
        System.out.println(info);
    }
}
