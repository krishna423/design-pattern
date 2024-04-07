package com.example.designpattern.logics.Coding.Trie;

import java.util.Arrays;

public class MaximumXORArrayElement {


    static private Node root;
    public MaximumXORArrayElement(){
        root = new Node();
    }


    public static int[] maximumXOR(int [] arr, int [][] queries) {

        int [] ans = new int[queries.length];
        Arrays.sort(arr);

        int [][] offlineQueries = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            offlineQueries[i][0] = queries[i][0];
            offlineQueries[i][1] = queries[i][1];
            offlineQueries[i][2] =  i;

        }

        Arrays.sort(offlineQueries, (a, b)-> Integer.compare(a[1],b[1]));

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(offlineQueries));

        int maxXOR = Integer.MIN_VALUE;


        int j=0;
        for (int i = 0; i < offlineQueries.length; i++) {
            //insert(arr[i]);
            int XORElement = offlineQueries[i][0];
            int y = offlineQueries[i][1];

            while(true){
                if(j >= arr.length){
                    break;
                }
                if(y < arr[j]){
                    break;
                }
                insert(arr[j]);
                j++;
            }
            if(j==0){

                ans[offlineQueries[i][2]] =-1;
            }else {
                ans[offlineQueries[i][2]] = getMax(XORElement);
            }
        }
        return  ans;
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



    public static void main(String[] args) {
        int [] arr = {5, 2, 4, 6, 6, 3};
        int [ ][ ] queries  = {{12, 4}, {8, 1}, {6, 3}};
        MaximumXORArrayElement maximumXORArrayElement = new MaximumXORArrayElement();
        System.out.println(Arrays.toString(maximumXORArrayElement.maximumXOR(arr, queries)));
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
