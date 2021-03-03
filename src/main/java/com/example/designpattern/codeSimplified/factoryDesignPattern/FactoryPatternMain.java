package com.example.designpattern.codeSimplified.factoryDesignPattern;

import org.springframework.beans.factory.annotation.Autowired;

public class FactoryPatternMain {


    public static void main(String[] args){

           INotificationClient notificationClient = NotificationTypeFactory.getNotificationClientType("SMS");
           notificationClient.sendNotification("sms9634969965","sms7232933594");

           INotificationClient notificationClient1 = NotificationTypeFactory.getNotificationClientType("EMAIL");
           notificationClient1.sendNotification("email9634969965","email7232933594");
    }

}
