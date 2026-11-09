package com.example.designpattern.logics.Coding.dp.Fibonacci;

import java.util.Arrays;

public class FrogJump_MinimumEnergyRequired {


    static int calculateEnergy(int n,int arr[], int [] dp){

        if(n==0) return 0; // Same floor -- no energy required
        if(n==1) return Math.abs(arr[1]-arr[0]); // Just one floor above - 2nd floor

        if(dp[n]!=-1) return dp[n];

        int left = calculateEnergy(n-1,arr, dp ) + Math.abs(arr[n]-arr[n-1]);
        int right =calculateEnergy(n-2,arr, dp ) + Math.abs(arr[n]-arr[n-2]);

        return dp[n] = Math.min(left,right);
    }

    public static void main(String[] args) {

        int x=5;
        int [] arr =  {7, 5, 1, 2, 6};
        int[] dp = new int[x+1];
        Arrays.fill(dp,-1);


        //int ans = calculateEnergy(x-1,arr , dp);
        int ans = calculateEnergyTabular(x-1,arr , dp);
        System.out.println(ans);

    }


    static int calculateEnergyTabular(int n,int arr[], int [] temp){

        int[] dp = new int[n+1];

        //if(n==0) return 0; // Same floor -- no energy required
        dp[0]=0;

        //if(n==1) return Math.abs(arr[1]-arr[0]); // Just one floor above - 2nd floor
        dp[1]= Math.abs(arr[1]-arr[0]);

        //if(dp[n]!=-1) return dp[n];

        for (int i = 2; i < n+1; i++) {
            int left = dp[i-1] + Math.abs(arr[i]-arr[i-1]);
            int right =dp[i-2] + Math.abs(arr[i]-arr[i-2]);

            dp[i] = Math.min(left,right);
        }

        return  dp[n];

    }



}
