package com.example.designpattern.logics.Coding.array;

public class InversionCount {

    static long []t_arr = new long [500001];

    static long merge( long [] arr, int low, int mid , int high, int N){

        int j = low;
        int f_low = low;
        int f_high = mid;
        int s_low = mid+1;
        int s_high = high;
        long inversion=0;

        while(f_low<=f_high && s_low<=s_high){
            if(arr[f_low]>arr[s_low]){
                inversion+=mid - f_low+1;
                t_arr[j++]=arr[s_low++];
            }else{
                t_arr[j++]=arr[f_low++];
            }
        }

        while(f_low<=f_high){
            t_arr[j++]=arr[f_low++];
        }
        while(s_low<=s_high){
            t_arr[j++]=arr[s_low++];
        }

        for(int i=low ; i<=high; i++){
            arr[i]=t_arr[i];
        }

        // for(long i=low ; i<=high; i++){
        //   cout << arr[i] << " ";
        // }
        // cout<<"end" <<endl;
        // cout << "inversion count " << inversion << endl;
        return inversion;
    }

     static long mergeSort( long [] arr, int low, int high, int N){
        if(low >= high){
            return 0;
        }
        // long mid = low+ (high-low)/2;
        int mid = (low+high)/2;
        long inversion = 0;
        inversion+=mergeSort(arr, low, mid, N);
        inversion+=mergeSort(arr, mid+1, high, N);
        inversion+=merge(arr, low, mid, high, N);
        return inversion;
    }

    static long inversionCount( long [] arr,  long N)
    {
        int n = Long.valueOf(N).intValue();
        long inversion = mergeSort(arr,0,n-1,n);
        // for(long i=0;i<N;i++){
        //     cout << arr[i] << " " ;
        // }
        // cout << endl;
        return inversion;
        // Your Code Here
    }



    public static void main(String[] args) {
        long [] arr = {5,3,2,1,4};
        System.out.println(inversionCount(arr, arr.length));
    }
}
