package com.example.designpattern.logics.StreamAPIs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamAPIs {

    public static void main(String[] args) {


        List<Integer> integerList = Arrays.asList(1,4,2,8,89,3,7,5,12,54);

        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer>3;
            }
        };

        Predicate<Integer> predicateLambda = (x)-> x>3;

        System.out.println("Using plan java code");
        integerList.stream().filter(predicate1).sorted().forEach(x->System.out.print(x + " "));

        System.out.println("\nUsing lambda as a predicate");
        integerList.stream().filter(predicateLambda).sorted().forEach(x->System.out.print(x + " "));

        System.out.println("\nUsing lambda ");

        integerList.stream().filter(x->x>3).sorted().forEach(x->System.out.print(x + " "));

        System.out.println("\nUsing Method reference ");
        integerList.stream().filter(x->x>3).sorted().forEach(System.out::print);
    }
}
