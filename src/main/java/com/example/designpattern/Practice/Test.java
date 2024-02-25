//package com.example.designpattern;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Test {
//
//
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        int startIndex =0 ;
//        List<List<Integer>> ans = new ArrayList<>(new ArrayList<>());
//        findPermutations(list, startIndex, ans);
//    }
//
//    static void function(List<Integer> list, int index,List<List<Integer>> ans ){
//
//
//        if(index>= list.size()){
//
//            return;
//        }
//
//        for(int i=index ;i<list.size();i++){
//            int temp1 = list.get(i);
//            int temp2 = list.get(index);
//            list.set(index,temp1);
//            list.set(i,temp2);
//            function(list, i++, ans);
//            list.set(index,temp2);
//            list.set(i,temp1);
//            list.
//            //ans
//        }
//
//    }
//
//    static void findPermutations(List<Integer> list, int index,List<List<Integer>> ans ){
//
//
//        for(int i=0;i<list.size();i++){
//            int temp1 = list.get(0);
//            int temp2 = list.get(index);
//            list.set(index,temp1);
//            list.set(0,temp2);
//            List<Integer> list1 = new ArrayList<>();
//            list1.add(temp1);
//            ans.set(i, list1);
//            function(list, i++, ans);
//
//        }
//
//    }
//
//
//}
