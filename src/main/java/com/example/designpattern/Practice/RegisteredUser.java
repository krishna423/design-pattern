package com.example.designpattern.Practice;

import java.util.Date;

public class RegisteredUser {
    public RegisteredUser(String name, UserType userType, Date registrationTime, VisaType visaTypel) {
        this.name = name;
        this.userType = userType;
        this.registrationTime = registrationTime;
        this.visaTypel = visaTypel;
    }

    private String name;
    private UserType userType;
    private Date registrationTime;
    private VisaType visaTypel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public VisaType getVisaTypel() {
        return visaTypel;
    }

    public void setVisaTypel(VisaType visaTypel) {
        this.visaTypel = visaTypel;
    }
}
