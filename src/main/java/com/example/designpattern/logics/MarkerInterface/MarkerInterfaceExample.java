package com.example.designpattern.logics.MarkerInterface;

import java.io.Serializable;

public class MarkerInterfaceExample {

    public static void main(String[] args) {

        B b = new B() ;
        b.fun();

        C c = new C();
        c.fun();
    }
}

class A implements Deletable{

    native void fun() throws DeletableException;
}

class B extends A{
    @Override
    void fun(){
        try {
           // super.fun();
            System.out.println("Working marker interface");
        }catch (Exception e){

        }
    }
}

class C extends A{

}

interface Deletable{

}

class DeletableException extends RuntimeException{

}
