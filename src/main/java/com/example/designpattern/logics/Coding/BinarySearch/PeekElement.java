package com.example.designpattern.logics.Coding.BinarySearch;

public class PeekElement {


    static int findPeek(int [] arr){

        int n = arr.length;
        if(n==1){
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if(i==0 && arr[i] > arr[i+1]){
                return 0;
            }
            if(i==n-1 && arr[i] > arr[i-1]){
                return i;
            }
            if(arr[i]> arr[i+1] && arr[i] > arr[i-1]){
                return i;
            }
        }
        return -1;
    }







    static int findPeekOptimizedWay(int [] arr){

        int n = arr.length;
        if(n==1){
            return 0;
        }
        if(arr[0] > arr[1]){
            return 0;
        }
        if(arr[n-1] > arr[n-2]){
            return n-1;
        }

        int low = 1;
        int high = n-2;

        while (low<=high){
            int mid = (low+high)/2;

            if(arr[mid] > arr[low] && arr[mid] > arr[high]){
                return mid;
            }

            if(arr[mid] < arr[mid+1]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        int [] arr = {1,2,89,4,5,1};
        System.out.println(findPeekOptimizedWay(arr));


        int [] arr2 = {1,22};
        System.out.println(findPeekOptimizedWay(arr2));
    }
}
