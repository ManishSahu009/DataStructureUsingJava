package org.ms.ds.dp.knapsack;

/*
https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3}

Input: arr[] = {1, 1, 1, 1}, X = 1
Output: 4
 */

public class CountOfSubsetSum {

    int coss(int number[], int sum) {
        int t[][]=new int[number.length+1][sum+1];

        for(int i=0;i<number.length+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0 && j==0){
                    t[i][j]=1;
                }
                else if(i==0 ){
                    t[i][j]=0;
                }else if(j==0 ){
                    t[i][j]=1;
                }
            }
        }
        for(int i=1;i<number.length+1;i++){
            for(int j=1;j<sum+1;j++){
                //if item weight is lower than capacity
                if(number[i-1] <= j){
                    //first section shows item selected and second shows not selected
                    t[i][j] =   t[i-1][j-number[i-1]] + t[i-1][j];
                }else{
                    //if item weight is greater than capacity
                    t[i][j] =t[i-1][j];
                }
            }
        }
        return t[number.length][sum];

    }

    public static void main(String[] args) {
        CountOfSubsetSum countOfSubsetSum=new CountOfSubsetSum();
        int []number= new int[]{1, 2, 3, 3};
        int sum=6;
        System.out.println("max value within capacity is "+ countOfSubsetSum.coss(number,sum));
    }

}
