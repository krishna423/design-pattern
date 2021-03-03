package com.example.designpattern.codeSimplified.factoryDesignPattern;

public class EmailClient implements INotificationClient{

    @Override
    public void sendNotification(String sender, String receiver) {
        System.out.println("Sending email to " + receiver + " from " + sender);
    }
}
