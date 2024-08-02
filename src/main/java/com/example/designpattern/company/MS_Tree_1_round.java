package com.example.designpattern.company;

public class MS_Tree_1_round {



    static int firstOccurrance(int [] arr, int st, int end, int target){

        if(st>end){
            return -1;
        }

        int mid = (st+end)/2;

       // System.out.println(mid);
        if(mid>0 && arr[mid]==target && arr[mid-1]<arr[mid] ){
            return mid;
        } else if (mid==0 && arr[mid]==target) {
            return mid;
        } else if ( arr[mid] < target ) {
            return firstOccurrance(arr,mid+1,end,target);
        }else{
            return firstOccurrance(arr,st,mid-1,target);
        }


    }


    public static void main(String[] args) {
        int arr[] = {0,1,1,1,1,3,9};
        int target = 1;
        System.out.println("First " + firstOccurrance(arr,0, arr.length-1,target));
    }




















//    static Node createBST(int [] array, int st, int end){
//
//        if(st>end){
//            return null;
//        }
//
//        int mid = (st+end)/2;
//        Node root =  new Node(array[mid]);
//
//        Node leftNode = createBST(array,st,mid-1);
//        Node rightNode = createBST(array,mid+1,end);
//
//        root.left = leftNode;
//        root.right = rightNode;
//
//        return root;
//
//    }
//
//
//    static  Node creteBSTMain(int []arr){
//        return createBST(arr,0,arr.length-1);
//    }
//
//
//
//    public static void main(String[] args) {
//
//            //int [] arr = { 1,2,3,4,8,10,12,15};
//            int [] arr = {1, 2};
//
//            Node root = creteBSTMain(arr);
//            preOrder(root);
//
//
//    }
//
//
//    static void preOrder(Node node){
//        if(node==null){
//            return;
//        }
//        System.out.print (node.value+ " ");
//        preOrder(node.left);
//        preOrder(node.right);
//
//    }
//
//
//    static class Node{
//        private Node left, right;
//        private int value;
//
//        public Node(int value) {
//            this.left = null;
//            this.right = null;
//            this.value = value;
//        }
//    }

}
