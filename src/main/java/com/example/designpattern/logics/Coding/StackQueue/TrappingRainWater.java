package com.example.designpattern.logics.Coding.StackQueue;

public class TrappingRainWater {



    static long trappingWater(int arr[], int n) {


        long result = 0;
        for (int i = 1; i < n-1; i++) {
            int l_max = 0;
            int r_max = 0;
            for (int j = i-1; j >=0 ; j--) {
                if(arr[j]>l_max){
                    l_max = arr[j];
                }
            }
            for (int j = i+1; j <n ; j++) {
                if(arr[j]>r_max){
                    r_max = arr[j];
                }
            }
            System.out.println(arr[i] + " " + l_max + " " + r_max);
            result = result + Math.max(0, Math.min(l_max,r_max)-arr[i]);
        }
        return result;
    }





    static long trappingWaterUsingSpace(int arr[], int n) {


        long result = 0;
        int [] l_max = new int[n];
        int [] r_max = new int[n];
        l_max[0] = arr[0];
        r_max[n-1] = arr[n-1];

        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(l_max[i-1],arr[i-1]);
        }

        for (int i = n-2; i >=0; i--) {
            r_max[i] = Math.max(r_max[i+1],arr[i+1]);
        }

        for (int i = 1; i < n-1; i++) {
            result = result + Math.max(0,Math.min(l_max[i], r_max[i]) - arr[i]);
        }

        return result;
    }



    static long trappingWaterUsingTwoPointer(int arr[], int n) {


        long result = 0;
        int l_max = arr[0];
        int r_max = arr[n - 1];
        int left = 0;
        int right = n - 1;

        while (left <= right) {

            if (l_max <= r_max) {
                result = result + Math.max(0, Math.min(l_max, r_max) - arr[left]);
                l_max = Math.max(l_max, arr[left]);
                left++;
            } else {
                result = result + Math.max(0, Math.min(l_max, r_max) - arr[right]);
                r_max = Math.max(r_max, arr[right]);
                right--;
            }


        }
        return result;
    }













    public static void main(String[] args) {
        int arr[] = {3,0,0,2,0,4};
        //int arr[] = {7,4,0,9};
        //int arr[] = {8, 8, 2, 4, 5, 5, 1};
        System.out.println(trappingWater(arr, arr.length));
        System.out.println(trappingWaterUsingSpace(arr, arr.length));
        System.out.println(trappingWaterUsingTwoPointer(arr, arr.length));
    }
}
