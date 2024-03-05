package com.example.designpattern.logics.Collection;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeMap {

    public static void main(String[] args) {
        Map<String,Integer> map = new ConcurrentHashMap<>();

        map.put("asas",1);
        map.put("ds",2);

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Object next =  iterator.next();
            map.put("sdadada",3343);
        }
        System.out.println(map);

    }
}
