package com.example.designpattern.codeSimplified.prototypePattern;

public class PrototypePatternMain {

    public static void main(String [] a) throws CloneNotSupportedException {

        Address ad = new Address(1,"first street","bareilly","U.P.","India",243001);
        StudentDetails st = new StudentDetails("krishna",123456,"IT",ad);
        System.out.println("init : "+st.toString());

        StudentDetails stCloned = (StudentDetails) st.clone();
        Address add = stCloned.getAddress();
        add.setCityName("DELHI");
        add.setHouseNo(1213);
        add.setStreetName("9,1/4");
        add.setPinCode(110092);
        System.out.println("original : "+st.toString());
        System.out.println("updated : " +stCloned.toString());

    }
}
