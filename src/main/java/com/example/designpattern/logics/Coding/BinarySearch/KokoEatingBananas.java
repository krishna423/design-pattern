package com.example.designpattern.logics.Coding.BinarySearch;

public class KokoEatingBananas {

    static boolean isPossible(int arr[], int N, int H, int curr_min){

        int hoursRequired = 0;
        int curr_sum = 0;

        for (int i = 0; i < N; i++) {
            hoursRequired += (int)Math.ceil(arr[i]/(double)curr_min);
        }
        if (hoursRequired > H){
            // System.out.println("hours required Not possible" + hoursRequired + " " + false);
            return false;
        }else{
            // System.out.println("hours required " + hoursRequired + " " + true);
            return true;
        }
    }


    public static int Solve(int N, int[] piles, int H) {

        int sum = 0;

        if (N > H)
            return -1;

        int mx = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            sum += piles[i];
            mx = Math.max(mx, piles[i]);
        }

        // initialize start as 0 pages and end as
        // total pages
        int start = 1, end = mx;
        int result = mx;

        // traverse until start <= end
        while (start <= end) {
            // check if it is possible to distribute books by using mid as current minimum
            int mid = (start + end) / 2;
            // System.out.println("mid" + mid);
            if (isPossible(piles, N, H, mid)) {
                //Although got the on of the possible result but trying to get the minimum pages as result
                result = mid;

                end = mid - 1;
            }

            else
                // if not possible means pages should be
                start = mid + 1;
        }

        // at-last return minimum no. of  pages
        return result;
    }

    public static void main(String[] args) {
//        int [] piles = {3, 6, 7, 11};
//        int h = 8;

        int [] piles = {30, 11, 23, 4, 20};
        int h=5;
        System.out.println(Solve(piles.length, piles,h));
    }

}
