package com.example.designpattern.codeSimplified.flyweightPattern;

import java.util.HashMap;

public class PlayerFlywieghtFactory {
    private static HashMap <String,Player> playerHashMap = new  HashMap<String,Player>();

    public static Player getPlayer(String type){

        Player p = null;

        if(playerHashMap.containsKey(type)){
            return playerHashMap.get(type);
        }

        switch (type){

            case "Terrorist":
                System.out.println("Terrorist Created");
                p = new Terrorist();
                break;
            case "CounterTerrorist":
                System.out.println("Counter Terrorist Created");
                p = new CounterTerrorist();
                break;
            default :
                System.out.println("Unreachable code!");

        }
        playerHashMap.put(type,p);
        return playerHashMap.get(type);
    }
}
