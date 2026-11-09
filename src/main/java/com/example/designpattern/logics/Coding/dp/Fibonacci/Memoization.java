package com.example.designpattern.logics.Coding.dp.Fibonacci;

import java.util.Arrays;

public class Memoization {

//Value   0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
//Index   0, 1, 2, 3, 4, 5, 6, 7,  8,  9,  10, 11, 12


    static int fibbo(int n, int[] dp){
        if(n<=1) return n;

        if(dp[n]!=-1){
            return dp[n];
        }

        return dp[n]  = fibbo(n-1, dp)+ fibbo(n-2, dp);
    }



    public static void main(String[] args) {
        int x =40;

        int[] dp = new int[x+1];
        Arrays.fill(dp, -1);
        //2D array-- use for loop


        int ans = fibbo(x, dp);
        System.out.println(ans);
    }
}
