package org.ms.ds.dp.knapsack;

/*
https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.

Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11

if we divide the set in 2 subset then diff will definitely be b/w 0 to sum of set
min=range - 2s



 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumSubsetSumDiff {

    int mssd(int number[]) {
      int INT_MIN=Integer.MAX_VALUE;
      SubsetSumProblem subsetSumProblem=new SubsetSumProblem();
      int sum = Arrays.stream(number).sum();
      List<Integer> validSum=new ArrayList<>();
      for(int i=0;i<=sum;i++){
        if(subsetSumProblem.sss(number,i)){
            validSum.add(i);
        }
      }
      validSum= validSum.stream().limit(validSum.size()/2).collect(Collectors.toList());
      for(Integer i:validSum){
          INT_MIN=Integer.min(INT_MIN,sum-2*i);
      }
      return INT_MIN;
    }

    public static void main(String[] args) {
        MinimumSubsetSumDiff minimumSubsetSumDiff = new MinimumSubsetSumDiff();
        int[] number = new int[]{1, 6, 11, 5};
        System.out.println("max value within capacity is " + minimumSubsetSumDiff.mssd(number));
    }

}
