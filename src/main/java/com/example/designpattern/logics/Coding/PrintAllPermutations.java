package com.example.designpattern.logics.Coding;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {


    static void swap (int[] array, int i, int j ){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    static void permutataions(int n, int array[], int index, List<List<Integer>> ans){

        if(index>n){
            return;
        }
        if(index == n){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(array[i]);
            }
            ans.add(list);
            return;
        }


        for(int i=index;i<n;i++){
            swap(array,index,i);
            permutataions(n,array,i+1,ans);
            swap(array,i,index);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        List<List<Integer>> ans = new ArrayList<>();
        permutataions(array.length, array,0,ans);

        System.out.println(ans);



    }
}
