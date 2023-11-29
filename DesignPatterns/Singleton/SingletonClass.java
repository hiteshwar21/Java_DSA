package DesignPatterns.Singleton;

import lombok.Data;

@Data
public class SingletonClass {
    private static volatile SingletonClass INSTANCE;
    public String info = "Initial info class";

    private SingletonClass() {
        System.out.println("Singleton Class created");
    }

    public static SingletonClass getInstance() {
        if(INSTANCE == null){
            synchronized (SingletonClass.class){
                if( INSTANCE == null) {
                    INSTANCE = new SingletonClass();
                }
            }
        }
        return INSTANCE;
    }
}
