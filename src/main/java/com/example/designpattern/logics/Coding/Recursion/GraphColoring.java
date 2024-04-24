package com.example.designpattern.logics.Coding.Recursion;

import org.springframework.boot.web.embedded.netty.NettyWebServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphColoring {

    static List<Integer>[] getAdjencyList(boolean [][] graph){
        ArrayList<Integer>[] adjList = new ArrayList[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(graph[i][j]){
                    if(i==j) continue;
                    if(adjList[i]==null){
                        adjList[i] = new ArrayList<>();
                    }
                    adjList[i].add(j);
                }
            }
        }
        return adjList;

    }

    public static boolean graphColoring(boolean graph[][], int m, int v) {


        int color[] = new int[v];
        Arrays.fill(color,-1);

        boolean ans = mColor(graph,m,v,color,0);//0 is starting vartice
        return ans;
    }
    public static boolean mColor(boolean graph[][],int m,int v,int color[],int currentV){
        if(currentV == v){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(isPossibleToColor(graph,v,color,currentV,i)){
                color[currentV] = i;
                if(mColor(graph,m,v,color,currentV+1)){
                    return true;
                }
                color[currentV] = -1;
            }
        }
        return false;

    }
    //check any adjacent contain same color. if contain same color return false else return true.
    public static boolean isPossibleToColor(boolean graph[][],int v,int color[],int currentV,int i){
        for(int j=0;j<v;j++){
            if(graph[currentV][j]==true && color[j] == i){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
//        int [][]edges = {{0,1},{1,2},{2,3},{3,0},{0,2}};
//        int matrixSise= 4;
//        int colourCount = 3;


        int [][]edges = {{5,1},{5,3},{4,5}};
        int matrixSise= 5;
        int colourCount = 1;

        boolean [][]matrix = new boolean[matrixSise][matrixSise];
        for(int[] ints : edges){
            matrix[ints[0]][ints[1]]=true;
            matrix[ints[1]][ints[0]]=true;
        }
        System.out.println(graphColoring(matrix, edges.length, colourCount));
    }




}
