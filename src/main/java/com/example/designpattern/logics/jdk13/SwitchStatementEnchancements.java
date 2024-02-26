package com.example.designpattern.logics.jdk13;

public class SwitchStatementEnchancements {

    static String checkBox (int i){

        return switch (i){
            case 1,2,3 :
               yield "asdas";
            case 5,6,7,8:
               yield "567890";
            default:
                yield "Not defined";
        };
    }
    public static void main(String[] args) {
        System.out.println(checkBox(2));
        System.out.println(checkBox(7));
        System.out.println(checkBox(22));
    }
}
