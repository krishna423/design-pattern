package com.example.designpattern.logics.String;

public class ShallowCopyDeepCopy {


    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Hyderabad");

        EmployeeShallowCopy shE1 = new EmployeeShallowCopy(101, "Krishna", address);
        EmployeeShallowCopy shE2 = shE1.clone();

        shE2.address.setCity("ABC");

        System.out.println("Address of 1st Employee using shadow copy: " + shE1.address.city);




        Address addressTemp = new Address("Hyderabad");
        EmployeeDeepCopy deepE1 = new EmployeeDeepCopy(101, "Krishna", addressTemp);
        EmployeeDeepCopy deepE2 = deepE1.clone();

        deepE2.address.setCity("ABC");

        System.out.println("Address of 1st Employee using deep copy: " + deepE1.address.city);



    }





    static class Address {
        String city;

        Address(String city) {
            this.city = city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    static class EmployeeShallowCopy implements Cloneable{
        int id;
        String name;
        Address address;

        EmployeeShallowCopy(int id, String name, Address address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }


        //Shallow copy
        @Override
        protected EmployeeShallowCopy clone() throws CloneNotSupportedException {
            return (EmployeeShallowCopy) super.clone();
        }


    }

    static class EmployeeDeepCopy implements Cloneable{
        int id;
        String name;
        Address address;

        EmployeeDeepCopy(int id, String name, Address address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }


        @Override
        protected EmployeeDeepCopy clone() throws CloneNotSupportedException {
            EmployeeDeepCopy copy = (EmployeeDeepCopy) super.clone();
            copy.address = new Address(this.address.city);
            return copy;
        }
    }
}
