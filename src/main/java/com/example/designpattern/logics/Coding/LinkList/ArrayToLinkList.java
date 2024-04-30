package com.example.designpattern.logics.Coding.LinkList;

import java.util.LinkedList;
import java.util.Queue;

class ArrayToLinkList
{

    // Representation of a node
    static class Node
    {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    };

    static void display(Node root)
    {
        while (root != null)
        {
            System.out.print( root.data + "->");
            root = root.next;
        }
    }

    static Node arrayToList(int arr[], int n) {
        Node root = new Node(-1);
        Node ptr = root;
        Node temp = null;
        for (int i = 0; i < n; i++){
            temp = new Node(arr[i]);
            ptr.next = temp;
            ptr = ptr.next;
        }
        return root.next;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        Node root = arrayToList(arr, n);
        display(root);

        Queue<Integer> a = new LinkedList<>();
    }
}
