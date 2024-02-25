package com.example.designpattern.logics.Spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Controller {

    @Autowired
    private Payment payment;

    void doTransaction(){
        payment.transaction();
    }
}
