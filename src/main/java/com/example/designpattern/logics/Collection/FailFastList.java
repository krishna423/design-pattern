package com.example.designpattern.logics.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("asa");
        list.add("2323");
        list.add("12");
        list.add("23");
        list.add("78");
        System.out.println(list);

        Iterator<String> iterator1 = list.iterator();

        //ModCount will change and expectedModCount will also be changed , so no exception while using iterator remove functions
        while (iterator1.hasNext()) {
            String next =  iterator1.next();
            if (next.equals("12")){
                iterator1.remove();
            }
        }

        System.out.println(list);


        Iterator<String> iterator2 = list.iterator();

        //ModCount will change , so modeCount is not equals to expectedModCount
        while (iterator2.hasNext()) {
            String next =  iterator2.next();
            list.remove("23");
        }

        System.out.println(list);

    }
}
