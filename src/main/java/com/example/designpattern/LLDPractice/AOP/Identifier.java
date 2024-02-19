package com.example.designpattern.LLDPractice.AOP;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Identifier {
    IdentifierType type() ;
    String value() default "";

}
