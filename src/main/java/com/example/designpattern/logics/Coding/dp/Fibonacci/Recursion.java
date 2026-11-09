package com.example.designpattern.logics.Coding.dp.Fibonacci;

public class Recursion {

//Value   0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
//Index   0, 1, 2, 3, 4, 5, 6, 7,  8,  9,  10, 11, 12


    static int fibbo(int n){
        if(n<=1) return n;

        int value  = fibbo(n-1)+ fibbo(n-2);
        return value;
    }



    public static void main(String[] args) {
        int x =12;
        int ans = fibbo(x);
        System.out.println(ans);
    }
}
