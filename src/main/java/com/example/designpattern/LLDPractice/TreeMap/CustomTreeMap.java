package com.example.designpattern.LLDPractice.TreeMap;

public interface CustomTreeMap<K, V> {

    void put(K key, V string);

    V get(K key);

    int size();

    boolean contains(K key);

    boolean isEmpty();

    void remove(K k);

}
