package com.example.designpattern.logics.Coding.dp.Fibonacci;

import java.util.Arrays;

public class NinjaTraining {




    static int calMaxReward(int [][] arr, int day, int taskCount, int lastPerformedTask, int [][] dp){
        //Base case
        if(day==0){

            int maxValue=Integer.MIN_VALUE;

            for (int i = 0; i < taskCount; i++) {
                if(i!=lastPerformedTask){
                    maxValue = Math.max(maxValue, arr[0][i]);
                }
            }
            return  maxValue;
        }

        //memoization
        if(dp[day][lastPerformedTask]!=-1) return dp[day][lastPerformedTask];

        int maxValue=Integer.MIN_VALUE;

        //Recursion calling
        for (int i = 0; i < taskCount; i++) {
            if(i!=lastPerformedTask){
                int rewardPoints = arr[day][i] + calMaxReward(arr, day-1, taskCount, i,dp);
                maxValue = Math.max(maxValue, rewardPoints);
            }
        }


        return dp[day][lastPerformedTask] = maxValue;

    }



    public static void main(String[] args) {

        //rows - day no of days
        //columns- 3 tasks reward points 0- running, 1- stealth, 2-new skill, 3-not did anything
        int [][] arr = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int rows = arr.length;
        int colums = arr[0].length;



        int [][] dp = new int[rows+1][colums+1];

        for (int i = 0; i < rows+1; i++) {
            Arrays.fill(dp[i],-1);
        }



        int ans = calMaxReward(arr, arr.length-1,3,3,dp);
        System.out.println(ans);


    }


}
