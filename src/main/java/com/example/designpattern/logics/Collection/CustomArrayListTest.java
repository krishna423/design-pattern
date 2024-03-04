package com.example.designpattern.logics.Collection;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayListTest {

    public static void main(String[] args) {
        List<String> stringList = new CustomArrayList<>();
        stringList.add("1212");
        stringList.add("12");
        stringList.add("212");
        stringList.add("1212");
        stringList.add("1212");

        System.out.println(stringList);

    }

}

class CustomArrayList<E> extends ArrayList<E>{

    @Override
    public boolean add(E e) {
        if (super.contains(e)) {
            return true;
        }
        super.add(e);
        return true;
    }

}
