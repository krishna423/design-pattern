package com.example.designpattern.logics.Coding.Tree;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

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

    static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


}
class Node{
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
