package com.example.designpattern.codeSimplified.facadePattern;




public class ShapeFacadeHelper {
    private Circle circle;
    private Square square;
    private Rectangle rectangle;

    public ShapeFacadeHelper() {
        this.circle = new Circle();
        this.square = new Square();
        this.rectangle = new Rectangle();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}
