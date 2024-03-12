package com.example.designpattern.logics.synchronization;

import java.util.concurrent.locks.Lock;

// Java program to illustrate
// Object lock concept
public class ObjectLevelSynchronization implements Runnable {

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
        synchronized (this)
        {
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end");
        }
    }

    public static void main(String[] args)
    {
        ObjectLevelSynchronization object1 = new ObjectLevelSynchronization();
        Thread t1 = new Thread(object1);
        Thread t2 = new Thread(object1);
        Thread t3 = new Thread(object1);

        ObjectLevelSynchronization object2 = new ObjectLevelSynchronization();


        //Lock is taking on this object
        //for t1,t2,t3 threads this object is same
        //for t4,t5 threads : this object is same
        Thread t4 = new Thread(object2);
        Thread t5 = new Thread(object2);


        t1.setName("obj1-t1");
        t2.setName("obj1-t2");
        t3.setName("obj1-t3");
        t4.setName("obj2-t4");
        t5.setName("obj2-t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
