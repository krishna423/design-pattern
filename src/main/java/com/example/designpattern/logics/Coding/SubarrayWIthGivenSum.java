package com.example.designpattern.logics.Coding;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWIthGivenSum {

    //Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int [] arr, int n, int sum)
    {
        Map<Integer,Integer> prefixSum = new HashMap<>();
        int sumTillNow =0;
        int prefixSumTillNow = 0;
        int subArrayCount =0;

        prefixSum.put(0,1);


        for (int i = 0; i < n; i++) {
            sumTillNow += arr[i];
            prefixSumTillNow = sumTillNow-sum;

            if(prefixSum.containsKey(prefixSumTillNow)){
                subArrayCount+= prefixSum.get(prefixSumTillNow);
            }

            if(prefixSum.containsKey(sumTillNow)){
                int counter = prefixSum.get(sumTillNow);
                prefixSum.put(sumTillNow,++counter);
                System.out.println(sumTillNow + "  counter " + counter);
            }else{
                prefixSum.put(sumTillNow,1);
                System.out.println(sumTillNow + "  counter " + 1);

            }
        }
        // add your code here
        return subArrayCount;
    }

    public static void main(String[] args) {
        int [] arr = {12,20, 14, 24, 5, 24, 28, 4, 2, 8, 0, 13, 4, 22, 2};
        int sum = 1;
        System.out.println(subArraySum(arr,arr.length,sum));

    }
}
