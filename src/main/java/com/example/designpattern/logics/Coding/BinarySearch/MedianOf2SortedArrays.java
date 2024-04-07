package com.example.designpattern.logics.Coding.BinarySearch;

public class MedianOf2SortedArrays {

    static double medianOfArrays(int a[], int b[])
    {

        if(a.length > b.length){
            return medianOfArrays(b,a);
        }

        int cut1 = 0;
        int cut2 = 0;
        int left1 ,left2, right1, right2 ;
        int n = a.length;
        int m = b.length;

        int low =0;
        int high = n-1;

        while (low<=high){
            //System.out.println("low-high " + low + " " + high);

            cut1 = (low + high)/2;
            cut2 = (n+m +1)/2-cut1;

            //System.out.println("cuts index " + cut1 + " " + cut2);
            left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1-1];
            right1 = cut1 == n ? Integer.MAX_VALUE : a[cut1];

            left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2-1];
            right2 = cut2 == m ? Integer.MAX_VALUE : b[cut2];
            //System.out.println( "left-right value "+left1 + " " +left2 + " " + right1 + " " +right2);


            if(left1 <= right2 && left2 <= right1){
                //get median
                if( (n+m) %2 ==0){

                    return (Math.max(left1,left2) + Math.min(right1,right2))/2.0;
                }else{
                    return Math.max(left1,left2);
                }
            }
            if(left1 > right2){
                high = cut1-1;
            }else{
                low= cut1+1;
            }

        }

        // Your Code Here

        return 0.0;
    }


    public static void main(String[] args) {
        int [] a;
        int [] b;

        a = new int[]{2,4,6};
        b =  new int[]{1,3,5};
        System.out.println( "Ans " + medianOfArrays(a,b) + "\n");

        a = new int[]{2,4,6};
        b =  new int[]{1,3};
        System.out.println( "Ans " + medianOfArrays(a,b)+ "\n");

        a = new int[]{2,4,6};
        b =  new int[]{1};
        System.out.println( "Ans " + medianOfArrays(a,b)+ "\n");

        a = new int[]{5};
        b =  new int[]{1,4,6};
        System.out.println( "Ans " + medianOfArrays(a,b)+ "\n");

        a = new int[]{5};
        b =  new int[]{1,4};
        System.out.println( "Ans " + medianOfArrays(a,b)+ "\n");

        a = new int[]{5};
        b =  new int[]{1};
        System.out.println( "Ans " + medianOfArrays(a,b)+ "\n");

        a = new int[]{1,3};
        b =  new int[]{2};
        System.out.println( "Ans " + medianOfArrays(a,b)+ "\n");



        a = new int[]{6402,9802,9988,12763,15913,20758,25833,28371,31516,33612,33923,34462,41400,43353,48078,51215,51305,56422,59024,60205,63633,66669,68112,70150,79160,80391,80882,82067,82754,86007,87117,87316,88213,91391,92116,99660};
        b =  new int[]{5823,7172,8508,22397,27820,30621,37554,44104,46379,48434,52324,67532,88508,89210};
        System.out.println("Array size " + a.length + " " + b.length);
        System.out.println( "Ans " + medianOfArrays(a,b) + "\n");

    }
}
