package com.example.designpattern.logics.Coding.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BurnBinaryTree {

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        // Write your code here.
        BinaryParentTreeNode<Integer> binaryParentTreeNode = constructBinaryParentTreeNode(root);
        BinaryParentTreeNode<Integer> startNode = getNode(binaryParentTreeNode,start);
        return getBurningTime(binaryParentTreeNode,startNode);
    }


    static BinaryParentTreeNode<Integer> getNode(BinaryParentTreeNode<Integer> binaryParentTreeNode, int start){
        if(binaryParentTreeNode == null){
            return null;
        }

        if(binaryParentTreeNode.data==start){
            return binaryParentTreeNode;
        }

        BinaryParentTreeNode<Integer> left = getNode(binaryParentTreeNode.left,start);
        BinaryParentTreeNode<Integer> right = getNode(binaryParentTreeNode.right,start);

        return left!=null?left:right;
    }



    static int getBurningTime(BinaryParentTreeNode<Integer> binaryParentTreeNode, BinaryParentTreeNode<Integer> startNode){
        Queue<BinaryParentTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(startNode);
        startNode.visited=1;

        int globalStep = 0;
        while (!queue.isEmpty()){
            BinaryParentTreeNode<Integer> current = queue.poll();
            System.out.println(current);
            globalStep = current.step;

            if(current.parent!=null && current.parent.visited==0 ){
                current.parent.step = current.step+1;
                current.parent.visited = 1;
                queue.add(current.parent);
            }
            if(current.left!=null && current.left.visited==0 ){
                current.left.step = current.step+1;
                current.left.visited = 1;
                queue.add(current.left);
            }
            if(current.right!=null && current.right.visited==0 ){
                current.right.step = current.step+1;
                current.right.visited = 1;
                queue.add(current.right);
            }
        }
        return globalStep;
    }


    static BinaryParentTreeNode<Integer> constructBinaryParentTreeNode(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        BinaryParentTreeNode<Integer> rootParent = new BinaryParentTreeNode<>(root.data);

        BinaryParentTreeNode<Integer> leftSubTree = constructBinaryParentTreeNode(root.left);
        BinaryParentTreeNode<Integer> rightSubTree = constructBinaryParentTreeNode(root.right);

        rootParent.left = leftSubTree;
        rootParent.right = rightSubTree;

        if(leftSubTree!=null) {
            leftSubTree.parent = rootParent;
        }
        if(rightSubTree!=null) {
            rightSubTree.parent = rootParent;
        }
        return rootParent;
    }


    public static void main(String[] args) {
        String[] input = {"1", "2", "3", "N", "N", "4", "5"};
        BinaryTreeNode<Integer> root = buildTree(input);
        System.out.println(timeToBurnTree(root,3));
    }














    static BinaryTreeNode<Integer> buildTree(String [] arr){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(Integer.valueOf(arr[0]));
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        BinaryTreeNode<Integer> temp ;
        for(int i=1;i<arr.length;i=i+2){
            temp = queue.poll();
            if(!arr[i].equals("N")){
                temp.left = new BinaryTreeNode<Integer>(Integer.valueOf(arr[i]));
                queue.add(temp.left);
            }
            if( i< arr.length-1 && !arr[i+1].equals("N")) {
                temp.right = new BinaryTreeNode<Integer>(Integer.valueOf(arr[i+1]));
                queue.add(temp.right);
            }
        }
        return root;
    }

    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryParentTreeNode<T>  {

        BinaryParentTreeNode<T> parent;
        BinaryParentTreeNode<T> left;
        BinaryParentTreeNode<T> right;
        T data;
        int visited ;
        int step;

        public BinaryParentTreeNode(T data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
            this.visited=0;
            this.step = 0;
        }

        @Override
        public String toString() {
            return "BinaryParentTreeNode{" +
                    "visited=" + visited +
                    ", step=" + step +
                    ", data=" + data +
                    '}';
        }
    }


}
