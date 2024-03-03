package com.example.designpattern.logics.String;

public class StringImmutable {

    public static void main(String[] args) {

        String st1 = "Krishna";

        System.out.println(st1.intern());
        System.out.println(Integer.toHexString(System.identityHashCode(st1.intern())));

        System.out.println("\n=====After concatenate ============= ");
        //st1 = st1+"Maurya";
        // Concatination will not be worked as string is immutable
        st1.concat("Maurya");


        System.out.println(st1.intern());
        System.out.println(Integer.toHexString(System.identityHashCode(st1.intern())));

        //Why String is immutable
        //1. Saves a lot of space at runtime by using SCP
        //2. Security threat
        //3. Multithreading easy
        //4. Hashing Faster : hash is created on string literal creation time




    }
}
