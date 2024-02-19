package com.example.designpattern.LLDPractice.HashMap;

public interface CustomHashMap<K, V> {

    void put(K key, V string);

    V get(K key);

    int size();

    boolean contains(K key);

    boolean isEmpty();

    void remove(K k);

}
