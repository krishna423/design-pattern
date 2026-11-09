package com.example.designpattern.logics.Coding.dp.Fibonacci;

public class TabularForm {

    static int fibbo(int n){
        int[] dp = new int[n+1];

        dp[0]=0;
        dp[1]=1;

        for (int i = 2; i <= n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
       // int value  = fibbo(n-1)+ fibbo(n-2);
        return dp[n];
    }



    public static void main(String[] args) {
        int x =40;
        int ans = fibbo(x);
        System.out.println(ans);
    }
}
