package com.example.designpattern.logics.Collection;

import com.example.designpattern.codeSimplified.DecoratorPattern.SmallPizza;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomMapMultipleThreads implements Runnable {

    static Map<String,Integer> map = new ConcurrentHashMap<>();
//    static Map<String,Integer> map = new HashMap<>();

    @Override
    public void run() {
        try {
            map.put("weweq", 131);
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }
    }



    public static void main(String[] args) throws InterruptedException {

        map.put("asda",22);
        map.put("fsef",21);
        map.put("5gdd",28);
        map.put("yyfd",65);

       Thread thread = new Thread(new CustomMapMultipleThreads());
       thread.start();

        Iterator<String> iterator =  map.keySet().iterator();
        while (iterator.hasNext()) {
            String next =  iterator.next();
            System.out.println(next);
            Thread.sleep(231);
        }


    }


}

