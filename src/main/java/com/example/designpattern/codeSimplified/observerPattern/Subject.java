package com.example.designpattern.codeSimplified.observerPattern;

public interface Subject {
    void register(Observer observer);
    void deregister(Observer observer);
    void notifyObserver();
}
