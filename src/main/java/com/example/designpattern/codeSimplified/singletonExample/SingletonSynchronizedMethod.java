package com.example.designpattern.codeSimplified.singletonExample;

public class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod singletonSynchronizedMethod ;

    private SingletonSynchronizedMethod(){
    }

    public static synchronized   SingletonSynchronizedMethod getSingletonLazy() {
        //why read is made thread safe , no need for read
        if(singletonSynchronizedMethod==null){
            singletonSynchronizedMethod = new SingletonSynchronizedMethod();
        }
        return singletonSynchronizedMethod;
    }

}

