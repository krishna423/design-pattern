package com.example.designpattern.logics.Collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;

public class CustomBlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();
    private Stack<String> a= new Stack<String>();
    private int cap;


    public CustomBlockingQueue(int cap){
        this.cap=cap;
    }


    public synchronized void enqueue(T object) throws InterruptedException {

        while(queue.size()==cap){
            wait();
        }

        if(queue.isEmpty()){
            notifyAll();
        }
        queue.add(object);
    }


    public synchronized T dequeue()  throws InterruptedException {
        while(queue.isEmpty()){
            wait();
        }
        if(queue.size()==cap){
            notifyAll();
        }
        return queue.poll();
    }

    public int getSize() {
        return queue.size();
    }


    public static void main(String[] args) throws InterruptedException {
        CustomBlockingQueue<String> customBlockingQueue = new CustomBlockingQueue<>(5);
        customBlockingQueue.enqueue("12121");
        System.out.println(customBlockingQueue.getSize());
        customBlockingQueue.enqueue("121aad");
        customBlockingQueue.enqueue("1dhh");
        System.out.println(customBlockingQueue.getSize());

        customBlockingQueue.dequeue();
        System.out.println(customBlockingQueue.getSize());
    }
}
