package com.example.designpattern.interview;

public class Test2 {


    public static void main(String[] args) {

        int k =5;


        for (int i = 0; i < k; i++) {

            for (int j = 0; j < i ; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <k-i ; j++) {

                System.out.print( "* ");
            }
            System.out.println("");
        }



    }

}
