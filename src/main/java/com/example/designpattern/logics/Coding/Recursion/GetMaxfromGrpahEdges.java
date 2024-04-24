package com.example.designpattern.logics.Coding.Recursion;

import java.util.*;


public class GetMaxfromGrpahEdges {
    /*
     * Complete the function below.
     * Base query: https://jsonmock.hackerrank.com/api/stocks
     */

    public static int solution(int N, int[] A, int[] B) {
        // Implement your solution here
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i],0)+1);
            map.put(B[i], map.getOrDefault(B[i],0)+1);
        }

        int [] weight = new int[N+1];
        int sum =0;
        int n=N;

        int [] t1 = new int[N+1];
        int [] t2 = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            t2[i] = i;
        }

        for(Map.Entry<Integer,Integer> mapEntry : map.entrySet()){
            //System.out.println( mapEntry.getKey() + " " + mapEntry.getValue());
            t1[mapEntry.getKey()] = mapEntry.getValue();
            // weight[mapEntry.getKey()] = n--;
        }


        for (int i = 0; i < t1.length; i++) {
            for (int j = i+1; j < t1.length; j++) {
                if(t1[i] < t1[j]){
                    int temp = t1[i];
                    t1[i] = t1[j];
                    t1[j] = temp;

                    temp = t2[i];
                    t2[i] = t2[j];
                    t2[j] = temp;

                }
            }
        }




       // System.out.println("map");
//
//        for (int i = 0; i < N+1; i++) {
//            System.out.print(t2[i] + " ");
//        }
//        System.out.println("");

        for (int i = 0; i < N+1; i++) {
            weight[t2[i]]=n--;
        }
       // System.out.println("");



        for (int i = 0; i < A.length; i++) {
            sum = sum +  weight[A[i]] + weight[B[i]];
        }

        return sum;
    }


    public static void main(String[] args){
        int [] a = {2,2,1,2};
        int [] b = {1,3,4,4,};
        System.out.println(solution(5,a,b));
    }
}