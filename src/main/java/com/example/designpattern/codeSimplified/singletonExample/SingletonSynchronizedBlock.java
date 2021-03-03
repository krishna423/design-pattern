package com.example.designpattern.codeSimplified.singletonExample;

public class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod singletonSynchronizedMethod ;

    private SingletonSynchronizedMethod(){
    }

    public static synchronized   SingletonSynchronizedMethod getSingletonLazy() {
        if(singletonSynchronizedMethod==null){
            singletonSynchronizedMethod = new SingletonSynchronizedMethod();
        }
        return singletonSynchronizedMethod;
    }

}

