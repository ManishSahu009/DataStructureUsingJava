package org.ms.ds.dp.unboundedknapsack;

/*
https://www.geeksforgeeks.org/coin-change-dp-7/
Given a value N, if we want to make change for N cents, and
we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
So output should be 4. For N = 10 and S = {2, 5, 3, 6},
there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.


 */
public class CoinChangeMaxWays {

    int ccmw(int coins[],int sum) {
        int t[][]=new int[coins.length+1][sum+1];

        if(coins.length==0 || sum==0){
            return 0;
        }
        for(int i=0;i<coins.length+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = 1;
                } else if (i == 0) {
                    t[i][j] = 0;
                } else if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<sum+1;j++){
                //if item weight is lower than capacity
                if(coins[i-1] <= j){
                    //first section shows item selected and second shows not selected
                    t[i][j] = t[i][j-coins[i-1]]+t[i-1][j];
                }else{
                    //if item weight is greater than capacity
                    t[i][j] =t[i-1][j];
                }
            }
        }
        return t[coins.length][sum];

    }

    public static void main(String[] args) {
        CoinChangeMaxWays coinChangeMaxWays=new CoinChangeMaxWays();
        int []coins =new int[]{2, 5, 3, 6 }; //weight
        int sum=10;
        System.out.println("max value within capacity is "+ coinChangeMaxWays.ccmw(coins,sum));
    }

}
