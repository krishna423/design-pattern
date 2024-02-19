package com.example.designpattern.LLDPractice.TreeMap;


import com.example.designpattern.LLDPractice.HashMap.Node;

import java.util.Objects;
import java.util.TreeMap;

import static java.lang.Math.abs;

public class CustomTreeMapImpl<K,V> implements CustomTreeMap<K,V> {

    private int DEFAULT_SIZE=100000;
    private int getDEFAULT_SIZE= 10;
    private double loadFactor = 20;
    private int treefy = 4;

    private int size=0;
    private int capacity ;

    private TreeNode<K,V> root;
    public CustomTreeMapImpl() {
        // size 2^n

    }


    @Override
    public void put(K key, V value) {

        if(Objects.isNull(root)){
            size++;
            root = new TreeNode<>(key,value);
            return;
        }

        Comparable<? super K> k = (Comparable<? super K>) key;
        TreeNode<K,V> currentNode = root;
        TreeNode<K,V> preNode = null;
        while (currentNode != null) {
            preNode = currentNode;
            int cmp = k.compareTo(currentNode.getKey());
            if (cmp < 0)
                currentNode = currentNode.getLeftPointer();
            else if (cmp > 0)
                currentNode = currentNode.getRightPointer();
            else
                return;
        }
        TreeNode<K,V> newNode = new TreeNode<>(key, value);
        if(k.compareTo(preNode.getKey())<0){
            preNode.setLeftPointer(newNode);
        }else{
            preNode.setRightPointer(newNode);
        }
        newNode.setParentPointer(preNode);
        size++;
        //Red-black Tree update function
    }

    @Override
    public V get(K key) {
        System.out.println("Key " + key + " root : " +  root.getKey());
        Comparable<? super K> k = (Comparable<? super K>) key;
        TreeNode<K,V> currentNode = root;
        while (currentNode != null) {
            System.out.print(" " +currentNode.getKey() + " ");
            int cmp = k.compareTo(currentNode.getKey());
            if (cmp < 0) {
                currentNode = currentNode.getLeftPointer();
                System.out.print("--ll-->");
            }
            else if (cmp > 0) {
                currentNode = currentNode.getRightPointer();
                System.out.print("--rr-->");
            }
            else
                return currentNode.getValue();
        }
        return null;
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
}
