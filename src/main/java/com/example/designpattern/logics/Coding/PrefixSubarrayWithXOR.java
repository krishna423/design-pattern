package com.example.designpattern.logics.Coding;

import java.util.HashMap;
import java.util.Map;

public class PrefixSubarrayWithXOR {

     static int subarraysWithSumK(int[] arr, int sum) {
        // Write your code here

        Map<Integer, Integer> prefixSum = new HashMap<>();

        int n = arr.length;
        int sumTillNow = 0;
        int prefixSumTillNow = 0;
        int subArrayCount = 0;
        prefixSum.put(0, 1);

        for (int i = 0; i < n; i++) {
            sumTillNow = sumTillNow ^ arr[i];
            prefixSumTillNow = sumTillNow ^ sum;

            if (prefixSum.containsKey(prefixSumTillNow)) {
                subArrayCount += prefixSum.get(prefixSumTillNow);
            }

            if (prefixSum.containsKey(sumTillNow)) {
                int counter = prefixSum.get(sumTillNow);
                prefixSum.put(sumTillNow, ++counter);
                //System.out.println(sumTillNow + "  counter " + counter);
            } else {
                prefixSum.put(sumTillNow, 1);
                //System.out.println(sumTillNow + "  counter " + 1);

            }
        }
        // add your code here
        return subArrayCount;
    }


    public static void main(String[] args) {
         int [] arr = {1, 2, 3, 2};
        System.out.println(subarraysWithSumK(arr,2));
    }
}
