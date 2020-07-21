package org.ms.ds.dp.unboundedknapsack;

/*
https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents

 */
public class CoinChangeMinNoOfCoins {

    int ccmnoc(int coins[],int sum) {
        int t[][]=new int[coins.length+1][sum+1];

        if(coins.length==0 || sum==0){
            return 0;
        }
        for(int i=0;i<coins.length+1;i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = Integer.MAX_VALUE-1;
                } else if (i == 0) {
                    t[i][j] = Integer.MAX_VALUE-1;
                }
                else if (j == 0) {
                    t[i][j] = 0;
                }else if(i==1) {
                    if (j % coins[0] == 0) {
                        t[i][j] = j / coins[0];
                    } else {
                        t[i][j] = Integer.MAX_VALUE - 1;
                    }
                }
            }
        }


        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<sum+1;j++){
                //if item weight is lower than capacity
                if(coins[i-1] <= j){
                    //first section shows item selected and second shows not selected
                    t[i][j] = Integer.min(t[i][j-coins[i-1]]+1,t[i-1][j]);
                }else{
                    //if item weight is greater than capacity
                    t[i][j] =t[i-1][j];
                }
            }
        }
        return t[coins.length][sum];

    }

    public static void main(String[] args) {
        CoinChangeMinNoOfCoins coinChangeMinNoOfCoins=new CoinChangeMinNoOfCoins();
        int []coins =new int[]{9, 6, 5, 1 }; //weight
        int sum=12;
        System.out.println("max value within capacity is "+ coinChangeMinNoOfCoins.ccmnoc(coins,sum));
    }

}
