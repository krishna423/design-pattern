package com.example.designpattern.codeSimplified.mediatorDesignPattern;

public interface AuctionMediator {

    void addBider(Colleague colleague);
    void notifyUser(Colleague colleague);
    void addBid(Colleague colleague, int bidAmount);

}
