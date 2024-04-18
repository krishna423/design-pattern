package com.example.designpattern.logics.Coding.Recursion;

import java.util.ArrayList;

public class NQueen {

    static boolean isSafe(int N, int [][] board, int row, int col)
    {
        int i, j;

        // Check this row on left side
        for (i = 0; i < col; i++)
            if (board[row][i]==1)
                return false;

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j]==1)
                return false;

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j]==1)
                return false;
        return true;
    }


    static void solveNQUtil(int N, int [][] board, int col, ArrayList<ArrayList<Integer>> ans)
    {
        if (col == N){
            ArrayList<Integer> res = new ArrayList<>();
            for(int i =0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(board[j][i]==1) {
                        res.add(j+1);
                    }
                }
            }
            ans.add(res);
        }

        // Consider this column and try placing
        // this queen in all rows one by one
        for (int i = 0; i < N; i++) {

            // Check if the queen can be placed on
            // board[i][col]
            if (isSafe(N, board, i, col)) {
                // cout << "   cc " << col <<  " ";
                // Place this queen in board[i][col]
                board[i][col] = 1;

                // recur to place rest of the queens
                solveNQUtil(N, board, col + 1, ans);

                // If placing queen in board[i][col]
                // doesn't lead to a solution, then
                // remove queen from board[i][col]
                board[i][col] = 0; // BACKTRACK
            }
        }
    }



    static ArrayList<ArrayList<Integer>>  nQueen(int n) {
        // code here
        int [][] board = new int[n][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solveNQUtil(n, board, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(nQueen(4));
        System.out.println(nQueen(1));
        System.out.println(nQueen(5));
    }
}
