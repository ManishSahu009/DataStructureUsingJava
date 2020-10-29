package org.ms.ds.array;

/*
122. Best Time to Buy and Sell Stock II - Valley Peak approach
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
https://www.techiedelight.com/maximum-profit-earned-buying-and-selling-shares/

 */

public class StockBuySellAnyNoOfTimesToMaximizeProfit {

    public static  int maxProfitWithDaynumber(int[] prices) {
        int maxProfit=0;
        int valley=prices[0];
        int peak=prices[0];
        int buyDay=0;
        int saleDay=0;
        for(int i=0 ; i < prices.length-1 ;){
            while(i < prices.length-1 && prices[i] >= prices[i+1]){
                i++;
            }
            valley=prices[i];
            buyDay=i;
            while(i < prices.length-1 && prices[i] <= prices[i+1]){
                i++;
            }
            peak=prices[i];
            saleDay=i;
            maxProfit=maxProfit+ (peak - valley);
            System.out.println("Buy on day "+(buyDay + 1)+ " and sell on day "+(saleDay+1));
        }

        return maxProfit;

    }


    public static  int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };

        System.out.println("\nTotal profit earned is " + maxProfit(price));

        System.out.print("\nTotal profit earned is " + maxProfitWithDaynumber(price));
    }
}
