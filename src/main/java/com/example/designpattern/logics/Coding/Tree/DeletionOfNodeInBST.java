package com.example.designpattern.logics.Coding.Tree;

public class DeletionOfNodeInBST {

    public static Node deleteNode(Node root, int X) {
        // code here.

        Node bkpRoot = root;
        if(root.data==X){
            return getSubTree(root
            );
        }

        while(root!=null){

            if(root.data< X){
                if(root.right!=null && root.right.data ==X){
                    root.right = getSubTree(root.right);
                    break;
                }else {
                    root = root.right;
                }

            }else{
                if(root.left!=null && root.left.data ==X){
                    root.left = getSubTree(root.left);
                    break;
                }else {
                    root = root.left;
                }
            }
        }

        return bkpRoot;
    }

    static Node getSubTree(Node deletableNode){


        if(deletableNode.left ==null && deletableNode.right == null){
            return null;
        }
        else if (deletableNode.left ==null ){
           return deletableNode.right;
        }
        else if (deletableNode.right ==null ){
            return deletableNode.left;
        }else{
            //root.right = deletableNode.right;

            Node leftmost = deletableNode.right;
            while (leftmost.left!=null){
                leftmost = leftmost.left;
            }
            leftmost.left = deletableNode.left;
            return deletableNode.right;
        }
    }


    public static void main(String[] args) {
        String [] arr = {"6", "3", "8", "2", "4", "7","10", "1"};
        Node root = BinaryTreeUtility.buildTree(arr);
        root = deleteNode(root,6);
        BinaryTreeUtility.inOrder(root);
    }






}
