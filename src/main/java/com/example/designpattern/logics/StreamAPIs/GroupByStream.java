package com.example.designpattern.logics.StreamAPIs;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByStream {

    public static void main(String[] args) {


        String input = "KrishnaKMaurya";

        Map<String, Long> map =  Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Frequency Map : " + map);


        // Group by find max

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add( new Employee(4l, "Crian", "DEV", 12131) );
        employeeList.add( new Employee(4l, "Crian", "DEV",899999) );
        employeeList.add( new Employee(2l, "Lokesh", "QA",12131) );
        employeeList.add( new Employee(1l, "Alex", "QA",1213) );
        employeeList.add( new Employee(4l, "Brian", "DevOps",1231) );
        employeeList.add( new Employee(15l, "Neon", "QA",2131) );
        employeeList.add( new Employee(3l, "David", "DevOps",121) );
        employeeList.add( new Employee(17l, "Alex", "DEV",1777) );
        employeeList.add( new Employee(6l, "Brian", "DevOps",31343) );

        Comparator<Employee> comparator = (x,y) -> x.getSalary().compareTo(y.getSalary());

        Map<String, Optional<Employee>> map2 =  employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDept, Collectors.maxBy(comparator))
        );

        System.out.println(" Group max element : " + map2);



    }
}
