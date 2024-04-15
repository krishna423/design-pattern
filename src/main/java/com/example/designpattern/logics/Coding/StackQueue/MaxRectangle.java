package com.example.designpattern.logics.Coding.StackQueue;

import java.util.Stack;

public class MaxRectangle {

    public static long getMaxArea(long hist[], long n)
    {
        // your code here
        long c1 = 0;
        long c2 = 0;

        long result = 0;
        for (int i = 0; i <n ; i++) {
            c1 = 0;
            c2 = 0;

            for (int j = i+1; j < n ; j++) {
                if(hist[j] < hist[i]){
                    break;
                } else  {
                    c2 = j-i;
                }
            }

            for (int j = i-1; j >= 0 ; j--) {
                if(hist[j] < hist[i]){
                    break;
                } else {
                    c1 = i-j;
                }
            }
            result = Math.max( result, (c2+c1+1)*hist[i]);
        }
        return result;
    }



    public static long getMaxAreaOptimizedWay(long hist[], long n)
    {
        // your code here
        long c1 = 0;
        long c2 = 0;

        int size = (int) n;

        long left[] = new long[size];
        long right[] = new long[size];
        Stack<Integer> stack = new Stack();

        int temp;
        //NSE next smallest number
        for (int j = size-1; j >= 0 ; j--) {
            while(!stack.empty() && hist[j] <= hist[stack.peek()]){
                stack.pop();
            }
            temp = stack.empty() ? size : stack.peek();
            stack.push(j);
            right[j] = temp;
        }

        stack.clear();
        for (int j = 0; j < n ; j++) {
            while(!stack.empty() && hist[j] <= hist[stack.peek()]){
                stack.pop();
            }
            temp = stack.empty() ? -1 : stack.peek();
            stack.push(j);
            left[j] = temp;
        }


        for (int i = 0; i < size; i++) {
            System.out.print(left[i]+ " ");
        }
        System.out.println("");

        for (int i = 0; i < size; i++) {
            System.out.print(right[i]+ " ");
        }
        System.out.println("");

        long result = 0;
        for (int i = 0; i <n ; i++) {

            result = Math.max( result, (right[i] - left[i]-1) *hist[i]);
        }
        return result;
    }


    public static void main(String[] args) {
         long arr[] = {6,2,5,4,5,1,6};
        //long arr[] = {7,2,8,9,1,3,6,5};
        //long arr[] = {2,8,9,11};
        //long arr[] = {6,8};

        System.out.println(getMaxArea(arr, arr.length));
        System.out.println(getMaxAreaOptimizedWay(arr, arr.length));
    }


}
