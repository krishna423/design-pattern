package com.example.designpattern.codeSimplified.CompositePattern;

public class SavingAccount implements  Account{
    private String accountNo;
    private int balance;

    public SavingAccount(String accountNo, int balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
