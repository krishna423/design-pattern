package com.example.designpattern.logics.Coding.prefixSum;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {



    static void findLongestSubstring(String str){

        Map<Character,Integer> map = new HashMap<>(100);

        int ansStartPosition = 0;
        int ansEndPosition = 0;

        int maxAns=-1;
        int tempStart=0;
        for( int i=0; i<str.length();i++){

            if(map.containsKey(str.charAt(i))){
                tempStart = Math.max(map.get(str.charAt(i))+1, tempStart);
            }
            //System.out.println( str.charAt(i) + " " + i  + " " + " " + tempStart);
            if(i-tempStart+1 > maxAns){
                maxAns = i-tempStart+1;
                ansStartPosition = tempStart;
                ansEndPosition = i+1;
            }
            map.put(str.charAt(i),i);
        }


        String ans = str.substring(ansStartPosition,ansEndPosition);
        System.out.print(str + "   " +maxAns + "   ");
        System.out.println(ansStartPosition+ " " + ansEndPosition);
        System.out.println(ans);


    }



    public static void main(String[] args) {
        findLongestSubstring("geeksforgeeks");

        findLongestSubstring("gezzeksforgeeks");
        findLongestSubstring("abc");
        findLongestSubstring("abcadc");
        findLongestSubstring("ababce");
        findLongestSubstring("berzcabc");
        findLongestSubstring("geeksforgeeks");







    }
}
