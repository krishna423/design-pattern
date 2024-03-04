package com.example.designpattern.logics.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeList {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<String>();


        list.add("12");
        list.add("23");
        list.add("78");
        list.add("48");
        System.out.println("Original list " + list);

        Iterator<String> iterator1 = list.iterator();

        while (iterator1.hasNext()) {
            String next =  iterator1.next();
            System.out.print(next + " ");
            if(next.equals("23")){
                list.remove("23");
            }
        }
        System.out.println("");
        System.out.println("Updated List " +list);
        System.out.println("============");

        Iterator<String> iterator2 = list.iterator();

        while (iterator2.hasNext()) {
            String next =  iterator2.next();
            if(next.equals("12")){
                iterator2.remove();
            }
        }

        System.out.println(list);


    }
}
