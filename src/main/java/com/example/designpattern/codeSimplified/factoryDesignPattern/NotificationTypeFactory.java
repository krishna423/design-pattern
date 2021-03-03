package com.example.designpattern.codeSimplified.factoryDesignPattern;

public class NotificationTypeFactory {

    //Pass bean instead of new Constructor
    public static INotificationClient getNotificationClientType(String type){
        switch (type.toUpperCase()){
            case "SMS" :
                return new SMSClient();
            case "EMAIL" :
                return new EmailClient();
            default:
                return null;
        }
    }
}
