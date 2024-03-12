package com.example.designpattern.logics.synchronization;

// Java program to illustrate
// Object lock concept
public class FunctionLevelSynchronization implements Runnable {

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
          fun1();
          fun2();
    }

    synchronized void fun1(){
        System.out.println("in block " + Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
        System.out.println("in block " + Thread.currentThread().getName() + " end");

    }

     synchronized void fun2(){
        System.out.println("in block2 " + Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
        System.out.println("in block2 " + Thread.currentThread().getName() + " end");

    }


    public static void main(String[] args)
    {
        FunctionLevelSynchronization object1 = new FunctionLevelSynchronization();
        Thread t1 = new Thread(object1);
        Thread t2 = new Thread(object1);
        Thread t3 = new Thread(object1);
        Thread t4 = new Thread(object1);
        Thread t5 = new Thread(object1);


        t1.setName("obj1-t1");
        t2.setName("obj1-t2");
        t3.setName("obj1-t3");
        t4.setName("obj1-t4");
        t5.setName("obj1-t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

//        object1.fun();
//        object1.fun();
//        object1.fun();
//        object1.fun();
//        object1.fun();
//        object1.fun();


    }
}
