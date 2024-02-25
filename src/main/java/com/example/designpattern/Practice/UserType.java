package com.example.designpattern.Practice;

public enum UserType {
    Normal_citizen(1),
    Senior_citizen(2);

    private int priority;

    UserType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
