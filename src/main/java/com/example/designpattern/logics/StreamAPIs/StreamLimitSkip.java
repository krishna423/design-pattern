package com.example.designpattern.logics.StreamAPIs;

import java.util.Arrays;

public class StreamLimitSkip {

    public static void main(String[] args) {
        int [] arrayList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arrayList)
                .filter(i -> i % 2 == 0)
                .skip(2)
                .forEach(i -> System.out.print(i + " "));

        System.out.println("");

        Arrays.stream(arrayList)
                .filter(i -> i % 2 == 0)
                .limit(3)
                .forEach(i -> System.out.print(i + " "));

        System.out.println("");

        int sum = Arrays.stream(arrayList)
                .filter(i -> i % 2 == 0)
                .limit(3)
                .sum();
        System.out.println(sum);

        }

}
