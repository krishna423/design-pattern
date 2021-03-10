package com.example.designpattern.codeSimplified.flyweightPattern;

public class FlyweightPattrenMain {


    public static void main(String [] args ){

        Player ct1 = PlayerFlywieghtFactory.getPlayer("CounterTerrorist");
        Player ct2 = PlayerFlywieghtFactory.getPlayer("CounterTerrorist");
        Player ct3 = PlayerFlywieghtFactory.getPlayer("CounterTerrorist");

        ct1.assignWeapon("AK-47");
        ct2.assignWeapon("piston");
        ct3.assignWeapon("snipper");

        /**
         *  Having concurrency issue , need more knowledge
          */
        ct1.mission();
        ct2.mission();
        ct3.mission();

        System.out.println(ct1);
        System.out.println(ct2);
        System.out.println(ct3);
    }


}
