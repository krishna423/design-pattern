package com.example.designpattern.logics.Coding;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    
    public static int  bfs(Queue<Position> queue, int[][] grid ){
        
        int [] stepXArray = {-1,1,0,0};
        int [] stepYArray = {0,0,-1,1};
        int adjX ,adjY;
        int ans=0;

        while(!queue.isEmpty()){
            Position position = queue.poll();
            ans = position.step;

            for (int i = 0; i < stepYArray.length; i++) {
                adjX = position.x + stepXArray[i];
                adjY = position.y + stepYArray[i];
                if(isValid( adjX, adjY , grid.length,grid[0].length) && grid[adjX][adjY]==1){
                     grid[adjX][adjY]=2;
                     queue.add(new Position(adjX,adjY, position.step+1));
                 }
            }
        }
        return ans;
    }

    private static boolean isValid(int i, int j, int gridLengthX, int gridLengthY) {
        if(i<0 || j<0 || i>=gridLengthX || j>= gridLengthY ){
            return false;
        }
        return true;
    }

    static boolean checkAllOrangeRotten(int [][] grid){
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if(anInt == 1){
                    return false;
                }
            }

        }
        return true;
    }

    public static int orangesRotting(int[][] grid) {

        Queue<Position> queue = new LinkedList<>();
        
        
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = grid[i][j];
                if (anInt == 2) {
                    queue.add(new Position(i,j,0));
                }
            }
        }
        int ans = bfs(queue,grid);
        if(checkAllOrangeRotten(grid)){
            return ans;

        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int [][] grid = {
                        { 1, 1, 0, 1 },
                        { 1, 1, 1, 1 },
                        { 0, 1, 2, 1 },
                        { 1, 1, 1, 0 } };

        System.out.println(orangesRotting(grid));

        int [][] grid2 = {
                { 1 , 1},
                { 0 , 2 }};

        System.out.println(orangesRotting(grid2));
    }

}

class Position{
    int x,y;
    int step;

    public Position(int x, int y,int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
