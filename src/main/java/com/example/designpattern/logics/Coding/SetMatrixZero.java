package com.example.designpattern.logics.Coding;

public class SetMatrixZero {



    static void markRowZero(int [][] matrix, int x, int n){
        for (int j = 0; j < n; j++) {
            matrix[x][j]=0;
        }
    }

    static void markColumnZero(int [][] matrix, int x, int m){
        for (int j = 0; j < m; j++) {
            matrix[j][x]=0;
        }

    }

    static void  setZero(int [][] matrix, int m, int n){

        boolean isRowToBeMarkedZero = false;
        boolean isColumnToBeMarkedZero = false;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    if(i==0 && j==0){
                        isColumnToBeMarkedZero=true;
                        isRowToBeMarkedZero=true;
                    } else if(i==0 ){
                        isRowToBeMarkedZero=true;
                    } else if (j==0) {
                        isColumnToBeMarkedZero=true;
                    }else {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        for (int i = m-1; i > 0; i--) {
            if(matrix[i][0]==0){
                markRowZero(matrix, i, n);
            }
        }


        for (int i = n-1; i > 0; i--) {
            if(matrix[0][i]==0){
                markColumnZero(matrix, i, m);
            }
        }

        System.out.println( isColumnToBeMarkedZero + " " + isRowToBeMarkedZero);
        if(isColumnToBeMarkedZero){
            markColumnZero(matrix,0,m );
        }

        if(isRowToBeMarkedZero){
            markRowZero(matrix,0,n );
        }

    }


    public static void main(String[] args) {

//        int [][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        //int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int [][] matrix = {{1,0}};
        int m= matrix.length;
        int n= matrix[0].length;

        setZero(matrix, m, n);

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print( matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }


}
