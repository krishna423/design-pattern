package com.example.designpattern.codeSimplified.singletonExample;

public class SingletonMain {

    public static void main(String [] args){

        /**
         * lazy initialization
         */
        SingletonLazy singletonLazy = SingletonLazy.getSingletonLazy();
        System.out.println(singletonLazy);
        SingletonLazy singletonLazy1 = SingletonLazy.getSingletonLazy();
        System.out.println(singletonLazy1);

        SingletonEager singletonEager = SingletonEager.getSingletonEager();
        System.out.println(singletonEager);
        SingletonEager singletonEager1 = SingletonEager.getSingletonEager();
        System.out.println(singletonEager1);

        SingletonSynchronizedMethod singletonSynchronizedMethod = SingletonSynchronizedMethod.getInstance();
        System.out.println(singletonSynchronizedMethod);
        SingletonSynchronizedMethod singletonSynchronizedMethod1 = SingletonSynchronizedMethod.getInstance();
        System.out.println(singletonSynchronizedMethod1);

        SingletonSynchronizedBlock singletonSynchronizedBlock = SingletonSynchronizedBlock.getInstance();
        System.out.println(singletonSynchronizedBlock);
        SingletonSynchronizedBlock singletonSynchronizedBlock1 = SingletonSynchronizedBlock.getInstance();
        System.out.println(singletonSynchronizedBlock1);







    }
}
