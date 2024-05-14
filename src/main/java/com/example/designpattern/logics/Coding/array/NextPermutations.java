package com.example.designpattern.logics.Coding.array;

import java.util.*;
import java.util.stream.Collectors;

public class NextPermutations {

    static List<Integer>  nextPermutation(int N, int [] arr){
        //find longest prefix
        List<Integer> ansList = new ArrayList<>();

        int st =-1;
        for (int i = N - 2; i >= 0; i--) {
            if(arr[i] < arr[i+1]){
                st=i;
                break;
            }
        }
        if(st==-1){
            Arrays.sort(arr);
        }else {
            for (int i = N - 1; i > st; i--) {
                if (arr[i] > arr[st]) {
                    int temp = arr[i];
                    arr[i] = arr[st];
                    arr[st] = temp;
                    break;
                }
            }

            st++;
            int n = N - 1;
            while (st < n) {
                int temp = arr[n];
                arr[n] = arr[st];
                arr[st] = temp;
                st++;
                n--;
            }
        }

        for (int i = 0; i < N; i++) {
            ansList.add(arr[i] );
        }
        return ansList;
//        return new ArrayList<>(Arrays.asList(arr));
        //return Arrays.stream(arr).mapToObj(x->x).collect(Collectors.toList());

    }


    public static void main(String[] args) {
        int [] arr1 =  {1, 2, 3, 6, 5, 4};
        System.out.println(nextPermutation(arr1.length, arr1));

        int [] arr2 =  {1, 2, 3, 4, 5, 6};
        System.out.println(nextPermutation(arr2.length, arr2));


    }
}
