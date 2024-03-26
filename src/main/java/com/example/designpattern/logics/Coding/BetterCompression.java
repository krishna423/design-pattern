package com.example.designpattern.logics.Coding;

import java.util.HashMap;
import java.util.Map;

public class BetterCompression {

    public static String betterCompression(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int n= s.length();
        int i=0;
        int freq ;
        char temp;
        while(i<n){
            char character = s.charAt(i);
            i++;
            String tempArray = "";
            while(i<n){

                temp = s.charAt(i);

                if( '0' <= temp && temp <= '9'){
                    tempArray = tempArray + temp;
                }else{
                    break;
                }
                i++;
            }
            System.out.println(character + " gg " + tempArray);
            freq = Integer.valueOf(tempArray);
            if(map.containsKey(character)){
                map.put(character, map.get(character)+freq);
            }else{
                map.put(character, freq);
            }
        }

        String ans = "";
        for (Map.Entry<Character, Integer> characterCharacterEntry : map.entrySet()) {
            ans = ans + characterCharacterEntry.getKey() ;
            System.out.println(characterCharacterEntry.getKey());
            ans = ans + characterCharacterEntry.getValue();
        }

        return ans;

    }


    public static void main(String[] args) {
        System.out.println(betterCompression("a12b5c2b5"));
    }
}
