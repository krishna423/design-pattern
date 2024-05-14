package com.example.designpattern.logics.Coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {


    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        // Your code goes here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = arr.length;
        Arrays.sort(arr);


        for(int i=0;i<n-3;i++){
            if(i>0 && arr[i] == arr[i-1] ){
                continue;
            }
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && arr[j] == arr[j-1] ){
                    continue;
                }
                int low=j+1;
                int high = n-1;
                int sum_2 = arr[i]+ arr[j];
                // if(arr[i]==30 && arr[j]==97){
                //         cout << arr[j] << " " << arr[low]  << " " << arr[high]  << endl;
                // }

                while(low<high){

                    if( k == (sum_2 + arr[low] + arr[high])){
                        ArrayList<Integer> arrayElements = new ArrayList<>(Arrays.asList(arr[i], arr[j],arr[low],arr[high]));
                        ans.add(arrayElements);
                        low++;
                        high--;
                        boolean isAnyChange;
                        while(low<high){
                            isAnyChange = false;
                            if(arr[low] == arr[low-1]){
                                low++;
                                isAnyChange = true;
                            }
                            if(arr[high] == arr[high+1]){
                                high--;
                                isAnyChange = true;
                            }
                            if(!isAnyChange){
                                break;
                            }
                        }

                    }else if(arr[low]+arr[high]+sum_2>k){
                        high--;
                    }else{
                        low++;
                    }
                    //  cout << endl;
                }
            }
        }
        //cout << endl;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,2,1,1};
        System.out.println(fourSum(arr,3));

        int[] arr1 =  {10,2,3,4,5,7,8};
        System.out.println(fourSum(arr1,23));

    }
}
