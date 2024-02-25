package com.example.designpattern.logics.Spring;

public class Paytm implements Payment {

    @Override
    public void transaction() {
        System.out.println("DO transaction using paytm");
    }
}
