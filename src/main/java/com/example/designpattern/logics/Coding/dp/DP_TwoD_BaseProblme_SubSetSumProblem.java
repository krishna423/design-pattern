package com.example.designpattern.logics.Coding.dp;

public class DP_TwoD_BaseProblme_SubSetSumProblem {


    //Why not 1D array used here

// Example   {3, 2, 4, 5} ArraySize = 4 , Target = 9
//                        (3,9)
//                       /     \
//                    (2,9)    (2,4)
//                   /    \
//               (1,9)    (1,5)
//                /
//           (0,9)
//         /   \
//   (-1,9)   (-1,6)



    static int isSubsetSumUtil(int n, int[] arr, int targetSum, int[][] dp){
        // code here
        //System.out.println("index : " + n + "  targetSum :"  + targetSum);

        if(n<0 || targetSum<0){
            return 0; // false
        }

        if(targetSum==0){
            return 1; // true
        }

        if(dp[n][targetSum]!=-1) return dp[n][targetSum];

        int notTaken = isSubsetSumUtil(n-1, arr,targetSum, dp);
        int taken = isSubsetSumUtil(n-1, arr,targetSum-arr[n] ,dp);

        return dp[n][targetSum] = (taken==1 || notTaken==1) ? 1 : 0;

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
