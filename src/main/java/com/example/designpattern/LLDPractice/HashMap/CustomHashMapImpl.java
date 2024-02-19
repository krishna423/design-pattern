package com.example.designpattern.LLDPractice.HashMap;


import java.util.Objects;

import static java.lang.Math.abs;

public class CustomHashMapImpl<K,V> implements CustomHashMap<K,V> {

    private int DEFAULT_SIZE=100000;
    private int getDEFAULT_SIZE= 10;
    private double loadFactor = 20;
    private int treefy = 4;

    private int size=0;
    private int capacity ;

    private Node<K,V>[] table;
    public CustomHashMapImpl(int capacity,double loadFactor, int treefy) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.treefy = treefy;
        table = new Node[capacity];
        // size 2^n

    }


    @Override
    public void put(K key, V value) {
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
        if(size > capacity*2*loadFactor || countNodesInABucket>treefy){
            resize();
        }
    }

    @Override
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(K key) {
        int bucketId = getBucketId(key);
        Node<K,V> node = table[bucketId];
        if(Objects.isNull(node)){
            return false;
        }else{
            while(Objects.nonNull(node)){
                if(node.getKey() == key){
                    return true;
                }
                node = node.getNextPointer();
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void remove(K k) {

    }

    private int getBucketId(K key){
        int bucketId =  abs(key.hashCode())%table.length;
        System.out.println(key + "  " + bucketId);
        return bucketId;
    }

    void resize(){
        //calculate new size;
        System.out.println("Calling resize");
        capacity = 2*capacity;
        if(capacity>= DEFAULT_SIZE){
            throw new RuntimeException("Maximum size reached");
        }
        Node<K,V> [] newTable = new Node[capacity];

        for(Node<K,V> node : table){
            if(Objects.nonNull(node)){
                K key  = node.getKey();
                V value = node.getValue();
                Node<K,V> newNode = new Node<>(key,value);
                pushInNewTable(newTable,newNode);
            }

        }
        table = newTable;
        System.out.println("Resize done , capacity" + capacity);

    }

    void pushInNewTable(Node<K,V> [] newTable, Node<K,V> newNode){
        int bucketId = getBucketId(newNode.getKey());
        Node<K,V> node = newTable[bucketId];
        if(Objects.isNull(node)){
            newTable[bucketId]=newNode;
        }
        else {
            Node<K, V> pre = null;
            while (Objects.nonNull(node)) {
                pre = node;
                node = node.getNextPointer();
            }
            pre.setNextPointer(newNode);
        }


    }
}
