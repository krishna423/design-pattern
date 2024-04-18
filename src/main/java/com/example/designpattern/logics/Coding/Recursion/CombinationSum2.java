package com.example.designpattern.logics.Coding.Recursion;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum2 {

    static void generateCombination(List<Integer> inputArray, int index,  int target,
                                    List<List<Integer>> ansList, List<Integer> tempAnsArray)
    {

        if(target==0){
            System.out.println(tempAnsArray);
            ansList.add(new ArrayList<>(tempAnsArray));
            return;
        }
        if(target<0 || index == inputArray.size()){
            return;
        }

        for (int i = index; i < inputArray.size(); i++) {
            if(i>index && Objects.equals(inputArray.get(i), inputArray.get(i - 1))){
                continue;
            }

            int temp = inputArray.get(i);
            //System.out.println("tt  " + temp);
            tempAnsArray.add(temp);
            generateCombination(inputArray, i + 1, target - temp, ansList, tempAnsArray);
            tempAnsArray.remove(tempAnsArray.size() - 1);
        }

    }


    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        List<Integer> inputList = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            inputList.add(a[i]);
        }

        // add your code here
        Collections.sort(inputList);

        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> tempAnsArray = new ArrayList<>();

        generateCombination(inputList,0,s,ansList,tempAnsArray);
        return ansList;
    }


    public static void main(String[] args) {

//        int arr[] =  {10,1,2,7,6,1,5};
//        int target = 8;

//        Integer arr[] = {6,5,7,1,8,2,9,9,7,7,9};
//        int target = 6;
//

        int arr[] = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> ansList = combinationSum2(arr,target);
        System.out.println(ansList+ "  Size : "+ ansList.size());
    }
}
