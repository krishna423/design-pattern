package com.example.designpattern.logics.Coding;

public class StockBuyAndSell {



    public static int maxProfit(int[] prices) {


        int purchasePrice=-1;
        int profit = 0;


        for (int i = 0; i < prices.length-1; i++) {

            if(prices[i] <= prices[i+1]){
                if(purchasePrice == -1) {
                    // System.out.println("i " +  i);
                    purchasePrice = prices[i];
                }
            } else{
                if(purchasePrice != -1) {
                    profit = profit +   prices[i] - purchasePrice;
                    // System.out.println(profit);
                    purchasePrice =-1;
                }
            }
        }

        if(purchasePrice != -1) {
            //System.out.println("last element ");
            profit = profit +   prices[prices.length-1] - purchasePrice;
        }
        return profit;
    }

    public static void main(String[] args) {

        int prices [] ={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));


        int prices2[] ={1,2,3,4,5};
        System.out.println(maxProfit(prices2));
        int prices3[] ={7,6,4,3,1};
        System.out.println(maxProfit(prices3));
    }
}
