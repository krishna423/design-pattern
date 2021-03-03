package com.example.designpattern.codeSimplified.builderPattern;


public class Vehicle {
    //required parameters
    private String engine;
    private int wheel;
    //optional parameters
    private int seatBelt;
    private int airBag;

    private Vehicle (){
    }

    private Vehicle(VehicleBuilder vehicleBuilder){
        this.engine = vehicleBuilder.engine;
        this.wheel = vehicleBuilder.wheel;
        this.airBag = vehicleBuilder.airBag;
        this.seatBelt = vehicleBuilder.seatBelt;
    }

    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getSeatBelt() {
        return seatBelt;
    }

    public int getAirBag() {
        return airBag;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "engine='" + engine + '\'' +
                ", wheel=" + wheel +
                ", seatBelt=" + seatBelt +
                ", airBag=" + airBag +
                '}';
    }

    public static class VehicleBuilder{
        private String engine;
        private int wheel;
        private int seatBelt;
        private int airBag;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setSeatBelt(int seatBelt) {
            this.seatBelt = seatBelt;
            return this;
        }

        public VehicleBuilder setAirBag(int airBag) {
            this.airBag = airBag;
            return this;
        }
        public Vehicle build(){
            return new Vehicle(this);
        }
    }
}
