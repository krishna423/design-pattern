package com.example.designpattern.logics.Coding.PowerSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PrintAllPermutations {


    static void swap (Integer[] array, int i, int j ){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    static void permutataions(int n, Integer array[], int index, List<List<Integer>> ans){

        if(index == n-1){
            //List temp is only a wrapper : whenever array element is shifted , List element will be also shifted
            //as temp list uses same array in background
//            List<Integer> temp = Arrays.asList(array);

            List<Integer> list = new ArrayList<>(Arrays.asList(array));
//            List<Integer> list = new ArrayList<>();
//            for(int i=0;i<n;i++){
//                list.add(array[i]);
//            }
            ans.add(list);
            return;
        }


        for(int i=index;i<n;i++){
            swap(array,index,i);
            permutataions(n,array,index+1,ans);
            swap(array,i,index);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4};
        List<List<Integer>> ans = new ArrayList<>();
        permutataions(array.length, array,0,ans);

        System.out.println(ans.size());
        System.out.println(ans);



    }
}
