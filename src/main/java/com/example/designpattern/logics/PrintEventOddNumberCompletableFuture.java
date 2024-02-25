package com.example.designpattern.logics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class PrintEventOddNumberCompletableFuture {


    int counter =1;
    int n = 10;

    void printEven() {
        synchronized (this) {
            while (counter < n) {

                if (counter % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Getting value : " + counter + " from thread : " + Thread.currentThread().getName());
                counter++;
                notifyAll();
            }
        }
    }

    void printOdd() {
        synchronized (this){
            while (counter<n) {
                // System.out.println("Getting vgghhg value : " + counter + " from thread1 : " + Thread.currentThread().getName());

                if (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Getting value : " + counter + " from thread : " + Thread.currentThread().getName());
                counter++;
                notifyAll();
            }
        }

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        PrintEventOddNumberCompletableFuture printEventOddNumberCompletableFuture = new PrintEventOddNumberCompletableFuture();

        CompletableFuture.runAsync(printEventOddNumberCompletableFuture::printOdd);
        CompletableFuture.runAsync(printEventOddNumberCompletableFuture::printEven);
        Thread.sleep(5000);


    }
}
