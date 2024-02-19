package com.example.designpattern.LLDPractice.AOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestAOPDriver {

    @Autowired
    private TestServiceImpl testService;

    public void fun() throws NoSuchMethodException {
        testService.test1(3,4);
        //Identifier = testService.getClass().getMethod("test1", int.class, int.class).getAnnotation(Identifier.class);
//        System.out.println( "Print custom annotation value " + identifier.type());

    }
}
