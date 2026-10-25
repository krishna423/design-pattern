package com.example.designpattern.logics.Coding.Tree;

import com.sun.source.tree.Tree;
import org.luaj.vm2.ast.Str;

import java.util.*;

public class BottomViewBinaryTree {


    public static void main(String[] args) {
       // String [] inputArray = {"20", "8", "22", "5", "3", "N", "25", "N", "N", "10" ,"14"};
        String [] inputArray = {"N"};
        TreeNode root = constructTree(inputArray);
        List<Integer> view = bottomView(root);
        System.out.println(view);


    }



    public static List<Integer> bottomView(TreeNode root) {
        //your code goes here
        if(root== null) return new ArrayList<>();

        List<Integer> ansList = new ArrayList<>();
        Queue<NodeWrapper> q = new ArrayDeque<>();
        Map<Integer,List<Integer>> map = new TreeMap<>();

        q.add(new NodeWrapper(root,0));

        while (!q.isEmpty()){
            NodeWrapper nodeWrapper = q.poll();
            TreeNode node = nodeWrapper.node;
            int index = nodeWrapper.index;

            if(node.left!=null){
                q.add(new NodeWrapper(node.left, index-1));
            }
            if(node.right!=null){
                q.add(new NodeWrapper(node.right, index + 1));
            }
            updateMap(map, index, node);

        }

        Set <Map.Entry<Integer, List<Integer>>> setOfMapValues = map.entrySet();



        for( Map.Entry<Integer, List<Integer>> mp :  setOfMapValues){
            int key = mp.getKey();
            List<Integer> values = mp.getValue();

            System.out.println(key + " " + values);

            int size = values.size();
            ansList.add(values.get(size-1));
        }
        return ansList;
    }

    private static void updateMap(Map<Integer, List<Integer>> map, int effIndex, TreeNode node) {

        List<Integer> tempList;
        if(!map.containsKey(effIndex)){
            tempList = new ArrayList<>();
        }else{
            tempList = map.get(effIndex);
        }
        tempList.add(node.data);
        map.put(effIndex, tempList);
    }

    public static TreeNode constructTree(String [] inputArray) {
        //your code goes here
        int size = inputArray.length;

        TreeNode root = new TreeNode(inputArray[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int index = 1;

        while(index < size){

            TreeNode node = q.poll();
            TreeNode leftNode =null, rightNode=null;

            if(!inputArray[index].equals("N") ){
                leftNode = new TreeNode(inputArray[index]);
                q.add(leftNode);
                node.left = leftNode;
            }
            index++;
            if( index < size && !inputArray[index].equals("N") ){
                rightNode = new TreeNode(inputArray[index]);
                q.add(rightNode);
                node.right = rightNode;
            }
            index++;
        }
        return root;
    }






}



class NodeWrapper{
    TreeNode node;
    int index;

    public NodeWrapper(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }

    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}


//Node

 class TreeNode{
    Integer data;
    TreeNode left;
    TreeNode right;

     public TreeNode(String data) {
         this.data = data== "N" ? null: Integer.parseInt(data);
     }

     public Integer getData() {
         return data;
     }

     public void setData(Integer data) {
         this.data = data;
     }

     public TreeNode getLeft() {
         return left;
     }

     public void setLeft(TreeNode left) {
         this.left = left;
     }

     public TreeNode getRight() {
         return right;
     }

     public void setRight(TreeNode right) {
         this.right = right;
     }
 }



