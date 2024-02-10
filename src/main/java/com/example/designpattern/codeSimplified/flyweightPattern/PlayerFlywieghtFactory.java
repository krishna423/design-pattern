package com.example.designpattern.codeSimplified.flyweightPattern;

import java.util.HashMap;

public class PlayerFlywieghtFactory {
    private static HashMap <PlayerType,Player> playerHashMap = new  HashMap<PlayerType,Player>();

    public static Player getPlayer(PlayerType playerType){

        Player p = null;

        if(playerHashMap.containsKey(playerType)){
            return playerHashMap.get(playerType);
        }

        switch (playerType){

            case TERRORIST:
                System.out.println("Terrorist Created");
                p = new Terrorist();
                break;
            case COUNTER_TERRORIST:
                System.out.println("Counter Terrorist Created");
                p = new CounterTerrorist();
                break;
            default :
                System.out.println("Unknown player type");


        }
        playerHashMap.put(playerType,p);
        return playerHashMap.get(playerType);
    }
}
