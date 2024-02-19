package com.example.designpattern.LLDPractice.HashMap;



public class TreeNode<K,V> extends Node<K,V>{

    private TreeNode<K,V> previousPointer;
    private TreeNode<K,V> parentPointer;


    public TreeNode(K key, V value) {
        super(key,value);
    }

    public TreeNode<K, V> getPreviousPointer() {
        return previousPointer;
    }

    public void setPreviousPointer(TreeNode<K, V> previousPointer) {
        this.previousPointer = previousPointer;
    }

    public TreeNode<K, V> getParentPointer() {
        return parentPointer;
    }

    public void setParentPointer(TreeNode<K, V> parentPointer) {
        this.parentPointer = parentPointer;
    }
}
