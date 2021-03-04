package com.example.designpattern.codeSimplified.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeAccount implements Account{
    private int totalBalance;
    private List<Account> accountList = new ArrayList<Account>();


    @Override
    public int getBalance() {
        totalBalance = accountList.stream().mapToInt(Account::getBalance).sum();
        return totalBalance;
    }

    public void addAccount(Account account){
        accountList.add(account);
    }


}
