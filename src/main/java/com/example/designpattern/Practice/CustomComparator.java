package com.example.designpattern.Practice;

import java.util.ArrayList;
import java.util.Comparator;

public class CustomComparator {


    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        list.add( new Employee(4l, "Crian", "Tux", 12131) );
        list.add( new Employee(4l, "Crian", "Sux",12131) );
        list.add( new Employee(2l, "Lokesh", "Gupta",12131) );
        list.add( new Employee(1l, "Alex", "Gussin",12131) );
        list.add( new Employee(4l, "Brian", "Sux",12131) );
        list.add( new Employee(15l, "Neon", "Piper",12131) );
        list.add( new Employee(3l, "David", "Beckham",12131) );
        list.add( new Employee(17l, "Alex", "Beckham",12131) );
        list.add( new Employee(6l, "Brian", "Suxena",12131) );



        Comparator<Employee> employeeCOmparator = Comparator.comparing( Employee::getId)
                .thenComparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName);
        list.sort(employeeCOmparator);
        //list.sort(new CompositeComparator());
        System.out.println(list);







    }

}
