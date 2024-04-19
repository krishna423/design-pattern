package com.example.designpattern.logics.Coding.Recursion;

import java.util.ArrayList;
import java.util.List;

public class WorldBoggle {

    static boolean search(char board[][], int i, int j, int r, int c, int index, int wordSize, String word){

        char ch = word.charAt(index);

        if(i<0 || j<0 || i>=r || j>=c || index>=wordSize || board[i][j] != ch) {
            // cout << index  << endl;
            return false;
        }
        if(index==wordSize-1 && board[i][j] == ch){
            return true;
        }
        // cout << board[i][j] <<endl;
        char temp= board[i][j];
        board[i][j]=0;
        index++;

        boolean ans = search(board, i+1 ,j, r, c, index, wordSize, word) ||
                search(board, i-1 ,j, r, c, index, wordSize, word) ||
                search(board, i ,j+1, r, c, index, wordSize, word) ||
                search(board, i ,j-1, r, c, index, wordSize, word) ||
                search(board, i+1 ,j+1, r, c, index, wordSize, word) ||
                search(board, i+1 ,j-1, r, c, index, wordSize, word) ||
                search(board, i-1 ,j+1, r, c, index, wordSize, word) ||
                search(board, i-1 ,j-1, r, c, index, wordSize, word);

        board[i][j]=temp;
        return ans;
    }

    static boolean searchInDic(char board[][], String word){

        int r = board.length;
        int c = board[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(word.charAt(0)==board[i][j]){
                    //board[i][j]=0;
                    //cout << i << " " << j << endl;
                    if(search(board, i, j, r, c, 0, word.length(), word)){
                        return true;
                    }
                    //board[i][j]=word[0];
                }
            }
        }
        return false;
    }

    static String [] wordBoggle(char [][] board, String[] dictionary) {
        // Code here
        List<String> ans = new ArrayList<>();
        for (String string : dictionary) {
            if (searchInDic(board, string)) {
                ans.add(string);
            }
        }
        String [] ansList = new String[ans.size()];
        int i=0;
        for (String s : ans){
            ansList[i++]=s;
        }

        return ansList;
    }


    public static void main(String[] args) {
        String [] dictionary = {"CAT","CANIEDP"};
        char [][] board = {{'C','A','P'},{'A','N','D'},{'T','I','E'}};

        String[] ans = wordBoggle(board,dictionary);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
