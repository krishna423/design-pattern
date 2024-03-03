package com.example.designpattern.logics.String;

public class StringBuilderVsStringBuffer {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Test");
        String st1 = stringBuilder.append(123).append(567).toString();
        //St1 is not literal , it is created by new keyword, stringBuilder.toSting() -> return new String(CharacterSequence)
        //Whatever we are appending : will be happened in stringBuilder Object only,
        // actual object will be created once toString in called

        //1.Test : literal Object
        //2.String builder object : accept append (mutable)
        //3.Test123567 : literal Object (toString will create a String literal and add in SCP)


        //Thread safe
        StringBuffer stringBuffer = new StringBuffer("Test");
        String st2 = stringBuffer.append(123).append(567).toString();
        //1.Test : get literal Object
        //2.String buffer object : accept append (mutable)
        //3.Test123567 : literal Object (toString will try to save new literal but it is already present in SCP)

        String st3 = "Test123567";
        // Get Object from SCP

        System.out.println( st1 + "  " +Integer.toHexString(System.identityHashCode(st1)));
        System.out.println( st2 + "  " +Integer.toHexString(System.identityHashCode(st2)));
        System.out.println( st3 + "  " +Integer.toHexString(System.identityHashCode(st3)));

        System.out.println("\n====Intern=====");
        System.out.println(st1.intern());
        System.out.println(st2.intern());
        System.out.println(st3.intern());

        System.out.println("\n====Intern refernce=====");
        System.out.println(Integer.toHexString(System.identityHashCode(st1.intern())));
        System.out.println(Integer.toHexString(System.identityHashCode(st2.intern())));
        System.out.println(Integer.toHexString(System.identityHashCode(st3.intern())));

    }
}
