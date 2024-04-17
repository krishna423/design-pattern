package com.example.designpattern.logics.Coding.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {

    static void generateCombination(ArrayList<Integer> inputArray, int index,  int target,
                                    ArrayList<ArrayList<Integer>> ansList, ArrayList<Integer> tempAnsArray)
    {
        // add your code here

        if(target==0){
            ansList.add(new ArrayList<>(tempAnsArray));
            return;
        }
        if(target<0 || index == inputArray.size()){
            return;
        }

        int temp = inputArray.get(index);
        tempAnsArray.add(temp);
        generateCombination(inputArray,index,target-temp, ansList,tempAnsArray);
        tempAnsArray.remove(tempAnsArray.size()-1);

        generateCombination(inputArray,index+1,target, ansList,tempAnsArray);

    }


    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        ArrayList<Integer> tempAnsArray = new ArrayList<>();

        generateCombination(A,0,B,ansList,tempAnsArray);
        return ansList;
    }


    public static void main(String[] args) {

        Integer arr[] = {7,2,6,5};
        int target = 16;
        System.out.println(combinationSum(new ArrayList<Integer>(Arrays.asList(arr)),target));
    }
}
