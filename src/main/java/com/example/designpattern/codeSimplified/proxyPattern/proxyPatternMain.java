package com.example.designpattern.codeSimplified.proxyPattern;

public class proxyPatternMain {

    public static  void  main(String [] a){
    DBInteractionProxy dbInteractionProxy = new DBInteractionProxy("ADMIN","ADMIN");
    dbInteractionProxy.execute("DELETE");

    DBInteractionProxy dbInteractionProxy1 = new DBInteractionProxy("NON_ADMIN","NON_ADMIN");
    dbInteractionProxy1.execute("DELETE");


    }
}
