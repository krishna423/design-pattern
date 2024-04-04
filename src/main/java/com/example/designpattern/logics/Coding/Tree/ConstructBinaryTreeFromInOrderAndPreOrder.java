package com.example.designpattern.logics.Coding.Tree;

public class ConstructBinaryTreeFromInOrderAndPreOrder {

    static int preOrderIndex=0;

    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        preOrderIndex=0;
        return buildTree(inorder,preorder,0,n-1);

        // code here
    }

    public static Node buildTree(int inorder[], int preorder[], int startIn,int endIn)
    {
        if(endIn < startIn){
            return null;
        }

        int root = preorder[preOrderIndex++];
        if(startIn == endIn){
            return new Node(root);
        }

        Node rootNode = new Node(root);
        int rootIndexInOrder = searchInInOrder(inorder,root,startIn,endIn);


        if(rootIndexInOrder ==-1){
            return null;
        }
        Node l = buildTree(inorder,preorder,startIn,rootIndexInOrder-1);
        Node r = buildTree(inorder,preorder,rootIndexInOrder+1,endIn);

        rootNode.left = l;
        rootNode.right = r;

        // code here
        return rootNode;
    }

    public static int searchInInOrder(int inorder[], int root,int start,int end)
    {

        for (int i = start; i <= end; i++) {
            if(inorder[i]==root){
                return i;
            }
        }
        return -1;
    }



    static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data +" ");

    }

    public static void main(String[] args) {
        int inorder[] = {3,1,4,0,5,2};
        int preorder[] = {0,1,3,4,2,5};
        Node root = buildTree(inorder,preorder,inorder.length);
        postOrder(root);
    }



     static class Node{
         int data;
         Node left, right;

         public Node(int data) {
             this.data = data;
             this.left = null;
             this.right = null;
         }
     }
}