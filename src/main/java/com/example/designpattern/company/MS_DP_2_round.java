package com.example.designpattern.company;

import java.util.ArrayList;
import java.util.List;

public class MS_DP_2_round {


        static boolean workBreakUtil(String s, List<String> wordDict, int index, String current,int [] dp){

            if(index <0){
                return false;
            }


            String newString = s.charAt(index) + current ;
            System.out.println(newString);

            boolean isPresent = wordDict.stream().anyMatch(x->x.equals(newString));

            boolean notPicked = false;
            boolean picked =false;


            if(isPresent){

//                if(index>0) {
//                    if (dp[index-1] != -1) return dp[index-1] == 1 ? true : false;
//                }
                picked = workBreakUtil(s,wordDict,index-1,"",dp);
                dp[index] = picked ? 1 :0 ;
                if(index ==0){
                    System.out.println("returned true");
                    return true;
                }
            }
            notPicked = workBreakUtil(s,wordDict,index-1,newString,dp);
            //dp[index] = (picked || notPicked) ? 1 : 0;
            return  (picked || notPicked);
        }



        public static boolean wordBreak(String s, List<String> wordDict) {
            int dp[] = new int[s.length()+1];

            for(int i=0;i<s.length()+1;i++){
                dp[i]=-1;
            }
            workBreakUtil(s,wordDict,s.length()-1,"",dp);

            for(int i=0;i<s.length()+1;i++){
                System.out.print(dp[i]+" ");
            }
            System.out.println("");
            return dp[s.length()-1]==1 ? true : false;

        }





        public static void main(String [] args) {
            // you can write to stdout for debugging purposes, e.g.

            String s = "microsoft";
            List<String>  list = new ArrayList<String>();

            list.add("micro");
            list.add("soft");
            list.add("microsoft");
//         Arrays.asList({"micro","soft"});


            System.out.println("Ans " + wordBreak(s,list));
        }

//        microsoft  ft
//        oft , o+"",
        // ["icro","ft","sft"]
        // "microso" [x]=false  ft fun(0, x-1) , fun()
        // "micros" [y]=false  sft
        //                         sft


        // fun(end)

}
