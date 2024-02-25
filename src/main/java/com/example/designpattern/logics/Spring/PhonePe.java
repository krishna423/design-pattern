package com.example.designpattern.logics.Spring;

public class PhonePe implements Payment {

    @Override
    public void transaction() {
        System.out.println("DO transaction using phonePe");
    }
}
