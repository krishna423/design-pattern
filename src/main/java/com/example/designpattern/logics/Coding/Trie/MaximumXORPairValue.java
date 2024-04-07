package com.example.designpattern.logics.Coding.Trie;

public class MaximumXORPairValue {


    static private Node root;
    public MaximumXORPairValue (){
        MaximumXORPairValue.root = new Node();
    }


    public static int maximumXOROptimizedWay(int [] arr) {

        int maxXOR = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            maxXOR = Math.max( maxXOR, getMax(arr[i]));
        }


        return  maxXOR;
    }

    static void  insert(int k){
        Node head = root;
        int bit ;
        for (int i=31;i>=0;i--){
            bit = (k & (1<< i))!=0 ? 1 :0;

            if(head.children[bit]==null){
                head.children[bit] = new Node();
            }
            head = head.children[bit];
        }
        head.value=k;
    }

    static int getMax(int k){
        Node head = root;
        int bit ;
        for (int i=31;i>=0;i--){
            bit = (k & (1<< i))!=0 ? 1 :0;

            if(head.children[1-bit]!=null){
                head = head.children[1-bit];
            }else{
                head = head.children[bit];
            }
        }
        return k^ head.value;
    }

    







    public static int maximumXOR(int [] arr) {

        int maxXOR = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int xor = arr[i] ^ arr[j];
                maxXOR = Math.max(maxXOR, xor);
            }
        }
        return  maxXOR;
    }



    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(maximumXOR(arr));
        System.out.println(maximumXOROptimizedWay(arr));
    }


    static class Node{
        private Node [] children;
        private int value;

        public Node() {
            this.children = new Node[2];
            this.value = 0;
        }
    }
}
