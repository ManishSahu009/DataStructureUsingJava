package org.ms.ds.dp.knapsack;

/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
For each integer, you should choose one from + and - as its new symbol.
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

 */
public class TargetSum {

    int ts(int []number , int sum){
       CountNoOfSubsetWithGivenDiff countNoOfSubsetWithGivenDiff=new CountNoOfSubsetWithGivenDiff();
       return countNoOfSubsetWithGivenDiff.cnosswgd(number,sum);
    }

    public static void main(String[] args) {
        TargetSum targetSum=new TargetSum();
        int []number= new int[]{1, 1, 2, 3};
        int sum=1;
        System.out.println("max value within capacity is "+ targetSum.ts(number,sum));
    }
}
