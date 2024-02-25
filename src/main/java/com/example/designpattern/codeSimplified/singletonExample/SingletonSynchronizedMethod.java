package com.example.designpattern.codeSimplified.singletonExample;

public class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod(){
    }

    public static synchronized   SingletonSynchronizedMethod getInstance() {
        //why all read are made thread safe , no need to make subsequent calls thread safe
        if(instance ==null){
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }

}

