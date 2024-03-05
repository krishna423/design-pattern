package com.example.designpattern.logics.jdk13;

import com.example.designpattern.Practice.Employee;

public class SwitchStatementEnchancements {

    static String checkBox (int i){

        return switch (i){
            case 1,2,3 ->"asdas";
            case 5,6,7,8 -> "567890";
            default -> "Not defined";
        };
    }
    public static void main(String[] args) {
        System.out.println(checkBox(2));
        System.out.println(checkBox(7));
        System.out.println(checkBox(22));
    }

    //Jdk7 - integer
    //JDK8 - STring, Enum
    //JDK12 - introduced yield statement and arrow statement , remove break statement,
    //JDK17 - pattern matching , guarded pattern


//    static String checkBox (Object obj) {
//
//        return switch (obj) {
//            case Integer i -> "It is an integer";
//            case String s -> "It is a string";
//            case Employee employee && employee.getFirstName().equals("IT") ->"IT Employee";
//                default -> "It is none of the known data types";
//        };
//    }


}
