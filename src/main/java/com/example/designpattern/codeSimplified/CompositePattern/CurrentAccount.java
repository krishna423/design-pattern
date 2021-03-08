package com.example.designpattern.codeSimplified.CompositePattern;

public class CurrentAccount implements Account {
    private String accountNo;
    private int balance;

    public CurrentAccount(String accountNo, int balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
