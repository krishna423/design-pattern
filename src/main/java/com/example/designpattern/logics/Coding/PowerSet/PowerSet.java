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

    public static void main(String[] args) {
        System.out.println( generatePowerSet("qwe") );
        System.out.println( generatePowerSet("abcd") );
        System.out.println( generatePowerSet("geeks") );

    }





    

}
