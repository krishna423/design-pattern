package com.example.designpattern.logics.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ImmutableClass {


    public static void main(String[] args) {

        Address address = new Address("Bareilly", "243001");
        List<String> phoneNoList = new ArrayList(Arrays.asList("9634969965", "7232677822"));
        Date dob = new Date();

        Employee employee = new Employee("krishna", dob, address, phoneNoList);

        //Using getter
        employee.getDateOfBirth().setTime(new Date().getTime() - 2000000000);
        employee.getAddress().setCity("Blr");
        employee.getPhoneNoList().add("232131");

        //If you already have reference of mutable class
        phoneNoList.add("1111111");
        address.setCity("HYD");

        System.out.println(employee);


    }

}

//Immutable class
final class Employee {
    private final String name;
    private final Date dateOfBirth;
    private final Address address;
    private final List<String> phoneNoList;

    public Employee(String name, Date dateOfBirth, Address address, List<String> phoneNoList) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = new Address(address.getCity(), address.getPinCode());
        this.phoneNoList = new ArrayList<>(phoneNoList);
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return (Date) dateOfBirth.clone();
    }

    public Address getAddress() {
        return new Address(address.getCity(), address.getPinCode());
    }

    public List<String> getPhoneNoList() {
        return new ArrayList<>(phoneNoList);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                ", phoneNo=" + phoneNoList +
                '}';
    }
}


//Mutable class
class Address {
    private String city;
    private String pinCode;

    public Address(String city, String pinCode) {
        this.city = city;
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}