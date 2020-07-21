package org.ms.ds.dp.knapsack;

/*
https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.


we will be creating a matrix of array(row) and sum(column)

 */
public class SubsetSumProblem {
    boolean sss(int number[], int sum) {
        boolean t[][]=new boolean[number.length+1][sum+1];

        for(int i=0;i<number.length+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0 && j==0){
                    t[i][j]=true;
                }
                else if(i==0 ){
                    t[i][j]=false;
                }else if(j==0 ){
                    t[i][j]=true;
                }
            }
        }
        for(int i=1;i<number.length+1;i++){
            for(int j=1;j<sum+1;j++){
                //if item weight is lower than capacity
                if(number[i-1] <= j){
                    //first section shows item selected and second shows not selected
                    t[i][j] =   t[i-1][j-number[i-1]] || t[i-1][j];
                }else{
                    //if item weight is greater than capacity
                    t[i][j] =t[i-1][j];
                }
            }
        }
        return t[number.length][sum];

    }

    public static void main(String[] args) {
        SubsetSumProblem subsetSumProblem=new SubsetSumProblem();
        int []number= new int[]{3, 34, 4, 12, 5, 2};
        int sum=9;
        System.out.println("max value within capacity is "+ subsetSumProblem.sss(number,sum));
    }

}
