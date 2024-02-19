package com.example.designpattern.LLDPractice.TreeMap;



public class TreeNode<K,V> {
    private K key ;
    private V value ;
    private TreeNode<K,V> leftPointer;
    private TreeNode<K,V> rightPointer;
    private TreeNode<K,V> parentPointer;

    public TreeNode(K key, V value) {
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

    public TreeNode<K, V> getLeftPointer() {
        return leftPointer;
    }

    public void setLeftPointer(TreeNode<K, V> leftPointer) {
        this.leftPointer = leftPointer;
    }

    public TreeNode<K, V> getRightPointer() {
        return rightPointer;
    }

    public void setRightPointer(TreeNode<K, V> rightPointer) {
        this.rightPointer = rightPointer;
    }

    public TreeNode<K, V> getParentPointer() {
        return parentPointer;
    }

    public void setParentPointer(TreeNode<K, V> parentPointer) {
        this.parentPointer = parentPointer;
    }
}
