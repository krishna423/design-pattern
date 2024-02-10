package com.example.designpattern.codeSimplified.mediatorDesignPattern;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class AuctionManager implements AuctionMediator{
    List<Colleague> colleagueList = new ArrayList<>();
    int price ;

    public AuctionManager(int price) {
        this.price = price;
    }

    @Override
    public void addBider(Colleague colleague) {
        colleagueList.add(colleague);
    }

    @Override
    public void notifyUser(Colleague colleague) {
        System.out.println("Sending notification to : " + colleague.getName());
        colleague.receiveNotification(price);


    }

    @Override
    public void addBid(Colleague colleague, int bidAmount) {
        price = bidAmount;
        for( Colleague colleague1 : colleagueList){
            this.notifyUser(colleague1);
        }
        System.out.println("Sent bidAmount notification======================================================================================");

    }
}
