package com.example.designpattern;

import com.example.designpattern.LLDPractice.AOP.TestAOPDriver;
import com.example.designpattern.LLDPractice.AOP.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DesignPatternApplication {

	@Autowired
	private TestServiceImpl testService;
	public static void main(String[] args) throws NoSuchMethodException {
		ApplicationContext context = SpringApplication.run(DesignPatternApplication.class, args);
		TestAOPDriver testAOPDriver = context.getBean(TestAOPDriver.class);
		testAOPDriver.fun();

	}

}
