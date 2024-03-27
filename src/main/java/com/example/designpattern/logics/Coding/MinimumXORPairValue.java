package com.example.designpattern.logics.Coding;

public class MinimumXORPairValue {


    static private Node root;

    public MinimumXORPairValue (){
        MinimumXORPairValue.root = new Node();
    }


    public static int minimumXOROptimizedWay(int [] arr) {

        int minXOR = Integer.MAX_VALUE;

        insert(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            minXOR = Math.min( minXOR, getMin(arr[i]));
            insert(arr[i]);
        }

        return  minXOR;
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

    static int getMin(int k){
        Node head = root;
        int bit ;
        for (int i=31;i>=0;i--){
            bit = (k & (1<< i))!=0 ? 1 :0;

            if(head.children[bit]!=null){
                head = head.children[bit];
            }else{
                head = head.children[1-bit];
            }
        }
        return k^ head.value;
    }









    public static int minimumXOR(int [] arr) {

        int minXOR = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int xor = arr[i] ^ arr[j];
                minXOR = Math.min(minXOR, xor);
            }
        }
        return  minXOR;
    }



    public static void main(String[] args) {
        int arr[] = {9,5,3};
        System.out.println(minimumXOR(arr));
        MinimumXORPairValue minimumXORPairValue = new MinimumXORPairValue();
        System.out.println(minimumXORPairValue.minimumXOROptimizedWay(arr));
    }


    static class Node{
        private Node[] children;
        private int value;

        public Node() {
            this.children = new Node[2];
            this.value = 0;
        }
    }
}
