package com.example.designpattern.logics.Coding;

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctCharacterSubstring {


    static int longestSubstrDistinctChars(String S){
        // code here
        Map<Character,Integer> map = new HashMap<>();

        int mx = 0;
        int start = 0;
        int begin = 0;
        int end = S.length()-1;
        for (int i = 0; i < S.length(); i++) {
            Character key =  S.charAt(i);
            if(map.containsKey(key) && map.get(key)>=start ){
//                if(mx < i-start){
//                    begin = start;
//                    end = i;
//                }
                mx = Math.max(mx, i-start);

                System.out.println(key +  " " + i +   " " + start  + " " + map.get(key) +  " "  + mx);
                start = map.get(key)+1;
            }
            map.put(key,i);
        }
        System.out.println(mx);
//        if(mx < S.length()-start){
//            begin = start;
//            end = S.length();
//        }
        mx = Math.max(mx, S.length()-1-start );

        //System.out.println(S.substring(begin,end));

        return mx;
    }


    public static void main(String[] args) {
        String string = "aewergrththy";
        //String string = "geeksforgeeks";
        System.out.println(longestSubstrDistinctChars(string));
    }
}
