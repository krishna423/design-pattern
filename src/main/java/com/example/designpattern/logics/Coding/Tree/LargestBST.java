package com.example.designpattern.logics.Coding.Tree;

public class LargestBST {

    static int globalMax =0;

    static int largestBst(Node root)
    {
        // Write your code here
        globalMax = 0;
        findLargestBst(root);
        return globalMax;
    }

    static TempNode findLargestBst(Node root)
    {
        // Write your code here
        if(root==null){
            return  new TempNode(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }

        TempNode left = findLargestBst(root.left);
        TempNode right = findLargestBst(root.right);

        if(left.size==-1 || right.size == -1){
            return new TempNode(-1,-1,-1);
        }
        System.out.println( left.min + " " + left.max + " " + left.size + "         root " + root.data +
                "    " + right.min + " " + right.max + " " + right.size );
        if( root.data > left.max && root.data < right.min ){
            int temp = left.size+ right.size+1;
            globalMax = Math.max(globalMax,temp);
            int min = left.min!=Integer.MAX_VALUE ? left.min : root.data;
            int max = right.max!=Integer.MIN_VALUE ? right.max : root.data;
            return new TempNode(min, max, temp);
        }else {
            return new TempNode(-1,-1,-1);
        }
    }

    public static void main(String[] args) {
        String [] arr = {"10", "5", "18", "2", "9", "15", "19", "N", "4", "8", "N", "8"};
        Node root = BinaryTreeUtility.buildTree(arr);
        System.out.println(largestBst(root));
    }

    static class TempNode{
        int min;
        int max;
        int size;

        public TempNode(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }


}
