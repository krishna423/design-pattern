package com.example.designpattern.logics.String;

public class StringObject {

    //String literal : Immutable
    //String Object created by new : Immutable class
    //StringBuilder : Mutable class-> Once build called -> return new String(stringBuilder) then created immutable string
    //StringBuffer : Mutable class

    public static void main(String[] args) {



        String st1 = new String("Test-XYZ");
        //How many objects created ?? ->  2 Objects
        //1st Object -> Literal -> SCP (String constant pool area)
        //2nd Object -> new -> heap area;
        //SCP is independent area inside the heap

        //First check whether literal present in SCP or not
        //Literal is already present so only get reference
        String st2 = "Test-XYZ";

        //new -> create new Object
        StringBuilder stringBuilder = new StringBuilder();
        String st3 = stringBuilder.append(st2).toString();

        //If object same then hashcode would be same
        System.out.println("HashCode : " + st1.hashCode() + "  " + st2.hashCode() + " " + st3.hashCode());


        //st2 and st1.intern(), st3.intern() point to same string constant which is present in SCP
        //st1, st3 points their own objects
        System.out.println(Integer.toHexString(System.identityHashCode(st1)));
        System.out.println(Integer.toHexString(System.identityHashCode(st2)));

        System.out.println(Integer.toHexString(System.identityHashCode(st3)));
        System.out.println(Integer.toHexString(System.identityHashCode(st3.intern())));


        System.out.println("\n===========================");
        System.out.println(st1 == st2);
        System.out.println(st1 == st3);
        System.out.println(st2 == st3);
        System.out.println(st2 == st1.intern());
        System.out.println(st2 == st3.intern());

        System.out.println("");
        String st4 = new String("Test-XYZ");

        System.out.println(st1 == st4);
        System.out.println(st1.intern() == st4.intern());


        System.out.println("\n=======equals=================");
        System.out.println(st1.equals(st2));
        System.out.println(st1.equals(st3));
        System.out.println(st2.equals(st3));
        System.out.println(st2.equals(st1.intern()));
        System.out.println(st2.equals(st3.intern()));
        System.out.println(st1.equals(st4));
        System.out.println(st1.intern().equals(st4.intern()));


        System.out.println("----------------------------------------");
        String st5 = "Test-" + "XYZ";
        String temp = "XYZ";
        String st6 = "Test-" + temp;


        System.out.println(st2 == st5);
        System.out.println(st2 == st6);




        String s2 = "Hello ";
        String s3 = "Java";

        String s1 = s2 + s3;
        System.out.println(s1); // Hello Java
        System.out.println(s2); // Hello
        System.out.println(s3); //  Java
//        System.out.println(st1.intern().hashCode() == st3.hashCode());
//        System.out.println(st1.hashCode() == st2.hashCode());
//        System.out.println(st1.intern().hashCode() == st2.hashCode());
    }
}
