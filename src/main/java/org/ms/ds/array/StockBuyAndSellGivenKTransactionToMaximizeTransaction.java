package org.ms.ds.array;
/*
https://www.youtube.com/watch?v=thGK0PjLemk
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */

public class StockBuyAndSellGivenKTransactionToMaximizeTransaction {

    public static  int maxProfit(int[] prices, int k) {
        if(k==0 || prices.length==0)return 0;
        int[] profit = new int[prices.length];
        //part 2
        if(k>=prices.length/2){
            int p = 0;
            for(int i=1;i<prices.length;i++){
                if(prices[i]>prices[i-1]){
                    p = p+ prices[i]-prices[i-1];
                }
            }
            return p;
        }

        //part 1
        int min = prices[0] , p = 0;
        for(int i =0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            p = Math.max(p,prices[i]-min);
            profit[i]=p;
        }

        //k = 3
        for(int i=1;i<k;i++){
            ktimes(prices, profit);
        }

        int ans = 0;
        for(int i=0;i<profit.length;i++){
            ans = Math.max(profit[i],ans);
        }

        return ans;
    }

    static void ktimes(int[] prices,int[] profit){
        int b2 = Integer.MAX_VALUE;
        int p2 = 0;
        for(int i=0;i<prices.length;i++){
            b2 = Math.min(b2,prices[i]-profit[i]);
            p2 = Math.max(p2,prices[i]-b2);
            profit[i] = p2;
        }
    }

    public static void main(String[] args) {
        int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };
        System.out.println("\nTotal profit earned is " + maxProfit(price,3));

    }


}
