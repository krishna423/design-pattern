package com.example.designpattern.codeSimplified.adapterPattern;

public class BirdAdapter implements ToyDuck{

    /**Add adapter on bird class
    * now we can call bird class function via adapter
     **/
     private Bird bird;

    public BirdAdapter(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void squeak() {
        bird.makeSound();
    }
}
