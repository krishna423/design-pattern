package com.example.designpattern.logics.Coding.dp.Fibonacci;

import java.util.Arrays;

public class FrogJump_ClimbingStairs {


    //Climbing stairs, frog can jump 1 or 2 step at a  time ,
    //Find no of possible ways to reach on top
    // N(top) is given
    static int calculatePossibleWays(int n, int[] dp){
        if(n==0 | n==1) return 1;

        if(dp[n]!=-1) return dp[n];

        return dp[n] = calculatePossibleWays(n-1, dp) + calculatePossibleWays(n-2, dp);
    }



    public static void main(String[] args) {

        int x=4;

        int[] dp = new int[x+1];
        Arrays.fill(dp,-1);
        int ans = calculatePossibleWays(x,dp);
        System.out.println(ans);
    }
}
