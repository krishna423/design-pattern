package com.example.designpattern.logics.ExceptionHandling;

import java.io.FileReader;

public class TestResourcesWithTryBlock {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\kmaurya\\Downloads\\IntellijProjects\\design-pattern\\src\\main\\resources\\static\\index.html";


        System.out.println("------------------");
        testCustomLLogic(filePath);
        System.out.println("------------------");
        testInbuiltLogic(filePath);
        System.out.println("------------------");



    }

    public static void testInbuiltLogic(String filePath) {

        try (FileReader io = new FileReader(filePath)){
            System.out.println("Testing inbuilt resource accessing function");

        } catch (Exception e) {
            throw new FileRelatedException(e.getMessage(), 500);
        }
    }

    public static void testCustomLLogic(String filePath) {

        try (MyResource io = new MyResource(filePath)){
            System.out.println("Testing custom resource accessing function");
        } catch (Exception e) {
            throw new FileRelatedException(e.getMessage(), 500);
        }
    }
}
