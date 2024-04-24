package com.example.designpattern.logics.Coding.dp;

public class NonAdjacentHouseRobber {


    static int findMaxUtil(int arr[],int n,int [] dp){
        if(n==0){
            return arr[0];
        }
        if(n<0){
            return 0;
        }

        if(dp[n]!=0) return dp[n];
        int include = arr[n] + findMaxUtil(arr, n-2,dp);
        int exlude = 0 + findMaxUtil(arr, n-1,dp);
        return dp[n] = Math.max(include,exlude);
    }





    static int findMaxUtilBottomUp(int arr[],int n,int [] dp){
        if(n>=1){
            dp[0] = arr[0];
        }
        if(n>=2){
            dp[1]=Math.max(arr[0],arr[1]);
        }

        int include =0;
        int exclude = 0;
        for(int i=2;i<n;i++){
            include = arr[i] + dp[i-2];
            exclude = 0 + dp[i-1];
            dp[i] = Math.max(include,exclude);
        }

        // for(int i=0;i<n;i++){
        //     System.out.print(dp[i]+" ");
        // }
        // System.out.println("");
        return dp[n-1];

    }







    static int findMaxUtilSpaceOptimization(int arr[],int n){
        int current=0,prev=0,prev2=0;

        if(n>=1){
            prev = arr[0];
        }
        if(n>=2){
            prev2= arr[0];
            prev=Math.max(arr[0],arr[1]);
        }

        int include =0;
        int exclude = 0;

        for(int i=2;i<n;i++){
            include = arr[i] + prev2;
            exclude = 0 + prev;
            current = Math.max(include,exclude);
            prev2=prev;
            prev= current;
        }

        return prev;

    }

    static int findMaxSum(int arr[], int n) {
        // code here
        int [] dp = new int[n];
        System.out.println("Top down approach" + findMaxUtil(arr,n-1,dp));
        //Top down n-1

        int [] dp1 = new int[n];
        System.out.println("Bottom UP approach" + findMaxUtilBottomUp(arr,n,dp1));

        int ans = findMaxUtilSpaceOptimization(arr, n);
        System.out.println("Space Optimization approach " + ans);
        return ans;

    }

    public static void main(String[] args) {
        int []arr = {5, 5, 10, 100, 10, 5};
        System.out.println(findMaxSum( arr,arr.length));
    }
}
