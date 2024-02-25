package com.example.designpattern.logics.StreamAPIs;

import org.apache.logging.log4j.util.SortedArrayStringMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapVsFlatMapStream {

    public static void main(String[] args) {


        //int matrix[][] = new int[5][10];
        Integer matrix [][] = {{1,2,3,4,5,7}, {66,22,11,6,3,2}, {2,6},{1,3,9,0,0,232}};
        List<List<Integer>> matrixList = Arrays.stream(matrix).map(x-> Arrays.stream(x).toList()).toList();


        List<List<Integer>> ansMap = matrixList.stream().map(x->x).collect(Collectors.toList());
        System.out.println("Using normal map for 2D array : "+ ansMap);

        List<Integer> ansFlatMap = matrixList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("Using flat map for 2D Array : " + ansFlatMap);



    }
}
