package com.example.designpattern.logics.Coding.Tree;

import java.util.HashMap;
import java.util.Map;

public class PairExistInBST {


    static int isPairPresent(Node root, int target)
    {
        Map<Integer,Integer> map = new HashMap<>();
        return inOrder(root,target,map);

    }

    private static int inOrder(Node root, int target, Map<Integer, Integer> map) {

        if(root==null){
            return 0;
        }

        if(inOrder(root.left,target,map)==1)return 1;

        if(map.containsKey(target-root.data)){
            return 1;
        }
        map.put(root.data,0);

        if(inOrder(root.right,target,map)==1) return 1;
        return 0;

    }

    public static void main(String[] args) {
        String [] arr = {"10", "5", "18", "2", "9", "15", "19", "N", "4", "8", "N", "8"};
        Node root = BinaryTree.buildTree(arr);
        System.out.println(isPairPresent(root,10));
    }

}
