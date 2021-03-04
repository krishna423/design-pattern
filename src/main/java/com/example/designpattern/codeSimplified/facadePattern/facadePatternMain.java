package com.example.designpattern.codeSimplified.facadePattern;

public class facadePatternMain {

    public static  void main(String []  a){

        ShapeFacadeHelper shapeFacadeHelper = new ShapeFacadeHelper();

        shapeFacadeHelper.drawCircle();
        shapeFacadeHelper.drawRectangle();
        shapeFacadeHelper.drawSquare();
    }
}
