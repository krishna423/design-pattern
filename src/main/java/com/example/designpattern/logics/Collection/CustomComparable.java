package com.example.designpattern.logics.Collection;

import java.util.ArrayList;
import java.util.Collections;

public class CustomComparable {

    public static void main(String[] args) {
        ArrayList<TestObject3> list = new ArrayList<>();
        list.add( new TestObject3(4l, "Crian", "Tux", 12131) );
        list.add( new TestObject3(4l, "Crian", "Sux",12131) );
        list.add( new TestObject3(2l, "Lokesh", "Gupta",12131) );
        list.add( new TestObject3(1l, "Alex", "Gussin",12131) );
        list.add( new TestObject3(4l, "Brian", "Sux",12131) );
        list.add( new TestObject3(15l, "Neon", "Piper",12131) );
        list.add( new TestObject3(3l, "David", "Beckham",12131) );
        list.add( new TestObject3(17l, "Alex", "Beckham",12131) );
        list.add( new TestObject3(6l, "Brian", "Suxena",12131) );

        Collections.sort(list);
        System.out.println(list);
    }
}

class TestObject3 implements Comparable<TestObject3>{
    private Long id;
    private String firstName;
    private String lastName;
    private Integer salary;

    public TestObject3(long id, String firstName, String lastName, Integer salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "TestObject3{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(TestObject3 e2) {
        if(this.getId().compareTo(e2.getId()) != 0){
            return this.getId().compareTo(e2.getId());
        } else{

            if(this.getFirstName().compareTo(e2.getFirstName()) != 0){
                return this.getFirstName().compareTo(e2.getFirstName());
            } else {

                if(this.getLastName().compareTo(e2.getLastName()) != 0){
                    return this.getLastName().compareTo(e2.getLastName());
                } else {
                    return this.getFirstName().compareTo(e2.getFirstName());
                }
            }
        }
    }
}
