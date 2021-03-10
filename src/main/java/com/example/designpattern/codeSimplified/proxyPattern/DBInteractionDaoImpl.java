package com.example.designpattern.codeSimplified.proxyPattern;

public class DBInteractionDaoImpl implements DBInteractionDao{

    @Override
    public void execute(String query) {
        System.out.println("executing DB query");
    }
}
