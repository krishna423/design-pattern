package com.example.designpattern.codeSimplified.singletonExample;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class SingletonMain {

    public static void main(String [] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        /**
         * lazy initialization
         */
        SingletonLazy singletonLazy = SingletonLazy.getSingletonLazy();
        System.out.println(singletonLazy);
        SingletonLazy singletonLazy1 = SingletonLazy.getSingletonLazy();
        System.out.println(singletonLazy1);

        SingletonEager singletonEager = SingletonEager.getSingletonEager();
        System.out.println(singletonEager);
        SingletonEager singletonEager1 = SingletonEager.getSingletonEager();
        System.out.println(singletonEager1);

        SingletonSynchronizedMethod singletonSynchronizedMethod = SingletonSynchronizedMethod.getInstance();
        System.out.println(singletonSynchronizedMethod);
        SingletonSynchronizedMethod singletonSynchronizedMethod1 = SingletonSynchronizedMethod.getInstance();
        System.out.println(singletonSynchronizedMethod1);

        SingletonSynchronizedBlock singletonSynchronizedBlock = SingletonSynchronizedBlock.getInstance();
        System.out.println(singletonSynchronizedBlock);
        SingletonSynchronizedBlock singletonSynchronizedBlock1 = SingletonSynchronizedBlock.getInstance();
        System.out.println(singletonSynchronizedBlock1);

        SingletonSynchronizedBlockWithVolatile singletonSynchronizedBlockWithVolatile1 = SingletonSynchronizedBlockWithVolatile.getInstance();
        System.out.println(singletonSynchronizedBlockWithVolatile1);
        SingletonSynchronizedBlockWithVolatile singletonSynchronizedBlockWithVolatile2 = SingletonSynchronizedBlockWithVolatile.getInstance();
        System.out.println(singletonSynchronizedBlockWithVolatile2);


        System.out.println("Lazy Singleton using inner class ");
        SingletonLazyUsingInnerClass singletonLazyUsingInnerClass1 = SingletonLazyUsingInnerClass.getSingletonEager();
        System.out.println(singletonLazyUsingInnerClass1);
        SingletonLazyUsingInnerClass singletonLazyUsingInnerClass2 = SingletonLazyUsingInnerClass.getSingletonEager();
        System.out.println(singletonLazyUsingInnerClass2);


        System.out.println("Breaking singleton ");
        SingletonLazyUsingInnerClassBreakingPattern singletonLazyUsingInnerClassBreakingPattern1 = SingletonLazyUsingInnerClassBreakingPattern.getSingletonLazy();
        System.out.println(singletonLazyUsingInnerClassBreakingPattern1);

        // 1.Using clone method
        //SingletonLazyUsingInnerClassBreakingPattern singletonLazyUsingInnerClassBreakingPattern2 = singletonLazyUsingInnerClassBreakingPattern1.clone();
        //System.out.println(singletonLazyUsingInnerClassBreakingPattern2);

        // 2.Using reflection API
//        SingletonLazyUsingInnerClassBreakingPattern reflectionInstance = null;
//        Constructor[] constructors = SingletonLazyUsingInnerClassBreakingPattern.class.getDeclaredConstructors();
//        for(Constructor constructor : constructors){
//            constructor.setAccessible(true);
//            reflectionInstance = (SingletonLazyUsingInnerClassBreakingPattern) constructor.newInstance();
//        }
//        System.out.println(reflectionInstance);


        // 3. Using Serialized and deserialized
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.txt"));
            out.writeObject(singletonLazyUsingInnerClassBreakingPattern1);
            out.close();

            ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.txt"));
            SingletonLazyUsingInnerClassBreakingPattern serializedInstance = (SingletonLazyUsingInnerClassBreakingPattern) in.readObject();
            System.out.println(serializedInstance);
        }catch (Exception e){

        }

    }
}
