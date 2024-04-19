package com.example.designpattern.logics.Coding.Recursion;

public class SudokuSolver {


    static boolean UsedInRow(int [][] grid, int row, int num){
        for (int col = 0; col < grid.length; col++)
            if (grid[row][col] == num)
                return true;
        return false;
    }


    static boolean UsedInCol(int [][]grid, int col, int num){
        for (int row = 0; row < grid.length; row++)
            if (grid[row][col] == num)
                return true;
        return false;
    }

    static boolean UsedInBox(int [][]grid, int boxStartRow, int boxStartCol, int num){
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (grid[row + boxStartRow][col + boxStartCol] ==num)
                    return true;
        return false;
    }

    static boolean isSafe(int [][]grid, int row, int col, int num)    {

        return !UsedInRow(grid, row, num)
                && !UsedInCol(grid, col, num)
                && !UsedInBox(grid, row - row % 3,
                col - col % 3, num);
    }


    static boolean SolveSudoku(int [][] grid){
        int row=-1, col=-1;

        // If there is no unassigned location,
        // we are done
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++){
                if(grid[i][j]==0){
                    row=i;
                    col=j;
                }
            }
        }

        if (row==-1 || col==-1){
            return true;
        }

        // Consider digits 1 to 9
        for (int num = 1; num <= 9; num++)
        {

            // Check if looks promising
            if (isSafe(grid, row, col, num))
            {

                // Make tentative assignment
                grid[row][col] = num;

                // Return, if success
                if (SolveSudoku(grid))
                    return true;

                // Failure, unmake & try again
                grid[row][col] = 0;
            }
        }

        // This triggers backtracking
        return false;
    }


    //Function to print grids of the Sudoku.
    static void printGrid (int [][] grid)
    {
        // Your code here
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++)
                System.out.print(grid[row][col]+" ");
            System.out.println("");
        }
    }


    public static void main(String[] args) {
        int grid [][] = {
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };
        System.out.println(SolveSudoku(grid));
        printGrid(grid);
    }
}
