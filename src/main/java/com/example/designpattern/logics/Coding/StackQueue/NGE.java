package com.example.designpattern.logics.Coding.StackQueue;

import java.util.Stack;

public class NGE {

    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here

        long maxElement =-1;
        for (int i = 0; i < n; i++) {
            maxElement=-1;
            for (int j = i+1; j < n ; j++) {
                if(arr[i] < arr[j]){
                    maxElement = arr[j];
                    break;
                }
            }
            arr[i]=maxElement;
        }

        return arr;
    }





    public static long[] nextLargerElementOptimized(long[] arr, int n) {
        // Your code here
        Stack<Long> stack = new Stack<Long>();


        for (int i = n - 1; i >= 0; i--) {
            long current = arr[i];
            while (!stack.empty() && current >= stack.peek()) {
                stack.pop();
            }
            arr[i] = stack.empty() ? -1 : stack.peek();
            stack.push(current);

        }
        return arr;
    }


    public static void main(String[] args) {
        //long []arr =  {4,5,2,25};
        //long [] arr =  {13,7,6,12};
        long [] arr = { 11, 13, 21, 3 };
        //long [] arr = { 6, 8, 0, 1, 3 };



        arr = nextLargerElementOptimized(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
