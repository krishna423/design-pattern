package com.example.designpattern.logics.Coding.dp;

public class knapsack {


    static int knapSackUtil(int bagRemainingWeight, int wt[], int val[], int n, int [][] dp)
    {
       // System.out.println(" W" + bagRemainingWeight + "  n " + n );

        if(bagRemainingWeight==0) return 0;
        if(n<0 || bagRemainingWeight <0) return 0;

        if(dp[n][bagRemainingWeight]!=-1) return dp[n][bagRemainingWeight];
        int taken =0;
        int notTaken = 0 +  knapSackUtil(bagRemainingWeight, wt, val, n-1,dp);
        if(bagRemainingWeight>=wt[n]) {
            taken = val[n] + knapSackUtil(bagRemainingWeight - wt[n], wt, val, n - 1,dp);
        }
        //System.out.println( notTaken + "  " + taken);
        return dp[n][bagRemainingWeight] = Math.max(notTaken,taken);
    }





    static int knapSackUtilOptimzed(int bagRemainingWeight, int wt[], int val[], int n, int [][] dp)
    {
        // System.out.println(" W" + bagRemainingWeight + "  n " + n );

        if(n==0 ){
            if(bagRemainingWeight>=wt[n]) return val[n];
            else return 0;
        }

        if(dp[n][bagRemainingWeight]!=-1) return dp[n][bagRemainingWeight];
        int taken =0;
        int notTaken = 0 +  knapSackUtilOptimzed(bagRemainingWeight, wt, val, n-1,dp);
        if(bagRemainingWeight>=wt[n]) {
            taken = val[n] + knapSackUtilOptimzed(bagRemainingWeight - wt[n], wt, val, n - 1,dp);
        }
        //System.out.println( notTaken + "  " + taken);
        return dp[n][bagRemainingWeight] = Math.max(notTaken,taken);
    }







    static int knapSack(int W, int wt[], int val[], int n)
    {
        int [][]dp = new int[n][W+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < W+1; j++) {
                dp[i][j]=-1;
            }
        }
        return knapSackUtilOptimzed(W,wt,val,n-1,dp);

    }


    public static void main(String[] args) {
//        int N = 3;
//        int W = 4;
//        int values[] = {1,2,3};
//        int weight[] = {4,5,1};


        int values[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };

        int W = 50;
        int N = values.length;

        System.out.println(knapSack(W,weight,values,N));

    }
}
