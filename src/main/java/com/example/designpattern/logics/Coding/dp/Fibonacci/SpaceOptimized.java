package com.example.designpattern.logics.Coding.dp.Fibonacci;

import java.util.Arrays;

public class SpaceOptimized {

    static int fibbo(int n){
        if(n<=1) return n;


        int prev2 = 0; // 0-th index
        int pre = 1;  // 1-th index

        for (int i = 2; i <= n ; i++) {
            int curr = pre + prev2;
            prev2 = pre;
            pre = curr;
        }
       // int value  = fibbo(n-1)+ fibbo(n-2);
        return pre;
    }



    public static void main(String[] args) {
        int x =40;
        int ans = fibbo(x);
        System.out.println(ans);
    }
}
