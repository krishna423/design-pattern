package com.example.designpattern.codeSimplified.bridgePattern;

public class BridgePatternMain {
    public  static void main(String [] a){

        Remote newRemote = new NewRemote();
        Remote oldRemote = new OldRemote();

        System.out.println("------SONY TV old remote-------------");
        SonyTV sonyTV = new SonyTV(oldRemote);
        sonyTV.onTV();
        sonyTV.offTV();

        System.out.println("------SONY TV new remote-------------");
        SonyTV sonyTV1 = new SonyTV(newRemote);
        sonyTV1.onTV();
        sonyTV1.offTV();

        System.out.println("------Philips TV old remote-------------");
        PhilipsTV philipsTV = new PhilipsTV(oldRemote);
        philipsTV.onTV();
        philipsTV.offTV();

        System.out.println("------Philips TV new remote-------------");
        PhilipsTV philipsTV1 = new PhilipsTV(newRemote);
        philipsTV1.onTV();
        philipsTV1.offTV();






    }
}
