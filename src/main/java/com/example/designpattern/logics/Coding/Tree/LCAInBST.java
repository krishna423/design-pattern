package com.example.designpattern.logics.Coding.Tree;

public class LCAInBST {


    static Node LCA(Node root, int n1, int n2)
    {
        // code here.
        if(root == null){
            return null;
        }

        if(root.data < n1 && root.data < n2 ){
            //System.out.print(root.data + " ");
            return LCA(root.right,n1,n2);
        }else if(root.data > n1 && root.data > n2 ){
            return LCA(root.left,n1,n2);
        }else{
            return root;
        }
    }

    public static void main(String[] args) {
        String [] arr = {"6", "3", "8", "2", "4", "7","10", "1"};
        Node root = BinaryTreeUtility.buildTree(arr);
        System.out.println(LCA(root,4,7).data);

        System.out.println(LCA(root,1,2).data);

        System.out.println(LCA(root,7,10).data);


    }



}
