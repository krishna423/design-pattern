package com.example.designpattern.codeSimplified.CompositePattern;

public class CompositeDesinPatternMain {

    public static  void  main(String [] a){

        SavingAccount savingAccount1 = new SavingAccount("savingSALARY",100);
        SavingAccount savingAccount2 = new SavingAccount("savingIND",16);
        CurrentAccount currentAccount1 = new CurrentAccount("CAIND",200);
        CurrentAccount currentAccount2 = new CurrentAccount("CACOM",250);

        CompositeAccount compositeAccount = new CompositeAccount();
        compositeAccount.addAccount(savingAccount1);
        compositeAccount.addAccount(savingAccount2);
        compositeAccount.addAccount(currentAccount1);
        compositeAccount.addAccount(currentAccount2);

        System.out.println(savingAccount1.getBalance());
        System.out.println(compositeAccount.getBalance());
        System.out.println(currentAccount2.getBalance());

    }
}
