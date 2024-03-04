package com.example.designpattern.logics.Collection;

import com.example.designpattern.Practice.Employee;

import java.util.*;

public class CollectionTest {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();  // Run time polymorphism

        final List<String> finalList = new ArrayList<>();
        finalList.add("dad");
        finalList.add("45rfs");
        System.out.println(finalList);


        Set<TestObject> set = new HashSet<TestObject>();
        //If we pass a custom object then equals() and hashcode() metho is must,
        //Otherwise set allow duplicate elements
        set.add(new TestObject(1,"a","aa",11));
        set.add(new TestObject(1,"a","bb",22));
        set.add(new TestObject(1,"a","cc",33));


        //Equals method not override leads to allow duplicates
        System.out.println(set);

    }
}

class TestObject{
    private Long id;
    private String firstName;
    private String lastName;
    private Integer salary;

    public TestObject(long id, String firstName, String lastName, Integer salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestObject that = (TestObject) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName);
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}