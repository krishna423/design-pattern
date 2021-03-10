package com.example.designpattern.codeSimplified.DecoratorPattern;


public class DecoratorPatternMain {

    public static  void main(String[] a){

        SmallPizza smallPizza = new SmallPizza();
        System.out.println(smallPizza);

        SmallPizza smallPizza1 = new SmallPizza();
        ExtraCronDecorator extraCronDecorator = new ExtraCronDecorator(smallPizza1);
        CheezBurstDecorator cheezBurstDecorator = new CheezBurstDecorator(extraCronDecorator.assemble());
        System.out.println("cheez burst and extra cron : " + cheezBurstDecorator.assemble());

        LargePizza largePizza = new LargePizza();
        System.out.println("Simple large :" + largePizza);

        LargePizza largePizza1 = new LargePizza();
        CheezBurstDecorator cheezBurstDecorator1 = new CheezBurstDecorator(largePizza1);
        System.out.println("cheez burst large : " + cheezBurstDecorator1.assemble());

        MediumPizza mediumPizza = new MediumPizza();
        ExtraCronDecorator extraCronDecorator1 = new ExtraCronDecorator(mediumPizza);
        System.out.println("extra cron medium : " + extraCronDecorator1.assemble());



    }
}
