package com.example.designpattern.codeSimplified.singletonExample;

public class SingletonMain {

    public static void main(String [] args){

        /**
         * lazy initialization
         */
//        SingletonLazy singletonLazy = SingletonLazy.getSingletonLazy();
//        System.out.println(singletonLazy);
//        SingletonLazy singletonLazy1 = SingletonLazy.getSingletonLazy();
//        System.out.println(singletonLazy1);

        SingletonEager singletonEager = SingletonEager.getSingletonLazy();
        System.out.println(singletonEager);
        SingletonEager singletonEager1 = SingletonEager.getSingletonLazy();
        System.out.println(singletonEager1);





    }
}
