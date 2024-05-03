package com.example.designpattern.logics.Coding.dp;

import java.io.ByteArrayInputStream;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class SubSetSumProblem {


    //Why not 1D array used here

// Example   {3, 2, 4, 5} ArraySize = 4 , Target = 9
//                        (3,9)
//                       /
//                    (2,9)
//                    /                 \
//                 (1,9)               (1,5) But dp[1]=false, return false
//   Not Taken   /              \Taken
//         (0,9) dp[0]=false  (0,9-2=7)
//       /  \                 As dp[0]=false, return false, without calculating left right
//  (-1,9)  (-1,6)





    static int isSubsetSumUtil(int N, int arr[], int sum, int [][] dp){
        // code here
        //System.out.println("index : " + N + "  sum :"  + sum);
        if(sum==0){
            return 1;
        }
        if(N<0 || sum<0){
            return 0;
        }


        if(dp[N][sum]!=-1) return dp[N][sum];
        // if(arr[N] >sum ){
        //     return dp[N]= false;
        // }
        return dp[N][sum] = (isSubsetSumUtil(N-1,arr,sum,dp)==1 || isSubsetSumUtil(N-1,arr,sum-arr[N],dp)==1) ? 1 : 0;

    }


    static boolean isSubsetSum(int N, int arr[], int sum){

        int [][]dp = new int[N][sum+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < sum+1; j++) {
                dp[i][j] =-1;
            }
        }

        return isSubsetSumUtil(N - 1, arr, sum, dp) == 1;
    }

    public static void main(String[] args) {
        int []arr = {3, 34, 4, 12, 5, 2};

        int sum = 9;
        System.out.println(isSubsetSum( arr.length,arr,sum));
    }
}
