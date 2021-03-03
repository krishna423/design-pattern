package com.example.designpattern.codeSimplified.singletonExample;

public class SingletonEager {
    private static final SingletonEager singletonEager = new SingletonEager();

    private SingletonEager(){
    }

    public static SingletonEager getSingletonLazy() {
        return singletonEager;
    }

}

