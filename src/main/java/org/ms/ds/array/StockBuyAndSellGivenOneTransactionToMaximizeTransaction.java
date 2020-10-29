package org.ms.ds.array;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
leet code : 121
https://www.youtube.com/watch?v=d0PZQWyeGZI
 */

public class StockBuyAndSellGivenOneTransactionToMaximizeTransaction {

    public static  int maxProfit(int[] prices) {

        if(prices.length == 0){
            return 0;
        }

        int min=Integer.MAX_VALUE;
        int profit=0;
        for (int i = 0; i < prices.length; i++) {
            min=Math.min(min,prices[i]);
            profit=Math.max(profit,prices[i] - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };
        System.out.println("\nTotal profit earned is " + maxProfit(price));

    }
}
