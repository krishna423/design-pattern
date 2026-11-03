package com.example.designpattern.LLDPractice.HashMap.InternalWOrking;

import java.util.*;

public class TestTreeSetCustomImpl {

    public static void main(String[] args) {

        // 1. TreeSet using Employee Comparator (ID + Name)
        TreeSet<Employee> employees = new TreeSet<>(new EmployeeComparator());

        employees.add(new Employee(103, "Rahul", 80000));
        employees.add(new Employee(101, "Krishna", 90000));
        employees.add(new Employee(102, "Amit", 75000));
        employees.add(new Employee(103, "RandomName", 90000));

        // Exact duplicate: rejected
        employees.add(new Employee(101, "Krishna", 90000));


        System.out.println("Sorting by ID and Name:");
        employees.forEach(System.out::println);

        System.out.println("Size: " + employees.size());
    }


    static class Employee {

        private int id;
        private String name;
        private double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id +
                    ", name='" + name +
                    "', salary=" + salary + "}";
        }
    }

    static class EmployeeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee e1, Employee e2) {

            int result = Integer.compare(e1.id, e2.id);

            if (result == 0) {
                result = e1.name.compareTo(e2.name);
            }
            return result;
        }
    }
}
