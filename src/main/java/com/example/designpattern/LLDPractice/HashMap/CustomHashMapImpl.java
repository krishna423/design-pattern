package com.example.designpattern.LLDPractice.HashMap;


import java.util.Objects;

import static java.lang.Math.abs;

public class CustomHashMapImpl<K,V> implements CustomHashMap<K,V> {

    private int DEFAULT_SIZE=100000;
    private double loadFactor = 20;
    private int treeifyThreshold = 4;

    private int size=0;
    private int capacity ;

    private Node<K,V>[] table;


    //HashMap internal implementation : Array of Node<K,V> , each node contains a linklist


    public CustomHashMapImpl(int capacity,double loadFactor, int treeifyThreshold) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.treeifyThreshold = treeifyThreshold;
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
        }else {
            Node<K, V> pre = null;
            while (Objects.nonNull(node)) {
                if (node.getKey() == key) {
                    //Node already present
                    return;
                }
                pre = node;
                node = node.getNextPointer();
                countNodesInABucket++;
            }
            System.out.println(key + " Used bucket : " + bucketId + " " + countNodesInABucket);
            Node<K, V> newNode = new Node<>(key, value);
            pre.setNextPointer(newNode);

            size++;
            if (size > capacity * loadFactor) {
                resize();
            }
            if (countNodesInABucket > treeifyThreshold) {
                if (table[bucketId] instanceof TreeNode<K, V>) {
                    return;
                }
                //Convert linklist to TreeNode and create a self-balancing tree for increasing performance in log(countNodesInABucket)
                treeifyBin(bucketId, countNodesInABucket);
            }
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

    final void treeifyBin( int bucketId, int noOfNodesInBucket) {
        System.out.println("Creating DLL for bucketId " + bucketId + " size "  + noOfNodesInBucket);
        Node<K,V> node = table[bucketId];

        //Create Node<K,V> linklist to TreeNode Doubly linklist
        TreeNode<K,V> treeNode = null;
        TreeNode<K,V> preTreeNode = null;

        while (Objects.nonNull(node)){
            TreeNode<K,V> newTreeNode = convertTreeNodeFromNode(node);
            if(treeNode == null){
                treeNode = newTreeNode;
            }else {
                newTreeNode.setPreviousPointer(preTreeNode);
                preTreeNode.setNextPointer(newTreeNode);
            }
            preTreeNode = newTreeNode;
            node = node.getNextPointer();
        }

        //DLL done
        //call treefy for creating DLL to map
        treeify(treeNode,bucketId);
    }

    final void treeify(TreeNode<K,V> treeNode,int bucketId){
        //DLL to BST
        //BST to Red-black tree
        table[bucketId] = treeNode;
    }

    private TreeNode<K,V> convertTreeNodeFromNode(Node<K,V> node){
        return new TreeNode<>(node.getKey(),node.getValue());
    }
}
