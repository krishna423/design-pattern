package com.example.designpattern.logics.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastList {
//https://anmolsehgal.medium.com/fail-fast-and-fail-safe-iterations-in-java-collections-11ce8ca4180e#:~:text=Fail%2Dsafe%20iterators%20means%20they,modified%20while%20iterating%20over%20it.&text=As%20arrayLists%20are%20fail%2Dfast%20above%20code%20will%20throw%20an%20exception.

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
