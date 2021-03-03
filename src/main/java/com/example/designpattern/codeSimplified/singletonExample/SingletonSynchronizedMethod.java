package com.example.designpattern.codeSimplified.singletonExample;

public class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod(){
    }

    public static synchronized   SingletonSynchronizedMethod getInstance() {
        //why read is made thread safe , no need for read
        if(instance ==null){
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }

}

