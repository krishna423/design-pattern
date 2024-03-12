package com.example.designpattern.logics.synchronization;

// Java program to illustrate
// Object lock concept
public class ExplicitObjectLevelSynchronization implements Runnable {

    private Object lock= new Object();
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
        synchronized (lock)
        {
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end");
        }
    }

    public static void main(String[] args)
    {
        ExplicitObjectLevelSynchronization object1 = new ExplicitObjectLevelSynchronization();
        Thread t1 = new Thread(new ExplicitObjectLevelSynchronization());
        Thread t2 = new Thread(new ExplicitObjectLevelSynchronization());
        Thread t3 = new Thread(new ExplicitObjectLevelSynchronization());
        Thread t4 = new Thread(new ExplicitObjectLevelSynchronization());
        Thread t5 = new Thread(new ExplicitObjectLevelSynchronization());

        //No thread locking will happen as each ExplicitObjectLevelSynchronization has their own lock object
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
    }
}
