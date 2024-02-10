package com.example.designpattern.codeSimplified.singletonExample;

public class SingletonSynchronizedBlockWithVolatile {
    private static volatile SingletonSynchronizedBlockWithVolatile instance;
    //Why volatile -> in order to refer main memory instead of cpu cache

    private SingletonSynchronizedBlockWithVolatile(){
    }

    public static SingletonSynchronizedBlockWithVolatile getInstance() {
        if(instance ==null){
            synchronized (SingletonSynchronizedBlockWithVolatile.class){
                if(instance == null){
                    instance = new SingletonSynchronizedBlockWithVolatile();
                }
            }
        }
        return instance;
    }

}

