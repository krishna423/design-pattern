package com.example.designpattern.logics.FunctionalInterface;


@FunctionalInterface
interface FunctionalInterfaceTest<T,U> {

    T apply (U u);

    default void test(){
        System.out.println("Default methods are allowed");
    }

    static void test2(){
        System.out.println("Static methods are allowed");
    }

}
