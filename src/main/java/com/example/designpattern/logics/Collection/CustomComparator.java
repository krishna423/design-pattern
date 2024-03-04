package com.example.designpattern.logics.Collection;

import java.util.ArrayList;
import java.util.Comparator;

public class CustomComparator {


    public static void main(String[] args) {

        ArrayList<TestObject2> list = new ArrayList<>();
        list.add( new TestObject2(4l, "Crian", "Tux", 12131) );
        list.add( new TestObject2(4l, "Crian", "Sux",12131) );
        list.add( new TestObject2(2l, "Lokesh", "Gupta",12131) );
        list.add( new TestObject2(1l, "Alex", "Gussin",12131) );
        list.add( new TestObject2(4l, "Brian", "Sux",12131) );
        list.add( new TestObject2(15l, "Neon", "Piper",12131) );
        list.add( new TestObject2(3l, "David", "Beckham",12131) );
        list.add( new TestObject2(17l, "Alex", "Beckham",12131) );
        list.add( new TestObject2(6l, "Brian", "Suxena",12131) );



//        Comparator<TestObject2> TestObject2COmparator = Comparator.comparing( TestObject2::getId)
//                .thenComparing(TestObject2::getFirstName)
//                .thenComparing(TestObject2::getLastName);
//        list.sort(TestObject2COmparator);
        list.sort(new CompositeComparator());
        System.out.println(list);

    }
}

class CompositeComparator implements Comparator<TestObject2> {
    @Override
    public int compare(TestObject2 e1, TestObject2 e2) {
        if(e1.getId().compareTo(e2.getId()) != 0){
            return e1.getId().compareTo(e2.getId());
        } else{

            if(e1.getFirstName().compareTo(e2.getFirstName()) != 0){
                return e1.getFirstName().compareTo(e2.getFirstName());
            } else {

                if(e1.getLastName().compareTo(e2.getLastName()) != 0){
                    return e1.getLastName().compareTo(e2.getLastName());
                } else {
                    return e1.getFirstName().compareTo(e2.getFirstName());
                }
            }
        }
    }
}

class TestObject2 {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer salary;

    public TestObject2(long id, String firstName, String lastName, Integer salary) {
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
        return "TestObject{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
