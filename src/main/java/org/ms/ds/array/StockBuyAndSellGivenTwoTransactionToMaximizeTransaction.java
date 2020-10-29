package org.ms.ds.array;

/*

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
https://www.youtube.com/watch?v=GFa9xlgZcEI
https://github.com/prakashshuklahub/Interview-Questions/blob/master/123%20Best%20Time%20to%20Buy%20and%20Sell%20Stock%20III
 */

public class StockBuyAndSellGivenTwoTransactionToMaximizeTransaction {

    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        // DP from left to right
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        // DP from right to left
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);

        }
        return profit;
    }

    public static  int maxProfit(int[] prices) {
        int b1 = Integer.MAX_VALUE;
        int b2 = Integer.MAX_VALUE;
        int p1 = 0 , p2 = 0;
        for(int i=0;i<prices.length;i++){
            b1 = Math.min(b1,prices[i]);
            p1 = Math.max(p1,prices[i]-b1);
            b2 = Math.min(b2,prices[i]-p1);
            p2 = Math.max(p2,prices[i]-b2);
        }
        return p2;
    }

    public static void main(String[] args) {
        int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };
        System.out.println("\nTotal profit earned is " + maxProfit(price));
        System.out.println("\nTotal profit earned is " + maxProfit1(price));

    }
}
