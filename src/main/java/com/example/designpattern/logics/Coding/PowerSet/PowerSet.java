package com.example.designpattern.logics.Coding.PowerSet;


import java.util.*;

public class PowerSet {

    static List<String> generatePowerSet(String a){
        List<String> ansList = new ArrayList<>();
        int n = a.length();
        String tempString = "";
        int setElements = (int) Math.pow(2,n);

        for (int i = 0; i < setElements ; i++) {
            tempString = "";
            for (int j = 0; j < n; j++) {
                if( (i & (1<<j)) !=0 ){
                    tempString = tempString + a.charAt(j);
                }
            }
            ansList.add(tempString);
        }
        return ansList;
    }


    static void generateString(String a, int index,String subString,List<String> ansList){
        int n = a.length();
        if(n==index){
            ansList.add(subString);
            return;
        }

        generateString(a,index+1,subString,ansList);
        generateString(a,index+1,subString+a.charAt(index),ansList);
    }

    static List<String> generatePowerSetUsingRecursion(String a) {
        List<String> ansList = new ArrayList<>();
        int n = a.length();
        generateString(a,0,"",ansList);
        return ansList;
    }





    public static void main(String[] args) {
        System.out.println( generatePowerSet("qwe") );
        System.out.println( generatePowerSetUsingRecursion("qwe") );
        System.out.println( generatePowerSet("abcd") );
        System.out.println( generatePowerSetUsingRecursion("abcd") );
        System.out.println( generatePowerSet("geeks") );
        System.out.println( generatePowerSetUsingRecursion("geeks") );

    }





    

}
