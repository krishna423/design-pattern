package com.example.designpattern.logics.Coding.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {

    static boolean isPossible(int arr[], int N, int k, int curr_min){

        int noOfCowsArranged = 1;
        int lastCowPosition = 0;
        //System.out.println("mid "+ curr_min);

        for (int i = 1; i < N; i++) {
            if(arr[i]-arr[lastCowPosition]<curr_min){
                continue;
            }else{
                //System.out.println("noOfCowsArranged "+ i);
                noOfCowsArranged++;
                lastCowPosition=i;
            }
        }
        if (noOfCowsArranged < k){
            // System.out.println("noOfCowsArranged Not possible" + noOfCowsArranged  + " " + false);
            return false;
        }else{
            // System.out.println("noOfCowsArranged required " + noOfCowsArranged + " " + true);
            return true;
        }
    }

    public static int solve(int n, int k, int[] stalls) {

        if (k > n)
            return -1;

        Arrays.sort(stalls);

        int mxDistance = stalls[n-1]-stalls[0];

        // initialize start as 0 pages and end as
        // total pages
        int start = 1, end = mxDistance;
        int result = mxDistance;

        // traverse until start <= end
        while (start <= end) {
            // check if it is possible to distribute books by using mid as current minimum
            int mid = (start + end) / 2;
            // System.out.println("mid" + mid);
            if (!isPossible(stalls, n, k, mid)) {
                //Although got the on of the possible result but trying to get the minimum pages as result


                end = mid - 1;
            }else{
                // if not possible means pages should be
                result = mid;
                start = mid + 1;
            }
        }

        // at-last return minimum no. of  pages
        return result;
    }

    public static void main(String[] args) {

//        int [] stalls = {1, 2, 4, 8, 9};
//        int h=3;

        int [] stalls = {10, 1, 2, 7, 5};
        int h=3;

        System.out.println(solve(stalls.length,h,stalls));
    }
}
