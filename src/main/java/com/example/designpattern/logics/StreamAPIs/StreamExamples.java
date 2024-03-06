package com.example.designpattern.logics.StreamAPIs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

//How to find employees name starting with alphabet A using stream API
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(new Employee(15, "krishna", "IT", 123),
                new Employee(121, "abc", "sds", 1234), new Employee(2111, "abc", "sds", 123)));

        List<Employee> filteredEmployeesList = employeeList.stream()
                .filter(x -> x.getFirstName().startsWith("a"))
                .collect(Collectors.toList());
        System.out.println("\nFilteredEmployee : " + filteredEmployeesList);


//Merge two Employee ArrayList and sort by age in using java8 stream API

        List<Employee> employeeList2 = new ArrayList<>(Arrays.asList(new Employee(11, "krishna", "IT", 123)));
        List<Employee> sortedEmployeeList = Stream.concat(employeeList.stream(), employeeList2.stream())
                .sorted((x, y) -> x.getFirstName().compareTo(y.getFirstName()))
                .collect(Collectors.toList());
        System.out.println("\nMerge two list " + sortedEmployeeList);


//Find even numbers from ArrayList and find the sum of all numbers using Java 8 stream API
        // Using mapToInt(ToIntFunction mapper) ==>  Stream<T> ---> IntStream
        // and displaying the corresponding IntStream

        List<String> list = Arrays.asList("3", "6", "8", "14", "15");
        int sum = list.stream()
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 3 == 0)
                .sum();
        long count = list.stream()
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 3 == 0)
                .count();
        System.out.println("\n" + "sum : " + sum + " count " + count);


//Sort employee byname and salary using java 8 stream API
        List<Employee> sortedEmployees = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("\nsortedEmployees" + sortedEmployees);


//Sort Employee based on gender and age is above 10 using Java 8 stream API
        List<Employee> filterEmployees = employeeList.stream()
                .filter(x->x.getId()>10)
                .sorted((x,y)->x.getDept().compareTo(y.getDept()))
                .collect(Collectors.toList());
        System.out.println("\nFiltered less than 10" + filterEmployees);











//Get sum from Object List
        TestObject[] testObjectArray = {new TestObject(1,"32"),new TestObject(3,"32")};
        List<TestObject> testObjects = new ArrayList<>(Arrays.asList(testObjectArray));
        //IntStream is used for primitive int operations
        int summed =  testObjects.stream()
                .mapToInt(x->x.getA())
                .sum();
        System.out.println(summed);
    }


}

class TestObject{
    private int a;
    private String z;

    public TestObject(int a, String z) {
        this.a = a;
        this.z = z;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }
}