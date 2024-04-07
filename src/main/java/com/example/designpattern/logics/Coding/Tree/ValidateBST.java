package com.example.designpattern.logics.Coding.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBST {

    static boolean isValidBST(Node root, int min, int max){
        if(root==null){
            return true;
        }
        if(root.data <= min || root.data >=max){
            return false;
        }
        if( isValidBST(root.left, min, root.data) && isValidBST(root.right,root.data,max)){
            return true;
        }else{
            return false;
        }
    }

    static boolean isBST(Node root)
    {
        if(root==null){
            return true;
        }
        if( isValidBST(root.left, Integer.MIN_VALUE, root.data) && isValidBST(root.right,root.data,Integer.MAX_VALUE)){
            return true;
        }else{
            return false;
        }
        // code here.
    }

    static Node buildTree(int [] arr){
        Node root = new Node(arr[0],null,null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node temp ;
        for(int i=1;i<arr.length;i=i+2){
            temp = queue.poll();
            if(arr[i]!=-1){
                temp.left = new Node(arr[i],null,null);
                queue.add(temp.left);
            }
            if( i< arr.length-1 && arr[i+1]!=-1) {
                temp.right = new Node(arr[i+1], null, null);
                queue.add(temp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int [] arr = {2,1,3,0};
        Node root = buildTree(arr);
        System.out.println(isBST(root));

        int [] arr2 = {2,1,3,5};
        Node root2 = buildTree(arr2);
        System.out.println(isBST(root2));

    }

}


