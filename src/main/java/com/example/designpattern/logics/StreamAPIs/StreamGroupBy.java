package com.example.designpattern.logics.StreamAPIs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamGroupBy {

    public static void main(String[] args) {


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(15, "krishna", "IT", 123));
        employeeList.add(new Employee(121, "abc", "sds", 1234));
        employeeList.add(new Employee(2111, "abc", "sds", 123));
        employeeList.add(new Employee(11, "krishna", "IT", 123));


//GIven string frequency map

        String input = "KrishnaKMaurya";
        input.chars().forEach(x-> System.out.print(x + " "));
        System.out.println("");

        Map<Character, Long> map = input.chars().mapToObj(x-> (char) x)
                .collect( Collectors.groupingBy(Function.identity(),Collectors.counting()) );
        System.out.println("\nFrequency Map : " + map);



//Arrays -> group by grouped list element
        Map<String, List<String>> listMap =  Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.toList()));
        System.out.println("\nFrequency list : " + listMap);


//Frequency -> grouped max element
        Map<String, Optional<Employee>> employeeGroup = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,Collectors.maxBy( (x,y)->{ return x.getSalary().compareTo(y.getSalary());} )
                ));
        System.out.println("\nFrequency max : " + employeeGroup);


//Frequency ->  sum of all elements
        Map<String, Integer> employeeGroup2 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.summingInt(Employee::getSalary)
                ));
        System.out.println("\nFrequency Sum : " + employeeGroup2);
    }
}
