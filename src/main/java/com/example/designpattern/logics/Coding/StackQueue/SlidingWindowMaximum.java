package com.example.designpattern.logics.Coding.StackQueue;

import java.util.*;

public class SlidingWindowMaximum {



    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        int temp ;
        for (int i = 0; i < n-k+1; i++) {
            temp = arr[i];
            for (int j = 1; j < k ; j++) {
                temp = Math.max(temp, arr[i+j]);
            }
            list.add(temp);
        }
        return list;

    }


    static ArrayList<Integer> max_of_subarrays_optimized(int arr[], int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(0);

        for (int i = 1; i < k; i++) {
            while (!deque.isEmpty()) {
                if(arr[deque.getLast()] < arr[i]) {
                    deque.removeLast();
                }else{
                    break;
                }
            }
            deque.add(i);
        }
        list.add(arr[deque.getFirst()]);


//        System.out.println(deque);
        for (int i = k; i < n ; i++) {
            if( deque.getFirst() == i-k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty()) {
                if(arr[deque.getLast()] < arr[i]) {
                    deque.removeLast();
                }else{
                    break;
                }
            }

            deque.add(i);
            list.add(arr[deque.getFirst()]);
  //          System.out.println("Test  " + i + "  " + deque);
        }
        return list;
    }








    public static void main(String[] args) {

//        int [] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
//        int k = 3;

//        int [] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
//        int k =4;

        int [] arr = {11, 10, 9, 8, 7, 5, 2, 3, 6};
        int k = 1;
        System.out.println(max_of_subarrays(arr, arr.length,k));
        System.out.println(max_of_subarrays_optimized(arr, arr.length,k));
    }
}
