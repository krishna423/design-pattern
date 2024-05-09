package com.example.designpattern.company;

public class MS_Max_RectangleUsingAEqualsB {





    static int calculateCount(String[] board, int i, int j, char ch,int [][] dp){

        if(i<0 || j<0) return 0;
        if(i==0 && j==0) {
            if (board[i].charAt(j) == ch) return dp[i][j] = 1;
            else return dp[i][j] = 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];
        int s1 = calculateCount(board,i-1,j,ch,dp);
        int s2 = calculateCount(board,i,j-1,ch,dp);
        int s3 = calculateCount(board,i-1,j-1,ch,dp);
        int s4 = ch == board[i].charAt(j) ? 1 : 0;

        int sum = s1+s2-s3+s4;
       // System.out.println( i + " " + j  + "    " + s1 + " " + s2 + " " + s3 + " " + s4);
        return dp[i][j] = sum;
    }


    public static void main(String[] args) {
//        String[] arr = {"...A","...A","...A"};
        //String[] arr = {"AB.","B..","..A"};
        String[] arr = {"A.","AB"};
        System.out.println(solution(arr));
    }

    public static int solution(String[] board) {
        // Implement your solution here

        int m = board.length;;
        int n = board[0].length();


        int [][]dpA = new int[m][n];
        int [][]dpB = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dpA[i][j]=-1;
                dpB[i][j]=-1;
            }

        }
        calculateCount(board, m-1, n-1,'A',dpA);
        calculateCount(board, m-1, n-1,'B',dpB);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dpA[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dpB[i][j] + " ");
            }
            System.out.println();
        }

        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dpA[i][j] == dpB[i][j]) count++;
            }
        }


        return count;
    }

}
