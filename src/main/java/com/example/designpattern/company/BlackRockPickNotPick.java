package com.example.designpattern.company;

import java.util.ArrayList;
import java.util.List;

public class BlackRockPickNotPick {




    static void findSubArray(Integer [] arr, int index, int sum , List<Integer> ansList , List<List<Integer>> finalAnsList ){

        if(sum==0){
            finalAnsList.add(new ArrayList<>(ansList));
           return;
        }

        if( sum < 0 || index <0){
            return;
        }


        findSubArray(arr, index-1, sum ,ansList,finalAnsList);

        ansList.add(arr[index]);
        findSubArray(arr, index-1, sum-arr[index],ansList,finalAnsList);
        ansList.remove(ansList.size()-1);

    }

    public static void main(String[] args) {
        Integer [] arr = {11,2,3,4,1,9};
        int sum =12;
        List<Integer> ansList = new ArrayList<>();
        List<List<Integer>> finalAnsList = new ArrayList<>();

        findSubArray(arr, arr.length -1,sum,ansList,finalAnsList);

        System.out.println(finalAnsList);



        // fun
        //{11,2,3,4,1,9} , 12
        //{2,3,4,1,9},12     {2,3,4,1,9} ,
        // {3,4,1,9},12   {3,4,1,9},10





    }
}
