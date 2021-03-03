package com.example.designpattern.codeSimplified.factoryDesignPattern;

public class SMSClient implements INotificationClient{

    @Override
    public void sendNotification(String sender, String receiver) {
        System.out.println("Sending SMS to " + receiver + " from " + sender);
    }
}
