package com.example.designpattern.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    public static void main1(String[] args) {

        TreeMap<String,Integer> mm = new TreeMap<String,Integer>();
        mm.put("ssds",121);
        mm.put("324",1211);
        mm.put("s54ras",1211);
        mm.put(null,223);

        Map<String,Integer> mmm = new HashMap<>(mm);
        System.out.println(mm.size());





    }


    public int solution(int[] A, int[] B) {
        // Implement your solution here
        Map<Integer,Integer> mmA = new HashMap<Integer,Integer>();
        Map<Integer,Integer> mmB = new HashMap<Integer,Integer>();

        for( int i=0;i<A.length;i++){
            if(!mmA.containsKey(A[i])) {
                mmA.put(A[i], A[i]);
            }
        }
        for( int i=0;i<B.length;i++){
            if(!mmB.containsKey(B[i])) {
                mmB.put(B[i], B[i]);
            }
        }

        return mmA.size() > A.length/2 ? A.length/2 : mmA.size() +
                mmB.size() > B.length/2 ? B.length/2 : mmB.size() ;
    }

    boolean checkNotPalindrome(String str, int i, int j)
    {
        while (true){
            if(i>j){
                break;
            }

            if(str.charAt(i) != str.charAt(j)){
                return true;
            }

            i++;j--;
        }
        return false;
    }


    int utility_fun_for_del(String str, int i, int j, int temp[][])
    {
        if (i > j)
            return 0;

        if(temp[i][j]==-1){
            if (checkNotPalindrome(str,i,j))
            {
                temp[i][j]=0;

            }else{
                temp[i][j] = Math.min(utility_fun_for_del(str, i+1 , j, temp ) , utility_fun_for_del(str, i , j - 1, temp))+1;
            }
        }
        return temp[i][j];

    }


    public int solution(String S) {
        // Implement your solution here
        int temp[][] = new int[100001][100001];

        for(int i=0;i<10001;i++){
            for(int j=0;j<10001;j++){
                temp[i][j]=-1;
            }
        }


        return utility_fun_for_del(S, 0, S.length() - 1,temp);
    }

    // Function to calculate the minimum
// Element required to delete for
// Making string palindrome
    public static void main(String[] args) {

        String str;

        str= "abba";
        Test t = new Test();


        System.out.println(t.solution(str));
    }
}
