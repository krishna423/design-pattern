package com.example.designpattern.logics.Coding.dp.Fibonacci;

public class HouseRobber {


    static int calMoney(int[] arr, int n, int [] dp){

        if(n==0) return arr[0];
        if(n==1) return Math.max(arr[0],arr[1]);

        if(dp[n]!=-1) return dp[n];

        return dp[n] = Math.max(calMoney(arr, n-2,dp)+arr[n], calMoney(arr, n-1,dp));

    }


    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        int len = arr.length;

        int[] dp = new int[len+1];
        for(int i=0;i<len+1;i++) dp[i]=-1;

        int ans = calMoneySpaceOptimised(arr, len-1, dp);
        System.out.println(ans);
    }



    static int calMoneySpaceOptimised(int[] arr, int n, int [] dp){

        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);

        for (int i = 2; i <= n; i++) {

            int current = Math.max(prev2 + arr[i], prev1);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;

    }
}
