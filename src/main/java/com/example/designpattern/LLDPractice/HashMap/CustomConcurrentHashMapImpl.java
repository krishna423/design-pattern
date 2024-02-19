package com.example.designpattern.LLDPractice.HashMap;


import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Math.abs;

public class CustomConcurrentHashMapImpl<K,V> implements CustomHashMap<K,V> {

    private volatile int DEFAULT_THREAD_COUNT= 5;
    private volatile double loadFactor = 20;
    private volatile int treefy = 4;

    private volatile int size=0;
    private volatile int capacity ;

    private transient volatile Segment<K,V>[] segments;
    public CustomConcurrentHashMapImpl(int capacity, double loadFactor, int treefy) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.treefy = treefy;
        segments = new Segment[DEFAULT_THREAD_COUNT];

        // size 2^n

    }


    @Override
    public void put(K key, V value) {
        int countNodesInABucket=0;
        int segmentId = getSegmentId(key);
        Segment<K,V> segment  = segments[segmentId];
        if(Objects.isNull(segment)){
            segment = new Segment<>();
            segment.init(capacity/DEFAULT_THREAD_COUNT);
            segments[segmentId]=segment;
        }
        segment.put(key, segmentId, value);
        size++;
        if(size > capacity*2*loadFactor || countNodesInABucket>treefy){
          //  resize();
        }
    }

    @Override
    public V get(K key) {
        int segmentId = getSegmentId(key);

        Segment<K,V> segment  = segments[segmentId];
        if(Objects.isNull(segment)){
            return null;
        }else{
            return segment.get(key);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(K key) {
        return Objects.nonNull(get(key));
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void remove(K k) {

    }

    private int getSegmentId(K key){
        int segmentId =  abs(key.hashCode())% segments.length;
        System.out.println(key +  " SegmentId  " + segmentId);
        return segmentId;
    }


    static final class Segment<K,V> extends ReentrantLock implements Serializable {

        transient volatile Node<K,V>[] table;
        transient volatile int threshold;
        int size=0;

        void init(int capacity){
            table = new Node[capacity];
        }

        final void put(K key, int hash, V value) {
            // Obtain the lock on the current Segment
            try{
                tryLock(2, TimeUnit.SECONDS);
                put(key,value);

            }catch (Exception e){
                System.out.println("Not able to acquire lock " + e.toString());

            } finally {
                // Release the lock once the remove is done
                unlock();
            }
        }

        /**
         * Remove; match on key only if value null, else match both.
         */

        private void put(K key, V value) {
            int countNodesInABucket=0;
            int bucketId = getBucketId(key);
            Node<K,V> node = table[bucketId];
            if(Objects.isNull(node)){
                table[bucketId] = new Node<>(key,value);
            }else{
                Node <K,V> pre = null;
                while(Objects.nonNull(node)){
                    if(node.getKey() == key){
                        //Node already present
                        return;
                    }
                    pre = node;
                    node = node.getNextPointer();
                    countNodesInABucket++;
                }
                System.out.println(key + " Used bucket : " + bucketId +  " " + countNodesInABucket );
                Node<K,V> newNode = new Node<>(key,value);
                pre.setNextPointer(newNode);
            }
            size++;
//            if(size > capacity*2*loadFactor || countNodesInABucket>treefy){
//                resize();
//            }
        }

        private int getBucketId(K key){
            int bucketId =  abs(key.hashCode()-1234)% table.length;
            System.out.println(key +  " bucketId  " + bucketId);
            return bucketId;
        }

        public V get(K key) {
            int bucketId = getBucketId(key);
            Node<K,V> node = table[bucketId];
            if(Objects.isNull(node)){
                return null;
            }else{
                while(Objects.nonNull(node)){
                    if(node.getKey() == key){
                        return node.getValue();
                    }
                    node = node.getNextPointer();
                }
            }
            return null;
        }

    }

}
