package com.example.designpattern.logics.Coding.MultiThreading;

public class PrintEventOddNumberMultiThreading {


     int counter =1;
     int n = 10;

     synchronized void  printEven() throws InterruptedException {
         while (counter<n) {

             if (counter % 2 != 0) {
                 wait();
             }

             System.out.println("Getting value : " + counter + " from thread1 : " + Thread.currentThread().getName());
             counter++;
             notifyAll();
         }
    }

     synchronized void printOdd() throws InterruptedException {
         while (counter<n) {
            // System.out.println("Getting vgghhg value : " + counter + " from thread1 : " + Thread.currentThread().getName());

             if (counter % 2 == 0) {
                 wait();
             }

             System.out.println("Getting value : " + counter + " from thread1 : " + Thread.currentThread().getName());
             counter++;
             notifyAll();
         }

    }


    public static void main(String[] args) {


        PrintEventOddNumberMultiThreading printEventOddNumberMultiThreading = new PrintEventOddNumberMultiThreading();

        Thread threadOdd = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printEventOddNumberMultiThreading.printOdd();
                } catch (InterruptedException e) {
                }
            }
        });

        Thread threadEven = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printEventOddNumberMultiThreading.printEven();
                } catch (InterruptedException e) {
                }
            }
        });

        threadEven.start();
        threadOdd.start();


    }
}
