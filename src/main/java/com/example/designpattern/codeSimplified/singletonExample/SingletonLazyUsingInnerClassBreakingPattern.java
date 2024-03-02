package com.example.designpattern.codeSimplified.singletonExample;

import java.io.Serializable;

public class SingletonLazyUsingInnerClassBreakingPattern implements Cloneable, Serializable {

    static class SingletonHolder{
        private static final SingletonLazyUsingInnerClassBreakingPattern singletonLazy = new SingletonLazyUsingInnerClassBreakingPattern();
    }

    //    https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
//    Initialization-on-demand holder idiom
//    Since the class initialization phase is guaranteed by the JLS to be sequential,
//    i.e., non-concurrent, no further synchronization is required in the static getInstance method during loading
//    and initialization. And since the initialization phase writes the static variable INSTANCE in a sequential operation,
//    all subsequent concurrent invocations of the getInstance will return the same correctly initialized INSTANCE
//    without incurring any additional synchronization overhead

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

