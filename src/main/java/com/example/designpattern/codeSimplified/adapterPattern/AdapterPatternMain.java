package com.example.designpattern.codeSimplified.adapterPattern;

public class AdapterPatternMain {
    public  static void main(String [] a){
        Bird bird = new Sparrow();
        System.out.println("****** Real bird ********");
        bird.makeSound();
        bird.fly();

        System.out.println("****** toy bird ********");
        ToyDuck toyDuck = new PlasticDuck();
        toyDuck.squeak();

        //Adapter on bird
        System.out.println("****** Toy bird behaves like real world ********");
        BirdAdapter birdAdapter = new BirdAdapter(bird);
        birdAdapter.squeak();

    }
}
