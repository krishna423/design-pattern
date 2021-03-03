package com.example.designpattern.codeSimplified.builderPattern;

public class builderPatternMain {

    public static void main(String[] a){
        Vehicle bike = new Vehicle.VehicleBuilder("350cc",2).build();
        System.out.println(bike.toString());
        Vehicle car = new Vehicle.VehicleBuilder("1000cc",4)
                .setAirBag(4)
                .setSeatBelt(2)
                .build();
        System.out.println(car.toString());
    }
}
