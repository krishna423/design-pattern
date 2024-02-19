package com.example.designpattern.LLDPractice.AOP;

import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl {

    @Identifier(type= IdentifierType.ACCESS_TOKEN_GENERATION , value = "xyz")
    public int test1(int a, int b){
        System.out.println(a+b);
        return a+b;
    }
}
