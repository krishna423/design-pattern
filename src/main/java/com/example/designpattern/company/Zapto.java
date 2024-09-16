package com.example.designpattern.company;

import java.util.*;

public class Zapto {


    public int solution(long [] arr) {

        Map<Long,Long> map = new HashMap<Long,Long>();

        Set<Integer> set = new TreeSet<>();
        set.add(1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.get(1);
        for (int i = 0; i < set.size(); i++) {

        }

        long hashValue = 1000000000;
        int n = arr.length;
        for(int i=0;i<n;i++){
            map.put(arr[i]+hashValue,1L);
            
        }

        int countL=0;
        int countR =0;
        int count =0;
        int globalCount =0;
        for(int i=0; i<n;i++){
            Long elemetHashValue = arr[i] + hashValue ;
            if(map.containsKey(elemetHashValue)){
                map.remove(elemetHashValue);
                Long left = elemetHashValue-1;
                Long right = elemetHashValue+1;

                countL=0;
                countR =0;
                count=0;
                while(true){
                    if(!map.containsKey(left)){
                        countL = count;
                        break;
                    }else{
                        map.put(left,0L);
                        count++;
                    }
                    left--;
                }
                count=0;
                while(true){
                    if(!map.containsKey(right)){
                        countR= count;
                        break;
                    }else{
                        map.put(right,0L);
                        count++;
                    }
                    right++;
                }
                globalCount = Math.max (globalCount, countL+countR+1);
            }

        }
        return globalCount;
        // write the solution here..
    }

    public static void main(String[] args) {
        long [] arr = { -1,0,1,2, 3, 4, 5, 20, 21, 25 };

        int ans = new Zapto().solution(arr);
        System.out.print(ans);
    }

}
