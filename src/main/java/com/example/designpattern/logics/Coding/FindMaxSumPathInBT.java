package com.example.designpattern.logics.Coding;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxSumPathInBT {

    private static int globalMax = -100000;


    static int findMaxPathSum(Node root){
        if(root == null){
            return 0;
        }
        //System.out.println(root.data);
        int l_sum = Math.max(0, findMaxPathSum(root.left));
        int r_sum = Math.max(0, findMaxPathSum(root.right));

        if(globalMax < l_sum+r_sum+root.data){
            globalMax = l_sum+r_sum+root.data;
        }
        return Math.max(l_sum,r_sum)+ root.data;
    }

    //Function to return maximum path sum from any node in a tree.
    static int findMaxSum(Node node)
    {
        findMaxPathSum(node);
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
        System.out.println(findMaxSum(root));

        globalMax = -100000;
        String [] arr2 =  {"-10","2","20","-1","-25","3","4"};
        Node root2 = buildTree(arr2);
        System.out.println(findMaxSum(root2));

    }

}



