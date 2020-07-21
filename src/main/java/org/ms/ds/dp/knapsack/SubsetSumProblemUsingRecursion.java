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
public class SubsetSumProblemUsingRecursion {

    boolean isSubsetSum(int number[], int n,int sum) {

        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (number[n - 1] > sum)
            return isSubsetSum(number, n - 1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSum(number, n - 1, sum)
                || isSubsetSum(number, n - 1, sum - number[n - 1]);
    }

    public static void main(String[] args) {
        SubsetSumProblemUsingRecursion subsetSumProblem=new SubsetSumProblemUsingRecursion();
        int []number= new int[]{3, 34, 4, 12, 5, 2};
        int sum=9;
        System.out.println("max value within capacity is "+ subsetSumProblem.isSubsetSum(number,number.length,sum));
    }

}
