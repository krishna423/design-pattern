package com.example.designpattern.LLDPractice.AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {


    @Before("@annotation(Identifier)")
    public void incomingRequestBeforeInterceptor(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Identifier identifier = methodSignature.getMethod().getAnnotation(Identifier.class);

        System.out.println("Identifier Type " + identifier.type());
        System.out.println("Identifier Type " + identifier.value());
    }



    @Pointcut("execution(* com.example.designpattern.LLDPractice.AOP.TestServiceImpl.*(..))" )
    public void methodInterceptor(){}

    @AfterReturning(value = "methodInterceptor()", returning = "abc")
    public void methodInterceptor(JoinPoint joinPoint, Integer abc){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Identifier identifier = methodSignature.getMethod().getAnnotation(Identifier.class);

        System.out.println("PointCut : Identifier Type  " + identifier);
        System.out.println("PointCut : Return value " + abc );
    }



}
