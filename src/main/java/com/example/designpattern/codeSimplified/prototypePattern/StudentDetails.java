package com.example.designpattern.codeSimplified.prototypePattern;

public class StudentDetails implements Cloneable{
    private String name;
    private int rollNo;
    private String branch;
    private Address address;

    public StudentDetails(String name, int rollNo, String branch, Address address) {
        this.name = name;
        this.rollNo = rollNo;
        this.branch = branch;
        this.address = address;
    }

    public Object clone() throws CloneNotSupportedException {
        StudentDetails st = (StudentDetails) super.clone();
        st.address = (Address) address.clone();
        return st;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getBranch() {
        return branch;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", branch='" + branch + '\'' +
                ", address=" + address +
                '}';
    }
}
