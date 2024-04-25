package com.example.designpattern.company;

import java.util.HashMap;
import java.util.Map;

public class MS_Gold_Silver_chocolate {


    public static void main(String[] args) {

        int a[] = {2,2,2,2,2,2};
        int b[] = {7,4,2,5,1,2};
        System.out.println(solution(a,b));
    }

    public  static int solution(int[] A, int[] B) {
        // Implement your solution here
        int n = A.length;
        Map<Integer,Integer> mapA = new HashMap<Integer,Integer>();
        Map<Integer,Integer> mapB = new HashMap<Integer,Integer>();


        for (int i = 0; i < n; i++) {
            mapA.put(A[i] , mapA.getOrDefault(A[i],0)+1 );
        }



        for (int i = 0; i < n; i++) {
            mapB.put(B[i] , mapB.getOrDefault(B[i],0)+1 );
        }

//        System.out.println("mapA " + mapA.size());
//        System.out.println("mapB" + mapB.size());

        int ans =0 ;
        int m = n/2;
        ans = ans + ( mapB.size() > m ? m : mapB.size());
//        System.out.println("map" + ans + "  size " + n);
        ans = ans + (mapA.size() > m ? m : mapA.size());

        return ans;
    }

}
