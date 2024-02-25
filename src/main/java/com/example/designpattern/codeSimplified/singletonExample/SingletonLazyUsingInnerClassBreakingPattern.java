package com.example.designpattern.codeSimplified.singletonExample;

import java.io.Serializable;

public class SingletonLazyUsingInnerClassBreakingPattern implements Cloneable, Serializable {

    static class SingletonHolder{
        private static final SingletonLazyUsingInnerClassBreakingPattern singletonLazy = new SingletonLazyUsingInnerClassBreakingPattern();
    }

    private SingletonLazyUsingInnerClassBreakingPattern(){
        if(SingletonHolder.singletonLazy != null){
            throw new RuntimeException(" New object can not be created using reflection API");
        }
    }

    @Override
    public SingletonLazyUsingInnerClassBreakingPattern clone() {
        try {
            throw new CloneNotSupportedException();
           // return (SingletonLazyUsingInnerClassBreakingPattern) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }



    public static SingletonLazyUsingInnerClassBreakingPattern getSingletonLazy() {
        return SingletonHolder.singletonLazy;
    }


    //In order to avoid creation of multiple singleton bean using Serialization-deserialization
    Object readResolve(){
        return getSingletonLazy();
    }

}

