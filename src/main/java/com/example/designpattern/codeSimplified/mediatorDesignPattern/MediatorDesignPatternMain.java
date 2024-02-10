package com.example.designpattern.codeSimplified.mediatorDesignPattern;

public class MediatorDesignPatternMain {

    public static void main(String [] a)  {

    AuctionMediator auctionMediator = new AuctionManager(100);
    Colleague colleague1 = new Bider(1,"aaa",auctionMediator);
    Colleague colleague2 = new Bider(2,"aab",auctionMediator);
    Colleague colleague3 = new Bider(3,"aac",auctionMediator);
    Colleague colleague4 = new Bider(4,"aad",auctionMediator);
    Colleague colleague5 = new Bider(5,"aae",auctionMediator);

    colleague1.addBid(200);
    colleague5.addBid(300);
    colleague2.addBid(310);
    colleague1.addBid(450);

    }
}
