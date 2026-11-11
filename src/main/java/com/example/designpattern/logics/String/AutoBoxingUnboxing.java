package com.example.designpattern.logics.String;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxingUnboxing {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        //Autoboxing int -->Integer
        list.add(1);
        list.add(2);

        //Unboxing Integer-->int
        System.out.println(list.get(0));

    }

}
