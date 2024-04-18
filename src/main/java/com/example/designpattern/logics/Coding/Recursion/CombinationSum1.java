package com.example.designpattern.logics.Coding.Recursion;

import javax.persistence.SecondaryTable;
import java.security.cert.CertPath;
import java.util.*;

public class CombinationSum1 {

    static void generateCombination(ArrayList<Integer> inputArray, int index,  int target,
                                    ArrayList<ArrayList<Integer>> ansList, ArrayList<Integer> tempAnsArray)
    {

        if(target==0){
           // System.out.println(tempAnsArray);
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
        Collections.sort(A);
        Set<Integer> set = new HashSet<>(A);
        ArrayList<Integer> unqiueElementList = new ArrayList<>(set);
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        ArrayList<Integer> tempAnsArray = new ArrayList<>();

        generateCombination(unqiueElementList,0,B,ansList,tempAnsArray);
        return ansList;
    }


    public static void main(String[] args) {

//        Integer arr[] = {7,2,6,5};
//        int target = 16;

//        Integer arr[] = {6,5,7,1,8,2,9,9,7,7,9};
//        int target = 6;
//

        Integer arr[] = {8,1,8,6,8};
        int target = 12;

        ArrayList<ArrayList<Integer>> ansList = combinationSum(new ArrayList<Integer>(Arrays.asList(arr)),target);
        System.out.println(ansList+ "  Size : "+ ansList.size());
    }
}
