package com.example.designpattern.logics.Coding.array;

import java.util.Arrays;

public class MissingAndRepeatingArrayElement {

    public static int[] findMissingRepeatingNumbers(int []a) {
        // Write your code here
        long   n = a.length;
        long  sum = (n*(n+1))/2;
        long  sumSquare = (n*(n+1)*(2*n+1))/6;

        long  arraySum = 0;
        long  arraySumSquare = 0;
        for ( int i = 0; i < n; i++) {

            long element = Long.parseLong(String.valueOf(a[i]));
            arraySum += element;
            arraySumSquare += element*element;
        }

        long aMinusB = sum - arraySum;
        long aSquareMinusBSquare = sumSquare - arraySumSquare;
        long aPlusB = aSquareMinusBSquare/aMinusB;
        long aVar = (aPlusB + aMinusB)/2;
        long bVar = aVar - aMinusB;
        // System.out.println(bVar + "  " + aVar);
        return new int[]{(int)bVar,(int)aVar};
    }

    public static void main(String[] args) {

        int []a = {1,1,3,2,4};
        findMissingRepeatingNumbers(a);
    }

}
