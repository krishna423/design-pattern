package com.example.designpattern.codeSimplified.prototypePattern;

public class Address implements Cloneable{
    private int houseNo;
    private String streetName;
    private String cityName;
    private String stateName;
    private String CountryName;
    private int pinCode;

    public Address(int houseNo, String streetName, String cityName, String stateName, String countryName, int pinCode) {
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateName = stateName;
        CountryName = countryName;
        this.pinCode = pinCode;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo=" + houseNo +
                ", streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", CountryName='" + CountryName + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
