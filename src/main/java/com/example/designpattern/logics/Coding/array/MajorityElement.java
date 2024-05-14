package com.example.designpattern.logics.Coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement {

    public static List< Integer > majorityElement(int []v) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        int cnt1 =0;
        int cnt2 =0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int n = v.length;

        if(n<3){
            for (int i = 0; i < v.length; i++) {
                ans.add(v[i]);
            }
            return ans;
        }

        for (int i = 0; i <n  ; i++) {
            if(cnt1 == 0 && el2 != v[i]){
                el1 = v[i];
                cnt1 = 1;
            } else if(cnt2 == 0){
                el2 = v[i];
                cnt2 =1;
            } else if (v[i] == el1) {
                cnt1++;
            } else if (v[i] == el2) {
                cnt2++;
            }else {
                cnt1--;
                cnt2--;
            }
        }

        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < v.length; i++) {
            if(v[i]==el1){
                c1++;
            }
            if(v[i]==el2){
                c2++;
            }
        }

        if(c1>n/3){
            ans.add(el1);
        }
        if(c2>n/3){
            ans.add(el2);
        }
        return ans;

        //return new ArrayList<Integer>(Arrays.asList(el1, el2));
    }


    public static void main(String[] args) {
        int a[] = {2, 2, 1, 3, 1, 2, 3, 1, 1};
        System.out.println(majorityElement(a));
    }

}
