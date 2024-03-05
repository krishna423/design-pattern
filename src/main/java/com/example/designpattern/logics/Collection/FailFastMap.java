package com.example.designpattern.logics.Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastMap {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("asas",1);
        map.put("ds",2);

        Iterator iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Object next =  iterator.next();
            map.put("sdadada",3343);

        }
    }
}
