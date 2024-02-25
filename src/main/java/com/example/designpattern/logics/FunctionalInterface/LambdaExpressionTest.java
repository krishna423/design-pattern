package com.example.designpattern.logics.FunctionalInterface;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExpressionTest {

    void display(){
        System.out.println("Print display method");
    }

    public static void main(String[] args) {

        //Without concrete class -> implementing of a interface which have only one function
        FunctionalInterfaceTest<String,Integer> functionalInterfaceTest1 = (x) -> "test : " + x ;
        FunctionalInterfaceTest<String,Integer> functionalInterfaceTest2 = (x) -> {return "test : " + x ; };

        System.out.println(functionalInterfaceTest1.apply(12));
        System.out.println(functionalInterfaceTest1.apply(121));
        System.out.println(functionalInterfaceTest1.apply(32));
        System.out.println(functionalInterfaceTest1.apply(15652));
        functionalInterfaceTest1.test();
        FunctionalInterfaceTest.test2();




        //Runnable
        //Callable
        //Function(T)->R
        //Consumer(T) ->void
        //Predicate(T)-> boolean
        //Supplier-> return T;


        Thread thread = new Thread( () -> new LambdaExpressionTest().display() );
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                new LambdaExpressionTest().display();
            }
        });
        thread1.start();

    }
}
