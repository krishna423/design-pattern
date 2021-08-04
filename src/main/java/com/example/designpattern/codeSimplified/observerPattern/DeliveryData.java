package com.example.designpattern.codeSimplified.observerPattern;

import java.util.List;

public class DeliveryData implements Subject{
    private String location;
    private List<Observer> observerList;

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer ob : observerList){
            ob.update();
        }
    }

    public void localUpdate(){
        this.notifyObserver();
    }
}
