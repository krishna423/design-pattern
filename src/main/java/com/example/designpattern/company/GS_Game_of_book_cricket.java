package com.example.designpattern.company;

public class GS_Game_of_book_cricket {



    public static int noOfWaysToDrawTheGame(int totalScore) {
        if (totalScore % 2 != 0){
            return 0;
        }
        int [] dp = new int[totalScore+1];
        for (int i = 0; i < totalScore+1 ; i++) {
            dp[i] = -1;
        }
        return noOfWaysToDrawTheGameUtil(totalScore,dp);
    }


    public static int noOfWaysToDrawTheGameUtil(int totalScore,int [] dp) {

        if(totalScore<=0){
            return 0;
        }
        if(totalScore==2 ){
            return 1;
        }
        if(totalScore==4){
            return 2;
        }
        if(totalScore==6){
            return 4;
        }

        if(dp[totalScore]!=-1) return dp[totalScore];

        int sum = noOfWaysToDrawTheGameUtil(totalScore-2,dp)
                + noOfWaysToDrawTheGameUtil(totalScore-4,dp)
                + noOfWaysToDrawTheGameUtil(totalScore-6,dp);

        return dp[totalScore] = sum;
    }



}
