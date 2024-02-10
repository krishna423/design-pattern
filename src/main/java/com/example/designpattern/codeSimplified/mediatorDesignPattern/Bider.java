package com.example.designpattern.codeSimplified.mediatorDesignPattern;

public class Bider extends Colleague{

    private int id;
    private String name;
    private AuctionMediator auctionMediator;

    public Bider(int id, String name, AuctionMediator auctionMediator) {
        super(id, name);
        this.auctionMediator =auctionMediator;
        auctionMediator.addBider(this);
    }

    @Override
    public void addBid(int bidAmount) {
        auctionMediator.addBid(this, bidAmount);
    }

    @Override
    public void receiveNotification(int bitAmount) {
        System.out.println(" Received notification for bit  : " + bitAmount + " At "  + super.getName());
    }
}
