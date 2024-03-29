package com.example.designpattern.codeSimplified.singletonExample;

public class SingletonLazyUsingInnerClass {

    private SingletonLazyUsingInnerClass(){
    }


    private static class SingletonHolder{
        private static final SingletonLazyUsingInnerClass singletonLazy = new SingletonLazyUsingInnerClass();

    }

    public static SingletonLazyUsingInnerClass getSingletonEager() {
        return SingletonHolder.singletonLazy;
    }

}

