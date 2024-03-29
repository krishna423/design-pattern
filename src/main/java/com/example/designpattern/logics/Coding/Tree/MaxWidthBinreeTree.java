package com.example.designpattern.logics.Coding.Tree;

import org.springframework.data.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinreeTree {

    private static int globalMax ;


    // Function to get the maximum width of a binary tree.
    static int getMaxWidth(Node root) {
        // Your code here
        globalMax = 0;
        if(root==null){
            return 0;
        }

        Queue<Pair<Node,Integer>> queue = new LinkedList<>();

        queue.add(Pair.of(root,0));

        Pair<Node,Integer> current;
        Node currentNode;
        int startPoint=0 , endPoint=0 ;
        boolean isFisrtNode =false;

        while (!queue.isEmpty()){
            int size  =  queue.size();
            System.out.println("size " + size );
            int bkp_size= size;
            isFisrtNode=true;

            while (size>0){
                current= queue.poll();
                currentNode = current.getFirst();
                int position = current.getSecond();
                if(isFisrtNode){
                    startPoint = position;
                    isFisrtNode = false;
                }
                endPoint = position;
                if(currentNode.left!=null){
                    queue.add(Pair.of(currentNode.left,position-1));
                }
                if(currentNode.right!=null){
                    queue.add(Pair.of(currentNode.right,position+1));
                }
                size--;
            }
            if (bkp_size==1){
                globalMax = Math.max(globalMax,1);
            }else{
                globalMax = Math.max(globalMax,endPoint-startPoint);
            }

        }

        return globalMax;
    }

    static Node buildTree(String [] arr){
        Node root = new Node(arr[0],null,null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node temp ;
        for(int i=1;i<arr.length;i=i+2){
            temp = queue.poll();
            if(!arr[i].equals("N")){
                temp.left = new Node(arr[i],null,null);
                queue.add(temp.left);
            }
            if( i< arr.length-1 && !arr[i+1].equals("N")) {
                temp.right = new Node(arr[i+1], null, null);
                queue.add(temp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String [] arr = {"2","1","3","0","N"};
        Node root = buildTree(arr);
        System.out.println(getMaxWidth(root)+ " \n");

        globalMax = -100000;
        String [] arr2 =  {"-10","2","20","-1","-25","3","4"};
        Node root2 = buildTree(arr2);
        System.out.println(getMaxWidth(root2));

    }

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public Node(String dataString, Node left, Node right) {
            this.data = Integer.parseInt(dataString);
            this.left = left;
            this.right = right;
        }
    }



}



