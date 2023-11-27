package DesignPatterns.Factory;

public class NotificationFactory {

    public Notification createNotification(String channel){
        if(channel == null || channel.isEmpty()){
            return null;
        }
        switch(channel) {
            case "SMS":
                return new SMSNotification();
            case "Email":
                return new EmailNotification();
            case "Push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}
