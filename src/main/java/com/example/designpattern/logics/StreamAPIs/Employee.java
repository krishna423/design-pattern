package com.example.designpattern.logics.StreamAPIs;

public class Employee {
    private Long id;
    private String firstName;
    private String dept;
    private Integer salary;

    public Employee(long id, String firstName, String dept, Integer salary) {
        this.id = id;
        this.firstName = firstName;
        this.dept = dept;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                "}\n";
    }
}
