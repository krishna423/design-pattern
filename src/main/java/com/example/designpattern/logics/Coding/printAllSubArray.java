package com.example.designpattern.logics.Coding;

public class printAllSubArray {


    public static int subArraySum(int[] arr, int n)
    {
        int curr_sum;
        int i;
        int j;

        // Pick a starting point
        for (i = 0; i < n; i++) {
            curr_sum = 0;

            // try all subarrays starting with 'i'
            for (j = i; j < n; j++) {
                curr_sum = curr_sum + arr[j];
                System.out.print(curr_sum + " ");
            }
            System.out.println("");
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;

        // Function call
        subArraySum(arr, n);
    }
}
