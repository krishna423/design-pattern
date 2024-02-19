package com.example.designpattern.LLDPractice.HashMap;



public class Node<K,V> {
    private K key ;
    private V value ;
    private Node<K,V> nextPointer;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNextPointer() {
        return nextPointer;
    }

    public void setNextPointer(Node<K, V> nextPointer) {
        this.nextPointer = nextPointer;
    }
}
