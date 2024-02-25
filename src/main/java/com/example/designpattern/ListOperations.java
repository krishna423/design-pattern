package com.example.designpattern;

import com.example.designpattern.LLDPractice.HashMap.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListOperations {

    //integer array 0,1,2,1,0
    // 0,1,2 -> map(0,)  0(n) + o(n)
    //
    public static void main(String[] args) {
        // 0, 1,

        List<Integer> list = new ArrayList<>(10);
        List<Integer> list2 = Arrays.asList(1,2,3,5);
        List<String> strings = List.of("foo", "bar", "baz");
        List<Integer> linklist = new LinkedList<>();
        //Search -> For get(index), foreach, Iterator, Stream

        int[] array = new int[10];
        int[] array2 = {1,2,4,5};
        Node[] array3 = {new Node<>(1,2),new Node<>(4,5)};
        int[][] matrix = new int[10][10];
        int[][] matrix2 = {{1,2,3},{3,4,5},{6,7,8,9,10}};
        // For [i], Foreach , stream

        for(int i=0;i<matrix2.length;i++){
            for(int j=0;j<matrix2[i].length;j++){
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println("");
        }


    }
}
