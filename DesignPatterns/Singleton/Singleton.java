package DesignPatterns.Singleton;

import lombok.Data;

@Data
public class Singleton {
    private static Singleton INSTANCE;
    private String info = "Initial info class";

    private Singleton() {
    }

    public synchronized static Singleton getInstance() {
        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
