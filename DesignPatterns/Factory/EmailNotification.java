package DesignPatterns.Factory;

public class EmailNotification implements Notification{

    @Override
    public void notifyUser() {
        System.out.println("Email Notification");
    }
}
