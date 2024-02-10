package com.example.designpattern.codeSimplified.flyweightPattern;

public class FlyweightPatternMain {


    public static void main(String [] args ){

        Player ct1 = PlayerFlywieghtFactory.getPlayer(PlayerType.TERRORIST);
        Player ct2 = PlayerFlywieghtFactory.getPlayer(PlayerType.TERRORIST);
        Player ct3 = PlayerFlywieghtFactory.getPlayer(PlayerType.TERRORIST);
        Player ct4 = PlayerFlywieghtFactory.getPlayer(PlayerType.COUNTER_TERRORIST);
        Player ct5 = PlayerFlywieghtFactory.getPlayer(PlayerType.COUNTER_TERRORIST);
        Player ct6 = PlayerFlywieghtFactory.getPlayer(PlayerType.COUNTER_TERRORIST);

        WorkingPlayerProperty workingPlayerProperty1 = new WorkingPlayerProperty(1,WeaponType.AK47,1,21);
        WorkingPlayerProperty workingPlayerProperty2 = new WorkingPlayerProperty(2,WeaponType.PISTON,10,2);
        WorkingPlayerProperty workingPlayerProperty3 = new WorkingPlayerProperty(3,WeaponType.AK47,11,5);
        WorkingPlayerProperty workingPlayerProperty4 = new WorkingPlayerProperty(4,WeaponType.SNIPER,16,9);
        WorkingPlayerProperty workingPlayerProperty5 = new WorkingPlayerProperty(5,WeaponType.SNIPER,4,12);
        WorkingPlayerProperty workingPlayerProperty6 = new WorkingPlayerProperty(6,WeaponType.PISTON,7,1);

        ct1.runningPlayer(workingPlayerProperty1);
        ct2.runningPlayer(workingPlayerProperty2);
        ct3.runningPlayer(workingPlayerProperty3);
        ct4.runningPlayer(workingPlayerProperty4);
        ct5.runningPlayer(workingPlayerProperty5);
        ct6.runningPlayer(workingPlayerProperty6);

    }


}
