package com.example.designpattern.logics.Coding;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {


    // Main Method
    public static void main(String args[])
    {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>((a, b) -> {
                    if(a > b){
                        return -1;
                    } else if (a.equals(b)) {
                        return 0;
                    } else{
                        return 1;
                    }
        });

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(110);
        pQueue.add(202);
        pQueue.add(20);
        pQueue.add(15);
        pQueue.add(5);
        pQueue.add(10);
        pQueue.add(45);
        pQueue.add(58);
        pQueue.add(15);
        pQueue.add(5);

        // Printing the top element of PriorityQueue
        while (!pQueue.isEmpty()) {
            System.out.print(pQueue.poll() +" ");
        }
        System.out.println("");
    }

}
