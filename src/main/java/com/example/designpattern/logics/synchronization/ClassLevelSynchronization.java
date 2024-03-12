package com.example.designpattern.logics.synchronization;

// Java program to illustrate
// Object lock concept
public class ClassLevelSynchronization implements Runnable {

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
        synchronized (ClassLevelSynchronization.class)
        {
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end");
        }
    }

    public static void main(String[] args)
    {
        ClassLevelSynchronization object1 = new ClassLevelSynchronization();
        Thread t1 = new Thread(object1);
        Thread t2 = new Thread(object1);
        Thread t3 = new Thread(object1);

        ClassLevelSynchronization object2 = new ClassLevelSynchronization();


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
