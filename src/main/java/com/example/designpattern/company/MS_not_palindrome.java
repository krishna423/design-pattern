package com.example.designpattern.company;

public class MS_not_palindrome
{
    static int dp[][] = new int[2000][2000];

    // Function definition

    static int checkPalindrome(String s,  int st, int end ){
        int n = end-st;
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int m = n/2;

        for (int i = 0; i < m; i++) {
            if(s.charAt(i) != s.charAt(n-i-1)){
                return 0;
            }
        }
        return 1;
    }

    static int utility(String s,  int st, int end){
        if(st>=end){
            return 0 ;
        }
        int ans = checkPalindrome(s,st,end);
        if(ans ==0){
            return 0;
        }
        return Math.min( utility(s,st+1,end),utility(s,st,end-1))+1;
    }

    public static int minInsertions(String s) {

        int n = s.length();

        if(n==1){
            return 1;
        }
        int m = n/2;

        for (int i = 0; i < m; i++) {
            if(s.charAt(i) != s.charAt(n-i-1)){
                return 0;
            }
        }
        System.out.println("sasa");
        return utility(s,0,n);
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("xxxx"));
    }
}